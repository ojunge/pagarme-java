package br.com.aspotato.pagarme.exceptions;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class RequiredFieldsException extends Exception {


    private static final long serialVersionUID = 3622473925538972589L;
   
    private ArrayList<Field> fields = new ArrayList<>();

	public ArrayList<Field> getFields() {
	    return fields;
    }

	public void setFields(ArrayList<Field> fields) {
	    this.fields = fields;
    }
    
}
