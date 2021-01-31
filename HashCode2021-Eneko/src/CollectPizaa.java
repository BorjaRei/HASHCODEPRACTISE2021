import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;



public class CollectPizaa {
	
	HashMap<Integer ,ArrayList<String>> listaGrupos = new HashMap<Integer,ArrayList<String>>();
	HashMap<Integer ,ArrayList<String>> listaGrupos2 = new HashMap<Integer,ArrayList<String>>();
	HashMap<Integer ,Integer> listaGruposAux = new HashMap<Integer,Integer>();
	HashMap<Integer ,Integer> listaGruposAux2 = new HashMap<Integer,Integer>();
	int numPizzas;
	 private static CollectPizaa miPizzeria=new CollectPizaa();
		
	 private CollectPizaa(){
	 		
	 	}

	 public static CollectPizaa getCollectPizza(){

	 		return miPizzeria;
	 	}
	  

	
	
	public void setNumPizzas(int numPizzas){
		this.numPizzas = numPizzas;
	}
	public void añadirPizza (int indice ,ArrayList<String> ingredientes){
		listaGrupos.put(indice, ingredientes);
		listaGrupos2.put(indice, ingredientes);
		listaGruposAux.put(indice, ingredientes.size());
		listaGruposAux2.put(indice, ingredientes.size());
		
	}
	
	//HAY QUE ORDENAR LISTAS POR CANTIDAD DE INGREDIENTES
	public HashMap<Integer ,ArrayList<String>> getLista(){
		return this.listaGrupos;
	}
	public HashMap<Integer ,ArrayList<String>> getLista2(){
		return this.listaGrupos2;
	}
	public HashMap<Integer ,Integer> getListaAux(){
		return this.listaGruposAux;
	}
	public HashMap<Integer ,Integer> getListaAux2(){
		return this.listaGruposAux2;
	}
	public static HashMap<Integer, Integer> sortByValue(final Map<Integer, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

	public void mostrarEnPantalla(HashMap<Integer, ArrayList<String>> listaGrupos3){
		
		for (Entry<Integer, ArrayList<String>> entry : listaGrupos3.entrySet()) {
		    Integer key = entry.getKey();
		    ArrayList<String> value = entry.getValue();
		    System.out.println(key + "hola");
		    System.out.println(value);
		    // ...
		}
    }
	
}
