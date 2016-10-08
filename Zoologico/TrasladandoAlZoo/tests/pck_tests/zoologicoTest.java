package pck_tests;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


import pck_zoologico.GeneradorRandom;
import pck_zoologico.Zoologico;

public class zoologicoTest {
	@Test
	public void Caso1(){
		Zoologico zoo = new Zoologico(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso1.in");
		String linea = zoo.resolver();
		zoo.generarSalida(linea, ".\\Ejecucion de la prueba\\Salida Obtenida\\Caso1.out");
		String [] campos = linea.split("\\s+");
		int res1 = 0;
		int res2 = 0;
		int res3 = 0;
		Scanner sc = null;
		try{
			sc = new Scanner(new File(".\\Preparacion de la prueba\\Lote de Prueba\\Salida Esperada\\Caso1.out"));
			res1 = sc.nextInt();
			res2 = sc.nextInt();
			res3 = sc.nextInt();
			sc.close();
		}catch(Exception e){
			System.out.println("Mensaje de la excepción: " + e.getMessage());
		}
		finally{
			sc.close();
		}
		Assert.assertTrue(Integer.parseInt(campos[0]) == res1 && Integer.parseInt(campos[1]) == res2 && Integer.parseInt(campos[2])== res3);
	}
	
	@Test
	public void Caso2(){
		Zoologico zoo = new Zoologico(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso2.in");
		String linea = zoo.resolver();
		zoo.generarSalida(linea, ".\\Ejecucion de la prueba\\Salida Obtenida\\Caso2.out");
	}
	
	@Test
	public void Caso3(){
		Zoologico zoo = new Zoologico(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso3.in");
		String linea = zoo.resolver();
		zoo.generarSalida(linea, ".\\Ejecucion de la prueba\\Salida Obtenida\\Caso3.out");
	}
	
	@Test
	public void Caso4(){
		Zoologico zoo = new Zoologico(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso4.in");
		String linea = zoo.resolver();
		zoo.generarSalida(linea, ".\\Ejecucion de la prueba\\Salida Obtenida\\Caso4.out");
	}
	/*
	@Test
	public void Caso5(){
		Zoologico zoo = new Zoologico(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso5.in");
		String linea = zoo.resolver();
		zoo.generarSalida(linea, ".\\Ejecucion de la prueba\\Salida Obtenida\\Caso5.out");
	}
	/*
	@Test
	public void Caso6(){
		GeneradorRandom generador = new GeneradorRandom(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso6.in",200,10000,10000);
		Zoologico zoo = new Zoologico(".\\Preparacion de la prueba\\Lote de Prueba\\Entrada\\Caso6.in");
		Calendar tIni = new GregorianCalendar();
		String linea = zoo.resolver();
		Calendar tFin = new GregorianCalendar();
		zoo.generarSalida(linea, ".\\Ejecucion de la prueba\\Salida Obtenida\\Caso6.out");
		System.out.println("Tiempo de resolución: "+ (tFin.getTimeInMillis() - tIni.getTimeInMillis()));
	}*/

}