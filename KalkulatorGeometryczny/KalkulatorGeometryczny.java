/**
 * Klasa KalkulatorGeometryczny
 */

public class KalkulatorGeometryczny {
    /**
     * zwraca pole kwadratu
     * @param a bok kwadratu
     * @return pole kwadratu
     */
    public static double calculateSquareArea(double a){
        if(a<0){
            throw new IllegalArgumentException("nie moze byc ujemne");
        }
        return a*a;
    }
    /**
     * zwraca pole kola
     * @param r promien
     * @return pole kola
     */
    public static double calculateCircleArea(double r){
        double pi = Math.PI;
        return pi*r*r;
    }
    /**
     * Główna metoda main
     * @param args argumenty dla main
     */
    public static void main(String[] args) {
        System.out.println(KalkulatorGeometryczny.calculateSquareArea(-4));
        System.out.println(KalkulatorGeometryczny.calculateCircleArea(3));
    }
}