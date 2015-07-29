package br.com.aspotato.pagarmetest;

import br.com.aspotato.pagarme.models.ZipCode;
import br.com.aspotato.pagarme.services.ZipCodeService;
import br.com.aspotato.pagarme.utils.PagarMeProvider;

public class ZipCodeTest {
	
	public static void main(String[] args) {
		PagarMeProvider instance = PagarMeProvider.getInstance();
		instance.setApi_key("minha_key");
		ZipCodeService service = new ZipCodeService();
		try {
	      ZipCode code =  service.findbyCode("89232545");
	      System.out.println(code.getStreet());
        } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
    }

}
