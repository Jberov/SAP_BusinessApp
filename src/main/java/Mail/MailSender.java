package Mail;
import DatabaseUtility.DBConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;



public class MailSender
{
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;
    public void sendmail(String mailMessage, String product){
        final String username = "";
        final String password = "";
        String address = getAddressFromDB (product);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(address)
            );
            message.setSubject("Declining quantities of " + product);
            message.setText(mailMessage);

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private  String getAddressFromDB(String product){
        try {
            DBConnectionHandler database =  DBConnectionHandler.getInstance ();
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select EmailTradeRep from products where Name=?");
            statement.setString (1, product);
            ResultSet rs = statement.executeQuery ();
            rs.next ();
            setAddress (rs.getString ("EmailTradeRep"));
        }catch (SQLException sqle){
            sqle.printStackTrace ();
        }
        return getAddress ();
    }
}