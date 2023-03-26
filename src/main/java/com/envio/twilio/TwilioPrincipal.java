package com.envio.twilio;

import java.util.ArrayList;
import java.util.List;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioPrincipal {
	
	 // Find your Account Sid and Token at twilio.com/console
	public static final String ACCOUNT_SID = "ACf4398d015179fbd205b40be641ec6e0d";
	public static final String AUTH_TOKEN = "df739fc65494cc9c9180f274667bcbd7";
	public static final List<String> telefonos = new ArrayList();
	
	
    public static void main( String[] args ){
    	
    	telefonos.add("+5215534292267");
    	//telefonos.add("+5217751528882");
    	telefonos.add("+5217751322050");
    	//telefonos.add("+5217714103589");
        
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
         // new PhoneNumber("whatsapp:+5215534292267"),
          new PhoneNumber("whatsapp:"+telefonos.get(0)),
          new PhoneNumber("whatsapp:+14155238886"),
          "Mensaje de prueba utilizando programacion Twilio desde Java")

        .create();
        
        for(int i = 1; i < telefonos.size(); i++) {
        
        	message = Message.creator(new PhoneNumber("whatsapp:"+telefonos.get(i)),
            message.getFrom(),
            message.getBody()).create();
        }

        System.out.println("Mensaje enviando con Exito!, SID: "+message.getSid());
        System.out.println(message.getFrom());
        System.out.println(message.getBody());
        
    }
}
