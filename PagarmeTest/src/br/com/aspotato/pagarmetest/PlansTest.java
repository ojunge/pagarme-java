package br.com.aspotato.pagarmetest;

import java.util.ArrayList;

import br.com.aspotato.pagarme.models.Plan;
import br.com.aspotato.pagarme.services.PlanService;
import br.com.aspotato.pagarme.utils.PagarMeProvider;

public class PlansTest {

	public static void main(String[] args) throws Exception {

		PagarMeProvider instance = PagarMeProvider.getInstance();
		instance.setApi_key("ak_test_ODYNfPAQpcGyttO3MpezjuzgVKmV9d");

		PlanService service = new PlanService();
		ArrayList<Plan>	plans = service.findAll();
		System.out.println(plans.get(0).getName());

	}

}
