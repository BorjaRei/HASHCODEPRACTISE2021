import java.util.*;
import java.util.Map.Entry;

public class main{
	
	private static main miMain=new main();
	//constructura
private main(){
		
	}

public static main getMenuPrincipal(){

		return miMain;
	}
public static void main(String[] args) {
	LecturaDeDatos.getLecturaDeDatos().readInFile("b_little_bit_of_everything.in");
	//Equipos.getEquipos().mostrarEnPantalla();
	//CollectPizaa.getCollectPizza().mostrarEnPantalla();
	//System.out.println(Equipos.getEquipos().equipos3);
	//System.out.println(Equipos.getEquipos().equipos4);
	//System.out.println();
	//System.out.println();
	LecturaDeDatos.getLecturaDeDatos().writeOutFile("aResult.txt");
	

}


}
