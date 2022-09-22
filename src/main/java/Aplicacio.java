import java.io.*;
import java.util.ArrayList;

public class Aplicacio {
    public static void main(String[] args) throws IOException {
        //Importació csv
        ArrayList<Alumne> alumnes = importar("C:\\Users\\ChristianPeronaAnadó\\OneDrive\\Coses_DAM\\idea_workspace\\DAM2_ACT1_UF1_llegir-i-escriure-fitxers\\src\\main\\resources\\informacio_alumnes.csv");

        //Mostrar els alumnes per la pantalla
        System.out.println("-----------------------\nNota de tots els alumnes:\n-----------");
        for (Alumne a : alumnes){
            System.out.println(a.toString());
        }

        //Mostrar per pantalla l'alumne amb nota mitjana més alta
        System.out.println("------------------------\nNota mitjana més alta:\n------------");
        Alumne alumneAmbMillorNota = cercarMillorNota(alumnes);
        System.out.println(alumneAmbMillorNota.toString());

        //Exportar a un altre csv els alumnes aprovats
        exportarAprovats("aprovats", alumnes);
    }

    public static ArrayList<Alumne> importar(String fitxer) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fitxer));
        ArrayList<Alumne> alumnes = new ArrayList<>();

        //Es repeteix el bucle per cada linia nova llegida
        String linia;
        while ((linia = bufferedReader.readLine()) != null){
            //Divisió de la linia prèviament llegida del csv
            String[] liniaSplit = linia.split(",");

            alumnes.add(new Alumne(liniaSplit[0], liniaSplit[1], liniaSplit[2], Double.parseDouble(liniaSplit[3])));
        }

        bufferedReader.close();

        return alumnes;
    }

    public static Alumne cercarMillorNota(ArrayList<Alumne> alumnes){
        Alumne alumne = null;
        double notaGran = 0.0;
        for (Alumne a : alumnes){
            if(a.getNotaMitja() >= notaGran){
                alumne = a;
            }
        }
        return alumne;
    }

    private static void exportarAprovats(String nomArxiu, ArrayList<Alumne> alumnes) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nomArxiu + ".csv"));

        for (Alumne a : alumnes){
            if(a.estaAprobat()){
                bufferedWriter.write(a.passarACSV(",") + "\n");
            }
        }

        bufferedWriter.close();
    }
}