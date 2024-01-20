package util;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EmailManager {

    private final Logger logger = Logger.getLogger(EmailManager.class);

    private final String username;
    private final String password;
    private final String recipient;

    public EmailManager(String recipient) throws IOException {
        this.username = Reader.readProperty("email");
        this.password = Reader.readProperty("password");
        this.recipient = recipient;
    }

    public void sendMail(String subject, String body, List<String> attachments){
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);
            logger.debug("preparing email configuration...");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html");
            // Creates multi-part
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // Adds Attachments
            if (!attachments.isEmpty()) {
                for (String singleAttachment : attachments) {
                    MimeBodyPart attachPart = new MimeBodyPart();
                    try {
                        attachPart.attachFile(singleAttachment);
                    } catch (Exception e) {
                        logger.error("Attaching files to email failed ...");
                        logger.error(e.getMessage());
                    }
                    multipart.addBodyPart(attachPart);
                }
            }
            logger.info("Step2> Attaching report files & error screenshots ...");

            message.setContent(multipart);
            // sends email
            logger.info("Step3> Sending email in progress...");
            Transport.send(message);
            logger.info("Step4> Sending email complete...");

        } catch (MessagingException e) {
            logger.error("Sending email failed...");
            e.printStackTrace();
        }
    }

}

