package contador.mapa;

import java.util.Map;
import java.util.TreeMap;

import contador.IContador;

public class ContadorMap implements IContador {

    public String contar(String frase) {
        String[] frases = frase.replaceAll("[\\d,.]", "").toLowerCase().split("\\s+");

        Map<String, Integer> mapa = new TreeMap<>();

        for (String frase1 : frases) {
            mapa.merge(frase1, 1, Integer::sum);
        }
        String s = "[";
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(!s.equals("[")) s = s.concat("; ");
            s = s.concat(key).concat("-").concat(value.toString());
        }
        return s.concat("]"); 
    }
}
