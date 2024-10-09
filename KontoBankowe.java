/**
* Klasa konta bankowego
* Realizuje wpłąty i wypłaty
* @author Jan Kowalski
* @version 1.0
*/

/**
 * Konstruktor klasy KontoBankowe
 * @param numerKonta numer konta w zapisie EU
 * @param saldoPoczatkowe wartość stanu konta
 * @throws IllegalArgumentException przechwycenie błędu numeru konta
 */
public class KontoBankowe {
    private String numerKonta;
    private double saldo;

    /**
     * Konstruktor klasy KontoBankowe
     * @param numerKonta numer konta w zapisie EU
     * @param saldoPoczatkowe 
     */
    public KontoBankowe(String numerKonta, double saldoPoczatkowe){
        if (numerKonta == null || numerKonta.isEmpty()) {
            throw new IllegalArgumentException("Błędny numer konta...");
        }
        this.numerKonta = numerKonta;
        this.saldo = saldoPoczatkowe;
    }

    /**
     * Metoda zwracająca saldo
     * @return zwraca aktualny stan konta
     */
    public double getSaldo(){
        return saldo;
    }

        /**
     * Metoda zwracająca numer konta
     * @return zwraca aktualny numer konta w formacie EU
     */
    public String getNumerKonta(){
        return numerKonta;
    }

    /**
     * Metoda obsługująca wpłatę na konto
     * @param kwota kwota wpłaty
     */
    public void wplata(double kwota) {
        if (kwota>0) {
            saldo += kwota;
            System.out.printf("Wpłacono %.2f PLN. Obecny stan konta to %.2f PLN.", kwota, saldo);
        }
        else {
            System.out.println("Kwota wpłaty nie może być ujemna lub zerowa");
        }
    }

        /**
     * Metoda obsługująca wypłącatę z konta
     * @param kwota kwota wypłąty
     */
    public void wyplata(double kwota) {
        if(kwota>0&&kwota<=saldo){
            saldo -=kwota;
            System.out.printf("Wypłacono %.2f PLN. Obecny stan konta to %.2f PLN.", kwota, saldo);
        }
        else {
            System.out.println("Kwota wypłaty nie może być ujemna lub większa od salda");
        }
    }

        /**
     * Metoda zwracająca stan konta
     */
    public void saldoShow() {
        this.getNumerKonta();
        System.out.println("\nSaldo: " + this.getSaldo() + "zł");
    }

        /**
     * Główna metoda main
     * @param args lista argumentó metody main
     */
    public static void main(String[] args) {
        KontoBankowe konto1 = new KontoBankowe("PL123123123123123", 1000);

        System.out.println("Numer konta: " + konto1.getNumerKonta());
        System.out.printf("Stan konta: %.2f \n", konto1.getSaldo());
        
        konto1.wplata(1000);
        konto1.saldoShow();
        konto1.wyplata(500);
        konto1.saldoShow();
        konto1.wyplata(20000);
        konto1.saldoShow();

    }

}
