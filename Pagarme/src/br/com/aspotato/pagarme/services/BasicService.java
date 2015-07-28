package br.com.aspotato.pagarme.services;

import java.lang.reflect.Field;
import java.util.ArrayList;

import br.com.aspotato.pagarme.anotations.FieldRequired;
import br.com.aspotato.pagarme.exceptions.RequiredFieldsException;

public abstract class BasicService {


	protected Boolean validateFiels(Object object) throws Exception{

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
