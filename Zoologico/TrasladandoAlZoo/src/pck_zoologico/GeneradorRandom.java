package pck_zoologico;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorRandom{
	public GeneradorRandom(String path,int cant_especie,int cant_hembras, int cant_machos) {
		PrintWriter fichero = null;
		int[] vector_especie = new int[cant_especie];
		try {
			fichero = new PrintWriter(new FileWriter(path));
			fichero.println(cant_especie + " " + cant_machos + " " + cant_hembras);
			for (int i = 0; i < vector_especie.length; i++) {
				Random rand = new Random();
				int randomNum = rand.nextInt((200 - 1) + 1) + 1;
				Random randTol = new Random();
				int randomNum1 = randTol.nextInt((10 - 1) + 1) + 1;
				
				vector_especie[i] = randomNum;
				fichero.println(randomNum + " " + randomNum1 );
			}
			for (int i = 0; i < cant_machos; i++) {
				int rnd = new Random().nextInt(vector_especie.length);
				fichero.println(vector_especie[rnd] );
			}
			for (int i = 0; i < cant_hembras; i++) {
				int rnd = new Random().nextInt(vector_especie.length);
				fichero.println(vector_especie[rnd] );
			}
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción : " + ex.getMessage());
		}
	}
}
