package com.conversor.ConversoDivisas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversor {

	HttpClient cliente;
	private String de;
	private String a;	
	private double monto;
	private String url ;
	
	//mapper para convertir objetos Java en formato JSON y viceversa
	ObjectMapper mapper = new ObjectMapper();
	
	
	
	
	public Conversor(String de, String a, double monto) {
		this.cliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
		this.de = de;
		this.a = a;
		this.monto = monto;
		//url para metodo get
		this.url = "https://api.apilayer.com/exchangerates_data/convert?to="+this.a+"&from="+this.de+"&amount="+this.monto;
	}


	public void mostrar() {
		//peticion al api
		HttpRequest peticion = HttpRequest.newBuilder().GET()
				.uri(URI.create(url))
				.header("apikey", "WYrGOM67x5cfwHU2PJgF1f9iR5DSmyes")//key de la api consumida
				.GET()
				.build();
				
		
		try {
			//respuesta
			HttpResponse<String> response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
			
			//JsonNode es una clase abstracta que tiene varias subclases concretas que representan diferentes tipos de nodos JSON, como objetos JSON, matrices JSON, valores JSON, etc. Cada subclase proporciona métodos para leer y manipular los datos en ese tipo de nodo JSON.
			
			JsonNode jsonNode = mapper.readTree(response.body());
			
			
			//impresion de resultados
			System.out.println("Convirtiendo "+monto+" "+de+" a "+a+ " resultado "+jsonNode.get("result").asText()+" "+a);
			System.out.println("tasa: "+jsonNode.get("info").get("rate").asText());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
