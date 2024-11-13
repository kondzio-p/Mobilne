import java.util.Scanner;

public class tabdwu {

    class Kalkulator {
        public void obliczSume(){

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kalkulator kalkulator = new Kalkulator();

        System.out.println("Podaj szerokosc (ilosc zmiennych)");
        int width = scanner.nextInt();
        System.out.println("Podaj dlugosc (ilosc tablic)");
        int length = scanner.nextInt();

        int[] tablicaGlowna = new int[length];

        for (int i=0;i<length;i++){
            tablicaGlowna[i] = int[] tablica = new int[width];
        }

        if (width == length){
            kalkulator.obliczSume();
        }
    }
}
