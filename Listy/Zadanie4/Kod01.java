package Zadanie4;
import java.util.ArrayList;
import java.util.List;

public class Kod01 {
    public static void main(String[] args) {
        int tab[] = {3,7,1,4,2,7,9,3,5};

        System.out.println("Wszystkie liczby: ");
        for (int ele : tab) {
            System.out.println(ele);
        }

        int druga = znajdzDruga(tab);
        System.out.println("Druga największa: " + druga);
    }

    public static int znajdzDruga(int[] tab) {
            
        int najwieksza = Integer.MIN_VALUE;
        int druganajwieksza = Integer.MIN_VALUE;
        
        for (int num : tab) {
            if (num>najwieksza) {
                druganajwieksza = najwieksza;
                najwieksza=num;
            }
            else if (num > druganajwieksza && num!= najwieksza){
                druganajwieksza = num;
            }
        }
        return druganajwieksza;
    }
}
