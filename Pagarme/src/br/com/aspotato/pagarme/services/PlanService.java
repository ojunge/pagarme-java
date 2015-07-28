package br.com.aspotato.pagarme.services;

import java.util.ArrayList;

import org.json.JSONObject;

import br.com.aspotato.pagarme.models.Plan;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class PlanService extends BasicService {

	private PagarMeProvider instance = PagarMeProvider.getInstance();

	public HttpResponse<JsonNode> save(Plan plan) throws Exception {
		HttpResponse<JsonNode> jsonResponse = null;
		if(validateFiels(plan)){
			jsonResponse = Unirest.post(instance.getUrl() + "1/plans")
					.header("accept", "application/json")
					.queryString("api_key", instance.getApi_key())
					.field("name", plan.getName())
					.field("amount", plan.getAmount().toString())
					.field("days", plan.getDays())
					.field("trial_days", plan.getTrial_days())
					.asJson();
		}

		return jsonResponse;
	}

	public HttpResponse<JsonNode> update(String name, int trial_days, String id) throws Exception {

		HttpResponse<JsonNode> jsonResponse = null;

		HttpRequestWithBody request =  Unirest.put(instance.getUrl() + "1/plans/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key());

		if(name != null){
			request.field("name", name);
		}
		if(trial_days !=-1){
			request.field("trial_days", Integer.toString(trial_days));
		}

		jsonResponse = request.asJson();

		return jsonResponse;
	}

	public Plan findbyId(String id) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/plans/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		Plan result = (Plan) PagarMeUtil.convertJsonToObject(Plan.class, resultObject);
		return result;
	}

	public ArrayList<Plan> findAll() throws Exception {

		ArrayList<Plan> plans = new ArrayList<Plan>();
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/plans")
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		for (int i = 0; i < jsonResponse.getBody().getArray().length(); i++) {
			JSONObject resultObject = jsonResponse.getBody().getArray().getJSONObject(i);
			plans.add((Plan) PagarMeUtil.convertJsonToObject(Plan.class, resultObject));
		}

		return plans;
	}

	public HttpResponse<JsonNode> delete(String id) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.delete(instance.getUrl() + "1/plans/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		return jsonResponse;
	}


}
