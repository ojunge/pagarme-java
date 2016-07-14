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
import br.com.aspotato.pagarme.exceptions.InvalidFormatException;
import br.com.aspotato.pagarme.exceptions.SubmitException;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.models.BankAccount;
import java.util.List;
import org.json.JSONArray;
import br.com.aspotato.pagarme.utils.PagarMeUtil;
import java.text.ParseException;
import org.json.JSONException;

public abstract class BasicService {

    protected PagarMeProvider instance = PagarMeProvider.getInstance();
    
    /**
     * Get generic data from Pagar.me resource using an ID as identifier 
     * @param resource to be used
     * @param id of record to be retrieved
     * @return JSON response object from Pagar.me
     * @throws UnirestException 
     */
    public Object getDataFromRemoteResouceWithId (Class<?> classe, String resource, String id) throws   UnirestException, 
                                                                                                        IllegalAccessException, 
                                                                                                        InvalidFormatException, 
                                                                                                        SubmitException, 
                                                                                                        InstantiationException, 
                                                                                                        JSONException, 
                                                                                                        ParseException  {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getBaseUrl() + resource + "/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
	JSONObject resultObject = jsonResponse.getBody().getObject();
        
        this.checkErrors(resultObject);
        
        return PagarMeUtil.convertJsonToObject(classe, resultObject);
    }
    
    public List<Object> getCollectionDataFromRemoteResource(Class<?> classe, String resource) throws Exception   {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getBaseUrl() + resource)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
        
	JsonNode resultObject = jsonResponse.getBody();
        
        this.checkErrors(resultObject);
        
        List retorno = new ArrayList<>();
        
        if (resultObject.isArray())     {
            JSONArray arr = resultObject.getArray();
            for (int i=0; i<arr.length(); i++)  {
                retorno.add(PagarMeUtil.convertJsonToObject(classe, arr.getJSONObject(i)));
            }
        }   else    {
            retorno.add(PagarMeUtil.convertJsonToObject(classe,resultObject.getObject()));
        }
        
        return retorno;
    }
    
    /**
     * Make a generic PATCH to a Pagar.me REST resource
     * @param resource to be used
     * @param dataObject POJO containing the data to be sent
     * @return JSON response object from Pagar.me
     * @throws Exception 
     */
    public JSONObject patchToRemoteResource(String resource, String objectID, Object dataObject) throws IllegalAccessException, UnirestException, InvalidFormatException, SubmitException {
        return this.submitToRemoteResource("PATCH", instance.getBaseUrl() + resource + "/" + objectID, dataObject);
    }
    
    /**
     * Make a generic PUT to a Pagar.me REST resource
     * @param resource to be used
     * @param dataObject POJO containing the data to be sent
     * @return JSON response object from Pagar.me
     * @throws Exception 
     */
    public JSONObject putToRemoteResource(String resource, String objectID, Object dataObject) throws IllegalAccessException, UnirestException, InvalidFormatException, SubmitException {
        return this.submitToRemoteResource("PUT", instance.getBaseUrl() + resource + "/" + objectID, dataObject);
    }
    
    /**
     * Make a generic post to a Pagar.me REST resource
     * @param resource to be used
     * @param dataObject POJO containing the data to be sent
     * @return JSON response object from Pagar.me
     * @throws Exception 
     */
    public JSONObject postToRemoteResource(String resource, Object dataObject) throws IllegalAccessException, UnirestException, InvalidFormatException, SubmitException {
        return this.submitToRemoteResource("POST", instance.getBaseUrl() + resource, dataObject);
    }
    
    
    /**
     * Make a generic submission with Body to a Pagar.me REST resource
     * @param method REST method to be used during the HTTP request
     * @param URI to be called
     * @param dataObject POJO containing the data to be sent
     * @return JSON response object from Pagar.me
     * @throws Exception 
     */
    public JSONObject submitToRemoteResource(String method, String URI, Object dataObject) throws IllegalAccessException, InvalidFormatException, SubmitException, UnirestException {

        
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
                if (ba!=null)   {
                    Class<?> tmpClass = ba.getClass();
                    for (Field subField : tmpClass.getDeclaredFields()) {
                        subField.setAccessible(true);
                        tmp = subField.get(ba);
                        if (tmp != null)    {
                            postFields.put("bank_account[" + subField.getName() + "]", tmp);
                        }
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
            if (method.equalsIgnoreCase("post")) {
                jsonResponse = Unirest.post(URI)
                                .header("accept", "application/json")
                                .fields(postFields)
                                .asJson();
            } else if (method.equalsIgnoreCase("put")) {
                jsonResponse = Unirest.put(URI)
                                .header("accept", "application/json")
                                .fields(postFields)
                                .asJson();
            } else if (method.equalsIgnoreCase("patch")) {
                jsonResponse = Unirest.patch(URI)
                                .header("accept", "application/json")
                                .fields(postFields)
                                .asJson();
            }
            
            JSONObject resultObject = jsonResponse.getBody().getObject();
            
            this.checkErrors(resultObject);
            
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
    
    /**
     * Method that checks if the return from Pagar.me contains errors.
     * @param resultObject
     * @throws IllegalAccessException, InvalidFormatException, SubmitException or 
     * UnirestException in case an error was returned from Pagar.me
     */
    protected void checkErrors(JSONObject resultObject) throws IllegalAccessException, InvalidFormatException, SubmitException, UnirestException { 
        if (resultObject.has("errors"))  {
            String errMessage;
            JSONArray errs = resultObject.getJSONArray("errors");
            if (errs.length()>0)    {
                JSONObject errDetails = errs.getJSONObject(0);                    
                if ((errDetails.has("parameter_name")) && (errDetails.has("message")))   {
                    errMessage = errDetails.getString("message") + " at " + errDetails.getString("parameter_name");  
                    throw new InvalidFormatException(errMessage);
                }   else if (errDetails.has("message"))     {
                    errMessage = errDetails.getString("message");
                    throw new SubmitException(errMessage);
                }
            }
            throw new UnirestException("Not defined error.");
        }        
    }
    
    
    /**
     * Method that checks if the return from Pagar.me contains errors.
     * @param resultObject A Node that contains the result from the call
     * @throws IllegalAccessException, InvalidFormatException, SubmitException or 
     * UnirestException in case an error was returned from Pagar.me
     */
    protected void checkErrors(JsonNode resultObject) throws IllegalAccessException, InvalidFormatException, SubmitException, UnirestException { 
        if (resultObject.isArray())     {
            JSONArray arr = resultObject.getArray();
            for (int i=0; i<arr.length(); i++)  {
                this.checkErrors(arr.getJSONObject(i));
            }
        }   else    {
            this.checkErrors(resultObject.getObject());
        }
    }
}
