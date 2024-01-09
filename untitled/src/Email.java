

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    private static Email email;
    private Email(){

    }
    public static Email getInstance(){
        if (email==null){
            email = new Email();
        }
        return email;
    }

    public void sendEmail(String to, String code){
        final String from = "lamchihung243@gmail.com";
        final String password = "pmib kwpz vbpv hiao";

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        };

        Session session = Session.getInstance(properties,auth);

        MimeMessage message = new MimeMessage(session);
        try {
            message.addHeader("Content-type","text/HTML; charset=UTF-8");
            message.setFrom(from);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
            String link = "http://localhost:8080/verify?email="+to+"&code="+code;
            message.setSubject("XÁC THỰC TÀI KHOẢN CG-SHOPEE-APP","UTF-8");
            message.setContent("<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch click v&agrave;o đường link dưới đ&acirc;y:</p>\n" +
                    "<p><a href=\""+link+"\">Nhấn v&agrave;o đ&acirc;y để x&aacute;c thực t&agrave;i khoản</a></p>","text/HTML");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
