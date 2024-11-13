import java.util.Scanner;
import java.util.random;
import.java.util.List;
import java.util.ArrayList;
import java.util.Random;

class ListaLiczb{
    private List<Integer> lista;
    public ListaLiczb(){
        this.lista = new ArrayList<>();
    }

    public void pobierzDane(int rozmiar) throws IllegalArgumentException{
        if (rozmiar <=0){
            throw new IllegalArgumentException ("Rozmiar musi byc wiekszy od 0 . .. ");
        }
        Random rd = new Random();
        lista.clear();

        for (int i=0;i<rozmiar;i++){
            lista.add(rd.nextInt(101));
        }
    }

    public int pobierzDlugosc(){
        return lista.size();
    }
}

public class Kod01 {

    
}
