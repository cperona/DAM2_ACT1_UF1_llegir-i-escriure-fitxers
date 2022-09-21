public class Alumne {
    private String nom;
    private String edat;
    private String cicle;
    private double notaMitja;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEdat() {
        return edat;
    }

    public void setEdat(String edat) {
        this.edat = edat;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public double getNotaMitja() {
        return notaMitja;
    }

    public void setNotaMitja(double notaMitja) {
        this.notaMitja = notaMitja;
    }

    public Alumne(String nom, String edat, String cicle, double notaMitja) {
        this.nom = nom;
        this.edat = edat;
        this.cicle = cicle;
        this.notaMitja = notaMitja;
    }

    @Override
    public String toString() {
        return  nom + ", " + "edat" + " " + edat + ", " + "estudia el cicle" + " " + cicle + " i " + "té una mitja de" + " " + notaMitja;
    }

    public String passarACSV(String separador){
        return nom + separador + edat + separador + cicle + separador + notaMitja;
    }

    public boolean estaAprobat(){
        return notaMitja >= 5.0;
    }
}
