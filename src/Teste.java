import br.com.aspotato.pagarme.models.BankAccount;
import br.com.aspotato.pagarme.services.BankAccountService;
import br.com.aspotato.pagarme.utils.PagarMeProvider;

public class Teste {

	public static void main(String[] args) {

		PagarMeProvider instance = PagarMeProvider.getInstance();
		instance.setApi_key("ak_test_ODYNfPAQpcGyttO3MpezjuzgVKmV9d");

		BankAccountService service = new BankAccountService();
		try {


			BankAccount bankAccount = service.findbyId("4840");
			System.out.println(bankAccount.getAgencia());
			//Balance balance = service.get();
			//System.out.println(balance.getObject());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
