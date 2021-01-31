import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Equipos {
	
	int equipos2;
	int equipos3 ;
	int equipos4;
	
	
	private static Equipos miEquipos=new Equipos();
	
	 private Equipos(){
	 		
	 	}

	 public static Equipos getEquipos(){

	 		return miEquipos;
	 	}
	  

	
	
	public void setEquipos(int equipo2 ,int equipo3 ,int equipo4){
		this.equipos2=equipo2;
		this.equipos3=equipo3;
		this.equipos4=equipo4;
		
	}
	public 	HashMap<Integer ,Integer> asignarGrupos() {
		HashMap<Integer ,Integer> listaGrupos = new HashMap<Integer,Integer>();
		listaGrupos.put(2, this.equipos2 );
		listaGrupos.put(3, this.equipos3);
		listaGrupos.put(4, this.equipos4);
		
		HashMap<Integer,Integer> fin = sortByValue(listaGrupos);
		return fin;
	}
	public static HashMap<Integer, Integer> sortByValue(final Map<Integer, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

	public void mostrarEnPantalla(){
		for (Map.Entry<Integer, Integer> entry : this.asignarGrupos().entrySet()) {
		    Integer key = entry.getKey();
		    Integer value = entry.getValue();
		    System.out.println(key);
		    System.out.println(value);
		    // ...
		}
    }
	
	public int entregaEquipos() {
		int num = 0;
		if(this.equipos2!=0) num++;
		if(this.equipos3!=0) num++;
		if(this.equipos4!=0) num++;
		return num;
	}

}
