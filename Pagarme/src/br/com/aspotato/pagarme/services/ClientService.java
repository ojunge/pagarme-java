package br.com.aspotato.pagarme.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import br.com.aspotato.pagarme.helpers.FormataHelper;
import br.com.aspotato.pagarme.models.Client;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class ClientService extends BasicService {


	private PagarMeProvider instance = PagarMeProvider.getInstance();

	public HttpResponse<JsonNode> save(Client client) throws Exception {
		HttpResponse<JsonNode> jsonResponse = null;
		Map<String, Object> fields = new HashMap<String, Object>();

		HttpRequestWithBody request =  Unirest.post(instance.getUrl() + "1/customers")
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key());

		if(validateFiels(client)){
			
			fields.put("name", client.getName());
			fields.put("email", client.getEmail());
//			fields.put("address[street]", client.getStreet());
//			fields.put("address[street_number]", client.getStreet_number());
//			fields.put("address[neighborhood]", client.getNeighborhood());
//			fields.put("address[zipcode]", client.getZipcode());
			fields.put("phone[ddd]", client.getDdd());
			//fields.put("phone[number]", client.getPhone());

			if(client.getDocument_number() != null)
				fields.put("document_number", client.getDocument_number());	
			if(client.getBorn_at() != null)
				fields.put("born_at", FormataHelper.formataData(client.getBorn_at()));
			if(client.getGender() != null)
				fields.put("gender", client.getGender());
//			if(client.getComplementary() != null)
//				fields.put("address[complementary]", client.getComplementary());
//			if(client.getCity()!= null)
//				fields.put("address[city]", client.getCity());
//			if(client.getState()!= null)
//				fields.put("address[state]", client.getState());
//			if(client.getCountry()!= null)
//				fields.put("address[country]", client.getCountry());
			if(client.getDdi()!= null)
				fields.put("phone[ddi]", client.getDdi());

			request.fields(fields);

			jsonResponse = request.asJson();
		}
		return jsonResponse;
	}
	
	public ArrayList<Client> findAll() throws Exception {

		ArrayList<Client> clients = new ArrayList<Client>();
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/customers")
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		for (int i = 0; i < jsonResponse.getBody().getArray().length(); i++) {
			JSONObject resultObject = jsonResponse.getBody().getArray().getJSONObject(i);
			clients.add((Client) PagarMeUtil.convertJsonToObject(Client.class, resultObject));
		}

		return clients;
	}
	
	public Client findbyId(String id) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/customers/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		
	Client client = (Client) PagarMeUtil.convertJsonToObject(Client.class, resultObject);
		
		return client;
	}


}
