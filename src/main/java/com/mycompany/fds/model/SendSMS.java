package com.mycompany.fds.model;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SendSMS {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC39d50b975902a2a3c06cc2d8986e3fc5";
    public static final String AUTH_TOKEN = "c5960b34c1f272c0999d3b8707212954";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+212654173553"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "b9at likom 2 d9aye9 ! hezzo ydikom hhhhhhhh")
                .create();
        System.out.println(message.getSid());
        System.out.println("Vous avez reçu un message !");
    }
}
