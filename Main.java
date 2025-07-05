import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EvidencePojistenych evidence = new EvidencePojistenych();

    boolean pokracovat = true;

        /*
         * Hlavní cyklus aplikace (menu).
         * Opakuje se dokud uživatel nezvolí konec.
         */
        do {
            System.out.println("-----------------------------");
            System.out.println("Evidence pojištěných");
            System.out.println("-----------------------------");
            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného");
            System.out.println("4 - Konec");

            //načteme si volbu od uživatele
            String volba = scanner.nextLine().trim();

        switch (volba) {

            /*
             * Přidá údaje pojištěného do seznamu,
             * pokud uživatel nezadá jméno nebo příjmení
             * údaje se neuloží
             */
            case "1":
                try {
                    System.out.println("\nZadejte jméno: ");
                    String jmeno = scanner.nextLine();

                    System.out.println("Zadejte příjmení: ");
                    String prijmeni = scanner.nextLine();

                    System.out.println("Zadejte telefonní číslo: ");
                    String telefon = scanner.nextLine();

                    System.out.println("Zadejte věk: ");
                    int vek = Integer.parseInt(scanner.nextLine());

                    evidence.pridej(new Pojisteny(jmeno, prijmeni, telefon, vek));
                    //Čekáme na Enter
                    System.out.println("\nData byla uložena. Pokračujte libovolnou klávesou…");
                    scanner.nextLine();
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                    scanner.nextLine();
                }

                break;


            /*
             * Vypíše všechny pojištěné v seznamu,
             * zároveň zkontroluje zda seznam není prázdný
             */
        case "2":
            List<Pojisteny> vsichni = evidence.vypisVse();
            if (vsichni.isEmpty()){
                System.out.println("\nSeznam je prázdný");
            } else {
                System.out.println();
                vsichni.forEach(System.out::println);
            }
            //Čekáme na Enter
            System.out.println("\nPokračujte libovolnou klávesou...");
            scanner.nextLine();
            break;

            /*
             * Program vyhledá pojištěného dle údajů zadaných uživatelem,
             * pokud se údaje nebudou shodovat s žádným pojištěným,
             * program vypíše chybu
             */
            case "3":
            System.out.println("\nZadejte jméno pojištěného: ");
            String hledaneJmeno = scanner.nextLine();
            System.out.println("Zadejte příjmení pojištěného: ");
            String hledanePrijmeni = scanner.nextLine();

            List<Pojisteny> nalezeni = evidence.najdi(hledaneJmeno, hledanePrijmeni);
            if (nalezeni.isEmpty()) {
                System.out.println("\nPojištěný nenalezen.");
            } else {
                System.out.println();
                nalezeni.forEach(System.out::println);
            }
                //Program čeká na Enter
                System.out.println("\nPokračujte libovolnou klávesou...");
            scanner.nextLine();
            break;

            //Ukončí program
            case "4":
                pokracovat = false;
                System.out.println("\nDěkujeme, nashledanou!");
                break;

                //Kontrola zda uživatel nezadal špatnou volbu
        default:
            System.out.println("\nNeplatná volba, zkuste to znovu.");
            //Čekáme na Enter
            System.out.println("Pokračujte libovolnou klávesou...");
            scanner.nextLine();
            break;
        }

        }while (pokracovat);
    }
}
