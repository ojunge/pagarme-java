package br.com.aspotato.pagarme.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import br.com.aspotato.pagarme.models.Model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PagarMeUtil {

	public static Object convertJsonToObject(Class<?> classe, JSONObject jsonObject) throws InstantiationException, IllegalAccessException, JSONException, ParseException {

		Object newObject = classe.newInstance();

		for (Field field : classe.getDeclaredFields()) {
			field.setAccessible(true);
			if (jsonObject.has(field.getName()) && jsonObject.get(field.getName()) != null && !jsonObject.get(field.getName()).equals(null)) {

				newObject = setData(field, jsonObject, newObject);
			}

		}

		return newObject;
	}

	public static Double strToDouble(String value) {
		Double result = new Double(0);
		if(value.length() > 2){
			value = value.substring(0, value.length() - 2) + "." + value.substring(value.length() - 2);
			result = new Double(value);	
		}
	
		return result;
	}

	public static Object setData(Field field, JSONObject jsonObject, Object newObject) throws IllegalArgumentException, IllegalAccessException, JSONException, InstantiationException, ParseException {
		//CAST INIT
		
		// field.getType().getSuperclass()
		if (field.getType().equals(String.class)) {

			field.set(newObject, jsonObject.getString(field.getName()));

		} else if (field.getType().equals(Double.class)) {

			String stringValue = jsonObject.get(field.getName()).toString();

			Double result = PagarMeUtil.strToDouble(stringValue);

			field.set(newObject, result);

		} else if (field.getType().equals(Boolean.class)) {

			field.set(newObject, jsonObject.getBoolean(field.getName()));

		} else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {

			field.set(newObject, jsonObject.getInt(field.getName()));
		} else if (field.getType().equals(Timestamp.class)) {
			String dateString = jsonObject.getString(field.getName());
			Timestamp date = strToDate(dateString);
			field.set(newObject, date);

		} else if (field.getType().equals(ArrayList.class)) {

			Class<?> subClass = getTypeFromArrayList(field);
			if (subClass != null) {
				JSONArray array = jsonObject.getJSONArray(field.getName());
				if (array != null && array.length() > 0) {

					ArrayList<Object> resultList = new ArrayList<>();

					for (int i = 0; i < array.length(); i++) {

						JSONObject subJsonObject = array.getJSONObject(i);
						Object newSubObject = jsonToObject(subJsonObject, subClass);
						resultList.add(newSubObject);

					}

					field.set(newObject, resultList);

				}

			}

		} else if (field.getType().getSuperclass().equals(Model.class)) {

			JSONObject subJsonObject = jsonObject.getJSONObject(field.getName());
			Object object = jsonToObject(subJsonObject, field.getType());
			field.set(newObject, object);
		}

		return newObject;
	}

	public static Class<?> getTypeFromArrayList(Field field) {

		ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
		Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
		return stringListClass;

	}

	public static Timestamp strToDate(String stringDate) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		//2015-07-03T12:52:29.000Z
		if (stringDate != null) {
			java.util.Date dateResult = formatter.parse(stringDate);
			return new Timestamp(dateResult.getTime());
		}
		return null;
	}

	public static Object jsonToObject(JSONObject jsonObject, Class<?> classe) throws IllegalArgumentException, IllegalAccessException, JSONException, InstantiationException, ParseException {

		Object newSubObject = classe.newInstance();
		for (Field subField : classe.getDeclaredFields()) {
			subField.setAccessible(true);
			if (jsonObject.has(subField.getName()) && jsonObject.get(subField.getName()) != null && !jsonObject.get(subField.getName()).equals(null)) {
				newSubObject = setData(subField, jsonObject, newSubObject);
			}

		}
		return newSubObject;
	}

}
