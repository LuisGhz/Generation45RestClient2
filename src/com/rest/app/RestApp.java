package com.rest.app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.model.Product;

public class RestApp {
	public static void main(String...a)
	{
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:8080/Generation45Rest/").path("Products");
		
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		
		Product product = new Product();
		product.setIdProduct(1);
		product.setProduct("Papas");
		product.setProductName("Valentin");
		product.setProductPrice(20.2);
		
		Response response = invocationBuilder.post(Entity.entity(product, MediaType.APPLICATION_JSON));
	}
}
