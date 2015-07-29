package br.com.aspotato.pagarmetest;

import java.util.ArrayList;

import br.com.aspotato.pagarme.models.Client;
import br.com.aspotato.pagarme.services.ClientService;
import br.com.aspotato.pagarme.utils.PagarMeProvider;

public class ClientsTest {

	public static void main(String[] args) throws Exception {
		PagarMeProvider instance = PagarMeProvider.getInstance();
		instance.setApi_key("minha_key");

		ClientService service = new ClientService();
		ArrayList<Client> clients = service.findAll();
		System.out.println(clients.size());
		
		Client client= service.findbyId("id_client");
		System.out.println(client.getName());
	}
}
