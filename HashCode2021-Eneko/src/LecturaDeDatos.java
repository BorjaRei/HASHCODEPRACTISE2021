import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.*;
public class LecturaDeDatos {
    String fileName;
  
   
    private static LecturaDeDatos milibreria=new LecturaDeDatos();
	
private LecturaDeDatos(){
		
	}

public static LecturaDeDatos getLecturaDeDatos(){

		return milibreria;
	}
 

    public void readInFile(String fileName) {
        this.fileName = fileName;

        try (FileReader fileReader = new FileReader("C:\\Users\\borja\\Downloads\\" + fileName)) {
            Scanner scanner = new Scanner(fileReader);

            int valor = scanner.nextInt();
            
           CollectPizaa.getCollectPizza().setNumPizzas(valor);
           
            int valor1 = scanner.nextInt();
            int valor2 = scanner.nextInt();
            int valor3 = scanner.nextInt();
            Equipos.getEquipos().setEquipos(valor1, valor2, valor3);
            int indice = 0;
            boolean chivato = true;
            while(chivato) {
            	int numIngredientes = scanner.nextInt();
            	int numIngredientesAux = numIngredientes;
            	ArrayList<String> ingredientes = new ArrayList<String>();
            	while (numIngredientes>0) {
            		String ingrediente = scanner.next();
            		ingredientes.add(ingrediente);
            		numIngredientes --;
            	}
            	CollectPizaa.getCollectPizza().añadirPizza(indice , ingredientes);
            	indice ++;
            	if(!scanner.hasNext()) chivato = false;
            	
            }
            //CollectPizaa.getCollectPizza().sortByValue(CollectPizaa.getCollectPizza().listaGrupos);

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }

    }
    
public ArrayList<Integer> asignar(int num ,HashMap<Integer ,ArrayList<String>> listaGrupos,HashMap<Integer ,Integer> listaGruposAux) {
	//HashMap<Integer ,Integer> listaEquipos = Equipos.getEquipos().asignarGrupos();
	
	return this.mayorCombinacion(num , listaGrupos ,listaGruposAux);
}

HashMap<Integer ,ArrayList<String>> listaGrupos = CollectPizaa.getCollectPizza().getLista();
HashMap<Integer ,ArrayList<String>> listaGrupos2 = CollectPizaa.getCollectPizza().getLista2();
HashMap<Integer ,Integer> listaGruposAux = CollectPizaa.getCollectPizza().getListaAux();
HashMap<Integer ,Integer> listaGruposAux2 = CollectPizaa.getCollectPizza().getListaAux2();

public ArrayList<Integer> mayorCombinacion(int integrantes ,HashMap<Integer ,ArrayList<String>> listaGrupos ,HashMap<Integer ,Integer> listaGruposAux) {
	// ORDENADA POR MAS INGREDIENTES
	ArrayList<Integer> resul = new ArrayList<Integer>();
	int i = 0;
	boolean j = true;
	int maxIngredientes = 0 ;
	ArrayList<String> ya_metidos = new ArrayList<String>();
	int contador = 0;
	int contadorMax =0;
	int keyMax = 0;
	//CollectPizaa.getCollectPizza().mostrarEnPantalla(listaGrupos);
	
	while((i<(integrantes-1)) && (!listaGrupos.isEmpty()) && (!listaGruposAux.isEmpty())) {		
		for (Entry<Integer, Integer> entry : listaGruposAux.entrySet()) {
			//System.out.println(j + "jjjjjj");
			if (j==true) {
				maxIngredientes = entry.getKey();
				//System.out.println(maxIngredientes + "jiodedddddddd");
				resul.add(maxIngredientes);
				ya_metidos.addAll(listaGrupos.get(maxIngredientes));
				System.out.println(ya_metidos);
			
			}else {
				int key = entry.getKey();
				//System.out.println(key + "jiode");
				ArrayList<String> ingredientes = listaGrupos.get(key);
				System.out.println(ingredientes);
				Iterator<String> iter = ingredientes.iterator();
				while(iter.hasNext()) {
					String ing =  iter.next();
					if(!ya_metidos.contains(ing)) {
					contador++;
					}
				}
				if(contador>=contadorMax) {
					contadorMax = contador;
					keyMax = key;
					ya_metidos.addAll(listaGrupos.get(key));
				}
				contador = 0;
			}
				j=false;
				//System.out.println(ya_metidos);
		}
			contadorMax = 0;
			System.out.println(keyMax +" max");
			listaGruposAux.remove(maxIngredientes);
			listaGruposAux.remove(keyMax);
			listaGrupos.remove(maxIngredientes);
			listaGrupos.remove(keyMax);
			resul.add(keyMax);
			i++;
		}
		return resul;
}


  public void writeOutFile(String salida) {
	  
	   try (FileWriter fileWriter = new FileWriter("C:\\Users\\borja\\Downloads\\" + salida, false)) {
		   ArrayList<Integer> p = new ArrayList<Integer>();
		    int contador = 0;
		  
		   for (Entry<Integer, Integer> entry : Equipos.getEquipos().asignarGrupos().entrySet()) {
				if (entry.getValue() != 0) {
					//System.out.println(this.listaGrupos);
					System.out.println(this.listaGruposAux);
					//System.out.println(entry.getKey());
					p = this.asignar(entry.getKey(),this.listaGrupos ,this.listaGruposAux);
					System.out.println(p.isEmpty());
					if(!p.isEmpty()) contador++;
				}
			}
			 fileWriter.write(contador + "\n");
			 
			 for (Entry<Integer, Integer> entry : Equipos.getEquipos().asignarGrupos().entrySet()) {
				if (entry.getValue() != 0) {
					p = this.asignar(entry.getKey(),this.listaGrupos2 ,this.listaGruposAux2);
					
					if(p.size() != 0)fileWriter.write(p.size() + " ");
					 Iterator<Integer> iter = p.iterator();
					 while(iter.hasNext()) {
						 int i =  iter.next();
						 fileWriter.write(i + " ");
					 }
				}
				if(p.size() != 0)fileWriter.write("\n");
			}
			
			
			
            }
             catch (IOException e) {
            System.out.println("Error " + e);
        }
    }
  
}
