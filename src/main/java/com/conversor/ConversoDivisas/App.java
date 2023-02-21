package com.conversor.ConversoDivisas;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String de="";
		String a="";
		double monto;
		int opc;
		Scanner entrada = new Scanner(System.in);

		System.out.println("Ingrese el importe a convertir");

		monto = entrada.nextDouble();

		System.out.println("elija moneda origen\n" + "1. COP\n" + "2. EUR\n" + "3. USD\n" + "4. AUD\n" + "5. GBP\n");

		opc = entrada.nextInt();
		switch (opc) {
		case 1:
            de = "COP";
			break;
		case 2:
			de = "EUR";
			break;
		case 3:
			de = "USD";
			break;
		case 4:
			de = "AUD";
			break;
		case 5:
			de = "GBP";
			break;
		default:
			break;
		}
		//agregue un comentario
		System.out.println("elija moneda destino\n" + "1. COP\n" + "2. EUR\n" + "3. USD\n" + "4. AUD\n" + "5. GBP\n");
		
		opc = entrada.nextInt();
		switch (opc) {
		case 1:
            a = "COP";
			break;
		case 2:
			a = "EUR";
			break;
		case 3:
			a = "USD";
			break;
		case 4:
			a = "AUD";
			break;
		case 5:
			a = "GBP";
			break;
		default:
			break;
		}

		Conversor prueba = new Conversor(de, a, monto);

		prueba.mostrar();
	}
}
