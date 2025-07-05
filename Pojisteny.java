public class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    /**
     * Vytvoří instanci
     * @param jmeno nesmí být prázdné
     * @param prijmeni nesmí být prázdné
     * @throws IllegalArgumentException
     * */
    public Pojisteny(String jmeno, String prijmeni, String telefon, int vek) {
        if (jmeno == null || jmeno.isBlank()
                || prijmeni == null || prijmeni.isBlank()) {
            throw new IllegalArgumentException("\nData nebyla uložena, jméno i příjmení musí být vyplněné. " +
                    "\nPokračujte libovolnou klávesou...");
        }
        this.jmeno = jmeno.trim();
        this.prijmeni = prijmeni.trim();
        this.telefon  = telefon == null ? "" : telefon.replaceAll("\\s+", "");
        this.vek = vek;
    }

     //Gettery
    public String getJmeno(){
        return jmeno;
    }
    public String getPrijmeni(){
        return prijmeni;
    }
    public int getVek(){
        return vek;
    }
    public String getTelefon(){
        return telefon;
    }


    /**
     * @return formátovaný text s údaji o pojištěném v zarovnaném formátu
     */
    @Override
    public String toString(){
        return String.format("%-10s %-10s %3d %s", jmeno, prijmeni, vek, telefon);
    }
}
