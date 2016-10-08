package pck_zoologico;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Zoologico {
	private int cant_especies;
	private int cant_machos;
	private int cant_hembras;
	
	private HashMap<Integer,Integer> gradoMap;
	private int[] vec_machos;
	private int[] vec_hembras;
	
	public Zoologico(String path){
		Scanner sc = null;
		try{
			sc = new Scanner(new File(path));
			cant_especies = sc.nextInt();
			cant_machos = sc.nextInt();
			cant_hembras = sc.nextInt();
			
			gradoMap = new HashMap<Integer,Integer>();
			
			for (int i = 0; i < cant_especies; i++) {
				gradoMap.put(sc.nextInt(), sc.nextInt());
			}
			vec_machos = new int[cant_machos];
			for (int i = 0; i < vec_machos.length; i++) {
				vec_machos[i] = sc.nextInt();
			}
			
			vec_hembras = new int[cant_hembras];
			for (int i = 0; i < vec_hembras.length; i++) {
				vec_hembras[i] = sc.nextInt();
			}
			
			sc.close();
		}catch(Exception e){
			System.out.println("Mensaje de la excepciónE: " + e.getMessage());
		}
		finally{
			sc.close();
		}
	}
	public int parejasCorrectas(){
		int res = 0;
		try{
			for (int i = 0; i < vec_hembras.length && i<vec_machos.length; i++) {
				if(vec_hembras[i] == vec_machos[i]){
					res++;
				}
			}
		}catch(Exception e){
			System.out.println("Mensaje de la excepción D: " + e.getMessage());
		}
		return res;
	}
	public int parejasPerdidas(){
		int res = 0;
		try{
			for (int i = 0; i < vec_hembras.length && i<vec_machos.length; i++) {
				if(Math.abs(gradoMap.get(vec_hembras[i]) - gradoMap.get(vec_machos[i]))>=4){
					res++;
				}
			}
		}catch(Exception e){
			System.out.println("Mensaje de la excepción C: " + e.getMessage());
		}
		return res;
	}
	public int mayorCantSupervivientes(){
		int max = 0;
		
		try{
			int imax = 0;
			if(vec_hembras.length < vec_machos.length){
				imax = vec_hembras.length;
			}
			else{
				imax = vec_machos.length;
			}
			int res = 0;
			for (int i = 0;(i < vec_hembras.length && i<vec_machos.length); i++) {
			//for (int i = 0;i < imax; i++) {
				if(Math.abs(gradoMap.get(vec_hembras[i]) - gradoMap.get(vec_machos[i]))<4 ){
					res++;
				}
				else
				{
					res = 0;
				}
				if(res > max){
					max = res;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Mensaje de la excepción B: " + e.getMessage());
			System.out.println("error2");
		}
		return max;
	}
	public String resolver(){
		return this.parejasCorrectas() + " " + this.parejasPerdidas() + " " + this.mayorCantSupervivientes();
	}
	public void generarSalida(String linea,String path){
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(path);

			fichero.write(linea + "\n");
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción A: " + ex.getMessage());
		}
	}
}

