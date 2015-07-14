package br.com.aspotato.pagarme.helpers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataHelper {

	public static String formataData(Object value){


		String DATE_FORMAT_NOW = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);

		if (value == null) {
			return "";
		}else if (value.getClass() == Timestamp.class) {
			Timestamp data = (Timestamp)value;
			return sdf.format(new Date(data.getTime()));
		}else if((value.getClass() == Date.class || value.getClass() == java.sql.Date.class  )){
			return sdf.format(value);
		}else{
			return "";
		}
	}
}
