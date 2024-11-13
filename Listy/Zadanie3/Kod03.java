package Zadanie3;
import java.util.HashMap;
import java.util.Map;

public class Kod03 {
    public static void main(String[] args) {

        Map<String, Integer> osoby = new HashMap<>();

        osoby.put("Jan",18);
        osoby.put("Adam",20);
        osoby.put("Zenon",30);
        osoby.put("Anita",12);
        osoby.put("Grzegorz",22);

        for(Map.Entry<String, Integer> entry: osoby.entrySet()) {
            String imie = entry.getKey();
            int wiek = entry.getValue();
            
            System.out.println(imie + " ma " + wiek + " lat");
        }

    }
}
