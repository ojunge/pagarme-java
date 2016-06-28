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
    
    public Recipient putRecipient(String objectId, Recipient request) throws Exception {
        JSONObject obj = this.putToRemoteResource(RESOURCE, objectId, request);
        Recipient resposta = (Recipient) PagarMeUtil.convertJsonToObject(Recipient.class, obj);
        return resposta;
        
    }
    
    public List<Recipient> getAllRecipients() throws Exception {
        
        List<Object> tmpLista = this.getCollectionDataFromRemoteResource(Recipient.class, RESOURCE);
        List<Recipient> retorno = new ArrayList<>();
        
        for (int i=0; i<tmpLista.size(); i++) {
            Recipient tmp = (Recipient) tmpLista.get(i);
            retorno.add(tmp);
        }
        return retorno;
    }
    
    public Recipient getRecipient(String id) throws Exception   {
        return (Recipient) this.getDataFromRemoteResouceWithId(Recipient.class, RESOURCE, id);
    }
    
}
