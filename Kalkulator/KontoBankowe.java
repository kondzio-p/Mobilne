/**
 * Klasa konta bankowego
 * Realizuje wplaty i wyplaty
 * @author Jan Kowalski
 * @version 1.0
 * 
 */

public class KontoBankowe {
    private String numerKonta;
    private double saldo;

    /**
     * Konstruktor klasy KontoBankowe
     * @param numerKonta przxechowuje nr konta
     * @param saldoPoczatkowe przehcowuje saldo poczatkowe
     * @throws IllegalArgumentException przechwycenie bledu danej
     */
    public KontoBankowe(String numerKonta, double saldoPoczatkowe){
        if (numerKonta == null||numerKonta.isEmpty()){
            throw new IllegalArgumentException("Błędny numer konta . . .");
        }
        this.numerKonta=numerKonta;
        this.saldo = saldoPoczatkowe;
    }

    /**
     * Metoda zwracajaca stan konta
     * @return aktualny stan konta
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Metoda zwracajaca numer konta w formacjie eu
     * @return zwraca numer konta w formacjie eu
     */
    public String getNumerKonta(){
        return numerKonta;
    }
    /**
     * Metoda obslugujaca wyplate z konta 
     * @param kwota kwota wyplaty
     */
    public void wplata(double kwota){
        if (kwota>0){
            saldo+=kwota;
            System.out.printf("wplacono %.2f PLN. Obecny stan konta to %.2f PLN.",kwota,saldo);
        }else{
            System.out.println("Kwota wplaty nie moze byc zerem lub ujemna");
        }
    }
    /**
     * wypala
     * @param kwota
     */
    public void wyplata(double kwota){
        if (kwota>0&&kwota<=saldo){
            saldo-=kwota;
            System.out.printf("wyplacono %.2f PLN. Obecny stan konta to %.2f PLN.",kwota,saldo);
        }else{
            System.out.println("Kwota wyplaty nie moze byc zerem lub ujemna");
        }
    }
    /**
     * wyswietla saldo
     */
    public void saldoShow(){
        System.out.println(" saldo: "+ saldo + "zl");
    }

    /**
     * Główna metoda main
     * @param args lista argumentow metody main
     */
    public static void main(String[]args){
        KontoBankowe konto1 = new KontoBankowe("PL1234123412341234",1000);

        System.out.println("numer konta: "+konto1.getNumerKonta());
        konto1.saldoShow();

        konto1.wplata(1000);
        konto1.saldoShow();

        konto1.wyplata(500);
        konto1.saldoShow();
        }
}
