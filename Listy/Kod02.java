import java.util.ArrayList;

public class Kod02 {
    public static void main(String[] args) {
        ArrayList<String> imiona = new ArrayList<String>();

        imiona.add("Anna");
        imiona.add("Zenek");
        imiona.add("Dariusz");

        for (String imie : imiona){
            System.out.println(imie);
        }

        imiona.sort(null);

        for (String imie : imiona){
            System.out.println(imie);
        }

        System.out.println("Rozmiar: "+ imiona.size());
    }
}
