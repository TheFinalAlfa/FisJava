import java.io.BufferedReader;
import java.util.HashMap;

public class Prijava {
    //
    // Razred, ki za odzivanja na vnos in spreminjanja podatke 
    //

    private Uporabnik prijavlenUporabnik;
	public static HashMap<String, Uporabnik> uporabniki = new HashMap<>();

    // Methodes

    boolean isAdmin(){
        return prijavlenUporabnik.getIsAdmin();
    }

    public void sporociloMoznosti(){
        System.out.println("Za registracijo vnesite (r)");
        System.out.println("Za prijavo vnesite (p)");
        System.out.println("Za zakljucek vnesite (q)");
    } 

    public void registrirati(BufferedReader bis) throws Exception{
        System.out.println("\nVnesite ime");
        String ime = bis.readLine();
        System.out.println("\nVnesite priimek");
        String priimek = bis.readLine();
        System.out.println("\nVnesite uporabnisko ime");
        String uporabniskoIme = bis.readLine();
        System.out.println("\nVnesite geslo");
        String geslo = bis.readLine();
        Prijava.registriratiNovo(uporabniskoIme, geslo, ime, priimek, false);
    }

    static void registriratiNovo(String uporabniskoIme, String geslo,
            String ime, String priimek, boolean isAdmin){
        //
        // Tukaj me moti, da metoda ni skrita, vendar je ne morem nastaviti
        // na private, ker je drugače childs ne vidijo...
        //
        if (Prijava.uporabniki.containsKey(uporabniskoIme)){
            System.out.println("Uporabnisko ime ni na voljo.");
        }
        else {
            Prijava.uporabniki.put(uporabniskoIme, new Uporabnik(ime,
                                          priimek, uporabniskoIme, geslo, isAdmin));
        };
    };

    public Prijava prijaviti(String uporabniskoIme, String geslo){
        if (!Prijava.uporabniki.containsKey(uporabniskoIme)){
            System.out.println("Uporabnisko ime ni pravilno.");
            return new Prijava();
        }
        else {
            if (!Prijava.uporabniki.get(uporabniskoIme).PravilnoGeslo(geslo)){
                System.out.println("Geslo je napačno.");
                return new Prijava();
            }
            else {
                if (Prijava.uporabniki.get(uporabniskoIme).getIsAdmin()){
                    return new PrijavaAdmin(uporabniskoIme);
                }
                else {
                    return new PrijavaUporabnik(uporabniskoIme);
                }
            }
        }
    };

    public void iskanje(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite.");
    }
    public void rezervirati(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite.");
    }
    public void mojeRezervacije(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite.");
    }
    public void vnosNovihPocitnic(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite kot administrator.");
    }
    public void spremeniPocitnice(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite kot administrator.");
    }
    public void odstraniPocitnice(BufferedReader bis) throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite kot administrator.");
    }
    public void iskanjePocitnicId(BufferedReader bis) throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite kot administrator.");
    }
    public void brisiUporabnik(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite kot administrator.");
    }
    public void pokaziVse(BufferedReader bis)throws Exception{
        System.out.println("Za uporabno te funkcionalnosti se prijavite kot administrator.");
    }

    // Constructors

    public Prijava(){
        this.prijavlenUporabnik = null;
    };

    public Prijava(String uporabniskoIme){
        this.prijavlenUporabnik = Prijava.uporabniki.get(uporabniskoIme);
    }

    public Uporabnik getPrijavlenUporabnik() {
        return prijavlenUporabnik;
    }
}
