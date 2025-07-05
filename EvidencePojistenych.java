import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EvidencePojistenych {
    private  List<Pojisteny> seznam = new ArrayList<>();

    //Přidá pojištěného do seznamu.
    public void pridej(Pojisteny p){
        seznam.add(p);
    }

    //Vrací všechny pojištěné v seznamu
    public List<Pojisteny> vypisVse(){
        return Collections.unmodifiableList(seznam);
    }

    /**
     * Najde všechny pojištěné se stejným jménem a příjmením (nerozlišuje velikost písmen).
     * @param jmeno hledané jméno
     * @param prijmeni hledané příjmení
     * @return seznam odpovídajících pojištěných (může být prázdný)
     */
    public List<Pojisteny> najdi(String jmeno, String prijmeni){
        List<Pojisteny> nalezeni = new ArrayList<>();
        for (Pojisteny p : seznam){
            if (p.getJmeno().equalsIgnoreCase(jmeno)
                    && p.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                nalezeni.add(p);
            }
        }
        return nalezeni;
    }
}
