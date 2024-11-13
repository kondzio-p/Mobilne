package Zadanie2;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Kod01 {
    public static void main(String[] args) {
        List<String> imiona = new ArrayList<>();

        imiona.add("Adam");
        imiona.add("Anna");
        imiona.add("Grzegorz");
        imiona.add("Piotr");
        imiona.add("Marek");

        System.out.println("Lista imion: " + imiona);

        Collections.reverse(imiona);

        for(String imie : imiona){
            System.out.println(imie);
        }
    }
}
