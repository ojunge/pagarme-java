package br.com.aspotato.pagarme.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import br.com.aspotato.pagarme.anotations.FieldRequired;
import br.com.aspotato.pagarme.exceptions.RequiredFieldsException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import br.com.aspotato.pagarme.anotations.PagarmeJsonProperty;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.models.BankAccount;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import br.com.aspotato.pagarme.models.Recipient;

public abstract class BasicService {

    private PagarMeProvider instance = PagarMeProvider.getInstance();
    
    /**
     * Get generic data from Pagar.me resource using an ID as identifier 
     * @param resource to be used
     * @param id of record to be retrieved
     * @return JSON response object from Pagar.me
     * @throws UnirestException 
     */
    public JSONObject getDataFromRemoteResouceWithId (String resource, String id) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getBaseUrl() + resource + "/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
	JSONObject resultObject = jsonResponse.getBody().getObject();
        
        return resultObject;
    }
    
    public List getCollectionDataFromRemoteResouce(String resource) throws Exception   {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getBaseUrl() + resource)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
        
	JsonNode resultObject = jsonResponse.getBody();
        List retorno = new ArrayList<>();
        
        if (resultObject.isArray())     {
            JSONArray arr = resultObject.getArray();
            for (int i=0; i<arr.length(); i++)  {
                retorno.add(arr.get(i));
            }
        }   else    {
            retorno.add(resultObject.getObject());
        }
        
        return retorno;
    }
    

    
    /**
     * Make a generic post to a Pagar.me REST resource
     * @param resource to be used
     * @param dataObject POJO containing the data to be sent
     * @return JSON response object from Pagar.me
     * @throws Exception 
     */
    public JSONObject postToRemoteResource(String resource, Object dataObject) throws IllegalAccessException, UnirestException {
		
        HttpResponse<JsonNode> jsonResponse = null;
        Class<?> classe = dataObject.getClass();
        Map<String, Object> postFields = new HashMap<>();
        Object tmp;
        PagarmeJsonProperty annoTmp;
                
        for (Field field : classe.getDeclaredFields()) {
            field.setAccessible(true);
            
            //Due Pagarme recieve an Array instead of JSON Object in their request
            //We have to define each class type and make the translation from Object 
            //to Array
            if (field.getType().equals(BankAccount.class))  {
                BankAccount ba = (BankAccount) field.get(dataObject); 
                Class<?> tmpClass = ba.getClass();
                for (Field subField : tmpClass.getDeclaredFields()) {
                    subField.setAccessible(true);
                    tmp = subField.get(ba);
                    if (tmp != null)    {
                        postFields.put("bank_account[" + subField.getName() + "]", tmp);
                    }
                }
            } else  {
                tmp = field.get(dataObject);
                if (tmp != null)    {
                    postFields.put(field.getName(), tmp);
                }
            }
        }
        
        if (postFields.size()>0)    {
            postFields.put("api_key", instance.getApi_key());
            jsonResponse = Unirest.post(instance.getBaseUrl() + resource)
                            .header("accept", "application/json")
                            .fields(postFields)
                            .asJson();
            JSONObject resultObject = jsonResponse.getBody().getObject();
            return resultObject;
            
        } else  {
            return null;
	}
    }
    
    protected Boolean validateFiels(Object object) throws Exception {

        Class<?> classe = object.getClass();
        ArrayList<Field> invalidFields = new ArrayList<>();

        for (Field field : classe.getDeclaredFields()) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(FieldRequired.class) && field.get(object) == null){
                        invalidFields.add(field);
                }
        }

        if(invalidFields.size()>0){
                RequiredFieldsException e = new RequiredFieldsException();
                e.setFields(invalidFields);
                throw e;
        }
        return true;
    }
    
   
}
