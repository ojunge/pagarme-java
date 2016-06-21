/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aspotato.pagarme.services;

import org.json.JSONObject;
import br.com.aspotato.pagarme.models.Recipient;
import br.com.aspotato.pagarme.utils.PagarMeUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeffprestes
 */
public class RecipientService extends BasicService {
    
    private final String RESOURCE = "recipients"; 
    
    public Recipient postNewRecipient(Recipient request) throws Exception {
        JSONObject obj = this.postToRemoteResource(RESOURCE, request);
        Recipient resposta = (Recipient) PagarMeUtil.convertJsonToObject(Recipient.class, obj);
        return resposta;
    }
    
    public List<Recipient> getAllRecipients() throws Exception {
        
        List<JSONObject> tmpLista = this.getCollectionDataFromRemoteResouce(RESOURCE);
        List<Recipient> retorno = new ArrayList<>();
        
        for (int i=0; i<tmpLista.size(); i++) {
            JSONObject tmpj = (JSONObject) tmpLista.get(i);
            Recipient tmp = (Recipient) PagarMeUtil.convertJsonToObject(Recipient.class, tmpj );
            retorno.add(tmp);
        }
        return retorno;
    }
    
}
