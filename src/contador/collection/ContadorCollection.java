package contador.collection;
import java.util.ArrayList;
import java.util.Arrays;

import contador.IContador;

public class ContadorCollection implements IContador{
    public String contar(String entrada) {
        String output = "[";
        ArrayList<String> palavras = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        String[] aux = entrada.toLowerCase().replaceAll("[\\d,.]", "").split(" ");
        
        Arrays.sort(aux);
        ArrayList<String> sorted = new ArrayList<String>(Arrays.asList(aux));
        
        for (String s : sorted) {
            if (!palavras.contains(s)) {
                palavras.add(s);
                quantidades.add(1);
            } else {
                Integer n = quantidades.remove(palavras.indexOf(s));
                quantidades.add(palavras.indexOf(s), n+1);
            }
        }
        for (int i = 0; i < palavras.size(); i++) {
            output += palavras.get(i)+'-';
            if (i != palavras.size()-1) {
                output += String.valueOf(quantidades.get(i))+"; ";
            } else {
                output += String.valueOf(quantidades.get(i))+"]";
            }
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        ContadorCollection c = new ContadorCollection();
        
        System.out.println(c.contar("This is a test, I hope this works propperly as I don't want to test it again."));
    }
}
