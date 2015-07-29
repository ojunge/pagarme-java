package br.com.aspotato.pagarmetest;

import java.util.ArrayList;

import br.com.aspotato.pagarme.models.Plan;
import br.com.aspotato.pagarme.services.PlanService;
import br.com.aspotato.pagarme.utils.PagarMeProvider;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class PlansTest {

	public static void main(String[] args) throws Exception {

		PagarMeProvider instance = PagarMeProvider.getInstance();
		instance.setApi_key("minha_key");

		// FIND ALL

		PlanService service = new PlanService();

		ArrayList<Plan>	plans = service.findAll();
		System.out.println(plans.get(0).getName());

		// BUSCAR POR ID
		Plan plan = service.findbyId("meuid");
		System.out.println(plan.getName());

		// ALTERAR PLANO
		HttpResponse<JsonNode> response =  service.update("TesteWeb2",  null, "meuid");
		if (response.getStatus()==200) 
			System.out.println("Item alterado com sucesso");

		// ADICIONAR PLANO
		Plan novo = new Plan();
		novo.setAmount(new Double(50.00));
		novo.setDays(30);
		novo.setTrial_days(10);
		novo.setName("Novo Item");
		HttpResponse<JsonNode> response2 = service.save(plan);
		if (response2.getStatus()==200) 
			System.out.println("Item adicionado com sucesso");

		// REMOVER PLANO
		service.delete("meuid");

	}

}
