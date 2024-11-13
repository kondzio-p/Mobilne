import java.util.Random;
import java.util.ArrayList;
import java.util.List;

class Lista{
    private List<Integer> lista;

    public Lista(int dlugosc){
        lista = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<dlugosc;i++) {
            lista.add(random.nextInt(1,101));
        }
    }

    public List<Integer> getLista(){
        return lista;
    }

    public static List<Integer> dodajListy(List<Integer> listaA, List<Integer> listaB) {
        List<Integer> listaWynikow = new ArrayList<>();
        int minimalna = Math.min(listaA.size(), listaB.size());

        for(int i=0; i < minimalna; i++) {
            listaWynikow.add(listaA.get(i) + listaB.get(i));
        }

        if (listaA.size() > listaB.size()) {
            listaWynikow.addAll(listaA.subList(minimalna, listaA.size()));
        } 
        else if (listaA.size() < listaB.size()) {
            listaWynikow.addAll(listaB.subList(minimalna, listaB.size()));
        }
        return listaWynikow;
    }
}

public class Kod01 {
    public static void main(String[] args) {
        Lista lista1 = new Lista(10);
        Lista lista2 = new Lista(5);

        System.out.println("Lista1: " + lista1.getLista());
        System.out.println("Lista2: " + lista2.getLista());

        List<Integer> listaWynikow = Lista.dodajListy(lista1.getLista(), lista2.getLista());
        System.out.println("Wyniki: " + listaWynikow);
    }    
}