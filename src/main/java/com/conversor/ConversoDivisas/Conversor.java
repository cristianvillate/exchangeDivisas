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
	private double priceExchange;
	private double result;
	
	ObjectMapper mapper = new ObjectMapper();
	
	
	
	
	public Conversor(String de, String a, double monto) {
		this.cliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
		this.de = de;
		this.a = a;
		this.monto = monto;
		this.url = "https://api.apilayer.com/exchangerates_data/convert?to="+this.a+"&from="+this.de+"&amount="+this.monto;
	}


	public void mostrar() {
		HttpRequest peticion = HttpRequest.newBuilder().GET()
				.uri(URI.create(url))
				.header("apikey", "WYrGOM67x5cfwHU2PJgF1f9iR5DSmyes")
				.GET()
				.build();
				
		
		try {
			HttpResponse<String> response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
			
			//JSONArray jsonArray = new JSONArray(mapper.readTree(response.body()));
			//JSONObject jsonObject = jsonArray.getJSONObject(0);
			JsonNode jsonNode = mapper.readTree(response.body());
			
			
			
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
