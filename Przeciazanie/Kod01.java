import java.util.Scanner;

class Kalkulator{
    public int dodaj(int a, int b){
        return a+b;
    }

    public double dodaj(double a, double b){
        return a+b;
    }

    public int dodaj(String a, String b){
        return Integer.parseInt(a)+Integer.parseInt(b);
    }


}
public class Kod01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kalkulator kalkulator = new Kalkulator();

        System.out.println("Wybierz typ dla kalkulatora: ");
        System.out.println("1 - liczby calkowite int");
        System.out.println("2 - liczby rzeczywiste");
        System.out.println("3 - Stringi (liczby w postaci stringa)");
        int wybor = scanner.nextInt();

        switch (wybor){
            case 1:
            System.out.println("Podaj liczbe calkowita: ");
            int int1 = scanner.nextInt();
            System.out.println("Podaj druga liczbe: ");
            int int2 = scanner.nextInt();
            int wynikInt = kalkulator.dodaj(int2,int1);
            System.out.println("wynik dodawania liczb to: "+wynikInt);
            break;

            case 2:
            System.out.println("Podaj liczbe calkowita: ");
            double d1 = scanner.nextDouble();
            System.out.println("Podaj druga liczbe: ");
            double d2 = scanner.nextDouble();
            double wynikD = kalkulator.dodaj(d1,d2);
            System.out.println("wynik dodawania liczb to: "+wynikD);
            break;

            case 3:
            System.out.println("Podaj liczbe calkowita: ");
            String str1 = scanner.next();
            System.out.println("Podaj druga liczbe: ");
            String str2 = scanner.next();
            int wynikStr = kalkulator.dodaj(str1,str2);
            System.out.println("wynik dodawania liczb to: "+wynikStr);
            break;


        }
    }
}
