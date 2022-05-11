import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        Prijava prijava = new Prijava();
        FileManager.readFromFileUporabniki("uporabniki.txt");
        FileManager.readFromFilePocitnice("pocitnice.txt");
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        mainLoop:
        while (true){
            System.out.println("\n");
            prijava.sporociloMoznosti();
            String input = bis.readLine();
            System.out.println("\n");
            switch (input){
                case "q":
                break mainLoop;
                case "r":{
                    prijava.registrirati(bis);
                    FileManager.writeToFileUporabniki("uporabniki.txt");
                    }
                break;
                case "p":{
                    // Prijava
                    System.out.print("\nVnesite uporabnisko ime:\n");
                    String uporabniskoIme = bis.readLine();
                    System.out.print("\nVnesite geslo:\n");
                    String geslo = bis.readLine();
                    prijava = prijava.prijaviti(uporabniskoIme, geslo);
                    }
                break;
                case "m":{
                    prijava.mojeRezervacije(bis);
                }
                break;
                case "b":{
                    prijava.brisiUporabnik(bis);
                    FileManager.writeToFileUporabniki("uporabniki.txt");
                }
                break;
                case "n":{
                    prijava.vnosNovihPocitnic(bis);
                    FileManager.writeToFilePocitnice("pocitnice.txt");
                }
                break;
                case "a":{
                    prijava.pokaziVse(bis);
                }
                break;
                case "s":{
                    prijava.spremeniPocitnice(bis);
                    FileManager.writeToFilePocitnice("pocitnice.txt");
                }
                break;
                case "e":{
                    prijava.odstraniPocitnice(bis);
                    FileManager.writeToFilePocitnice("pocitnice.txt");
                }
                break;
                case "v":{
                    prijava.mojeRezervacije(bis);
                }
                break;
                case "d":{
                    prijava.iskanje(bis);
                }
                break;
                case "t":{
                    prijava.rezervirati(bis);
                    FileManager.writeToFilePocitnice("pocitnice.txt");
                }
                break;
                default:
                    System.out.println("\nVnos je napacen\n");
            }
        };
        bis.close();
    }
}
