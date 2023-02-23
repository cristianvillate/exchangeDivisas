package com.conversor.ConversoDivisas;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) {
		String[] monedas = { "COP", "EUR", "USD", "AUD", "GBP" };
		String[] opciones = { "SI", "NO" };
		String continua;
		String de;
		String a;
		Double monto;
		int opc;
		do {
			try {
				monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese monto a convertir:",
						"Ingreso de datos", JOptionPane.PLAIN_MESSAGE));
				opc = JOptionPane.showOptionDialog(null, "Seleccione Divisa Origen", "Opciones de divisas",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, monedas, monedas[0]);
				de = monedas[opc];
				opc = JOptionPane.showOptionDialog(null, "Seleccione Divisa Destino", "Opciones de divisas",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, monedas, monedas[0]);

				a = monedas[opc];
				Conversor exchange = new Conversor(de, a, monto);

				exchange.mostrar();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"El monto ingresado debe ser mayor a 0 y estar en formato numérico. Actualmente ha ingresado: "
								+ e.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			opc = JOptionPane.showOptionDialog(null, "Desea realizar otra Conversion?", "Opciones",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			continua = opciones[opc];
		} while (continua.equalsIgnoreCase("SI"));

		JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR NUESTRO EXCHANGE", "Resultado",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
