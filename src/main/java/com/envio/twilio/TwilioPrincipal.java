package com.envio.twilio;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;


public class TwilioPrincipal {
	
	 // Find your Account Sid and Token at twilio.com/console
	public static final String ACCOUNT_SID = "ACf4398d015179fbd205b40be641ec6e0d";
	public static final String AUTH_TOKEN = "df739fc65494cc9c9180f274667bcbd7";
	
    public static void main( String[] args ){
        
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
          new PhoneNumber("whatsapp:+5215534292267"),
          new PhoneNumber("whatsapp:+14155238886"),
          "Saludos Twilio desde Java")

        .create();

        System.out.println(message.getSid());
    }
}
