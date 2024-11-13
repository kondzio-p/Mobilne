import java.util.Scanner;

class Kalkulator{
    public int mnozenie(int[] tabInt){
        int iloczyn = 0;
        for (int i=0;i<tabInt.length;i++) {
            iloczyn+=tabInt[i];
        }
        return iloczyn;
    }

    public double mnozenie(double[] tabD){
        double iloczyn = 0;
        for (int i=0;i<tabD.length;i++) {
            iloczyn+=tabD[i];
        }
        return iloczyn;
    }
}
public class Matematyka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kalkulator kalkulator = new Kalkulator();
        System.out.println("Ile liczb chcessz wprowadzic? ");
        int iloscLiczb = scanner.nextInt();
        System.out.println("Jakiego typu beda liczby? ");
        int typLiczb = scanner.nextInt();
        System.out.println("Wprowadz liczby: ");

        if(typLiczb==1){
            int[] tablicaInt = new int[iloscLiczb];
            for(int i=0;i<iloscLiczb;i++){
                int liczba = scanner.nextInt();
                tablicaInt[i] = liczba;
            }
            int wynikInt = kalkulator.mnozenie(tablicaInt);
            System.out.println("wynik to"+wynikInt);
        }
        else if(typLiczb==2){
            double[] tablicaDouble = new double[iloscLiczb];
            System.out.println("Wprowadz liczby: ");
            for(int i=0;i<iloscLiczb;i++){
                double liczba = scanner.nextDouble();
                tablicaDouble[i] = liczba;
            }
            double wynikDouble = kalkulator.mnozenie(tablicaDouble);
            System.out.println("wynik to"+wynikDouble);
        }
        
    }
}
