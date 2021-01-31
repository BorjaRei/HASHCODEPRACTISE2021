import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class borja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String dataset="c_many_ingredients.in";
		String dataset="c_many_ingredients.in";
		//String dataset="b_little_bit_of_everything.in";
		HashMap<Integer, Integer> pesoPizza=new HashMap<Integer, Integer>();
		HashMap<Integer, ArrayList<String>> asignaciones= new HashMap<Integer, ArrayList<String>>();
		
		ArrayList<Integer> g4= new ArrayList<Integer>();
		ArrayList<Integer> g3= new ArrayList<Integer>();
		ArrayList<Integer> g2= new ArrayList<Integer>();
		HashSet<Integer> pizzasAsignadas=new HashSet<Integer>();
		
        try (FileReader fileReader = new FileReader("C:\\Users\\borja\\Downloads\\" + dataset)) {
            Scanner scanner = new Scanner(fileReader);
            int numPizzas = scanner.nextInt();
            int pizzasRes=numPizzas;
            System.out.println("Pizzas:"+numPizzas);
            int grupo2 = scanner.nextInt();
            int grupo3 = scanner.nextInt();
            int grupo4 = scanner.nextInt();
           //CARGAR LOS DATOS 
            int i=0;
            while(scanner.hasNext()) {
            	int numIngredientes = scanner.nextInt();
            	int aux=numIngredientes;
            	System.out.println(i);
            	ArrayList<String> ingredientes = new ArrayList<String>();
            	while (aux>0) {
            		String ingrediente = scanner.next();
            		//System.out.print(ingrediente);
            		ingredientes.add(ingrediente);
            		aux --;
            	}
            	
            	pesoPizza.put(i, numIngredientes);
            	asignaciones.put(i, ingredientes);
            	i++;
            }
            scanner.close();
             //ORDENAR LAS KEYS DE PESOPIZZA EN FUNCION DEL Nº DE INGREDIENTES
            final Map<Integer, Integer> sortedByCount = sortByValue(pesoPizza);
            Set<Integer> se=sortedByCount.keySet();
            Object[] pPesoOrd=se.toArray();

            //ALGORITMO ASIGNACION DE PIZZAS
            //USAREMOS pPesoOrd, pesoPizza, asignaciones, pizzasAsignadas
            boolean fin=false;
            while(pizzasRes>numPizzas && !fin) {
            	int grup=0;
            	//SELECCIONAR GRUPO AL QUE VAMOS A ENTREGAR PIZZAS
            	if(grupo4>0) {grup=4;}
            	else if(grupo3 >0) {grup=3;}
            	else if(grupo2>0) {grup=2;}
            	else{fin=true;}
            	//PRIMERA ASIGNACION DE PIZZA
            	HashSet<String> ing=new HashSet<String>();
            	ArrayList<String> ling;
            	
            	boolean pchi=false;
            	int in=0;
            	while(!pchi) {
            		if(!pizzasAsignadas.contains(pPesoOrd[in])) {
            			pchi=true;//PARA SALIR
            			Integer it=(Integer) pPesoOrd[in];
            			pizzasAsignadas.add(it);
            			
            			//INTRODOCIR LOS NUEVOS INGREDIENTES DEL GRUPO
            			ling=asignaciones.get(pPesoOrd[in]); 
            			for(int j=0; j>ling.size();j++) {
            				ing.add(ling.get(j));
            			}
            		}
            		else {
            			in++;
            		}
            	}
            	
            	//BUCLE PARA ASIGNAR PIZZAS RESTANTES
            	
            }
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
       
     
	}
	
	public static HashMap<Integer, Integer> sortByValue(final Map<Integer, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

}
