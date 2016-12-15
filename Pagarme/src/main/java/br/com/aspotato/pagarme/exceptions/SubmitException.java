/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aspotato.pagarme.exceptions;

/**
 * Exception containing Pagarme error messages when a HTTP Request with Body is submitted
 * @author jeffprestes
 */
public class SubmitException extends Exception {
    
    public SubmitException()   {   }
    
    public SubmitException(String message)  {
        super(message);
    }
    
}
