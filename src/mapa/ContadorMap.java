package mapa;

import java.util.Map;
import java.util.TreeMap;

public class ContadorMap {
	public static void main(String[] args) {
		String frase = "Eu estou escrevendo um programa, mas eu não tenho um programa para escrever";
		String[] frases = frase.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

		Map<String, Integer> mapa = new TreeMap<>();
		
		for (int i = 0; i < frases.length; i++) {
			mapa.merge(frases[i], 1, Integer::sum);
		}
		mapa.forEach((palavra, quantidade) -> System.out.println(palavra+" "+quantidade));
	}
}