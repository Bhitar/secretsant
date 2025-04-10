package Service;



import jdk.internal.access.JavaNetHttpCookieAccess;
import jdk.internal.foreign.SystemLookup;
import java.net.MulticastSocket;

import java.io.IOException;

import java.nio.channels.DatagramChannel;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.nio.channels.DatagramChannel;
import java.util.*;

public class EmailService {

    private final String fromEmail;
    private String password = "";
    private final Properties properties;

    public DatagramChannel channel = DatagramChannel.open();
    static DatagramChannelImpl Transport;
    private Object giver;
    private Object receiver;


    public EmailService(String fromEmail) throws IOException {
        this.fromEmail = fromEmail;
        this.password = password;

        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
    }

    public void sendAssignmentEmail() throws MessagingException, JMSException {
        SystemLookup Session = null;
        SystemLookup session = SystemLookup.getInstance();

        Message message;
        message = new MimeMessage(session);
        message.setFloatProperty(new InternetAddress(fromEmail).toString(),0.15f);
        JavaNetHttpCookieAccess InternetAddress = null;
        try {
            message.setJMSExpiration(RecipientType.TO);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        message.setObjectProperty("Your Secret Santa Assignment ",true);


        String emailContent = "Hi %s,\n\nYou have been chosen as the Secret Santa for: %s.\nPlease keep it a secret and surprise them with a thoughtful gift!\n\nHappy Gifting!\nSecret Santa Organizer".formatted(giver.toString(), receiver.toString());

        message.setJMSType(emailContent);
        DatagramChannel lImpl = null;
        EmailService.Transport.bind(message);
    }

    public class MessagingException extends Exception {
    }

    private class MimeMessage implements Message {
        public MimeMessage(SystemLookup session) {
        }

        @Override
        public String getJMSMessageID() throws JMSException {
            return "";
        }

        @Override
        public void setJMSMessageID(String s) throws JMSException {

        }

        @Override
        public long getJMSTimestamp() throws JMSException {
            return 0;
        }

        @Override
        public void setJMSTimestamp(long l) throws JMSException {

        }

        @Override
        public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
            return new byte[0];
        }

        @Override
        public void setJMSCorrelationIDAsBytes(byte[] bytes) throws JMSException {

        }

        @Override
        public void setJMSCorrelationID(String s) throws JMSException {

        }

        @Override
        public String getJMSCorrelationID() throws JMSException {
            return "";
        }

        @Override
        public Destination getJMSReplyTo() throws JMSException {
            return null;
        }

        @Override
        public void setJMSReplyTo(Destination destination) throws JMSException {

        }

        @Override
        public Destination getJMSDestination() throws JMSException {
            return null;
        }

        @Override
        public void setJMSDestination(Destination destination) throws JMSException {

        }

        @Override
        public int getJMSDeliveryMode() throws JMSException {
            return 0;
        }

        @Override
        public void setJMSDeliveryMode(int i) throws JMSException {

        }

        @Override
        public boolean getJMSRedelivered() throws JMSException {
            return false;
        }

        @Override
        public void setJMSRedelivered(boolean b) throws JMSException {

        }

        @Override
        public String getJMSType() throws JMSException {
            return "";
        }

        @Override
        public void setJMSType(String s) throws JMSException {

        }

        @Override
        public long getJMSExpiration() throws JMSException {
            return 0;
        }

        @Override
        public void setJMSExpiration(long l) throws JMSException {

        }

        @Override
        public int getJMSPriority() throws JMSException {
            return 0;
        }

        @Override
        public void setJMSPriority(int i) throws JMSException {

        }

        @Override
        public void clearProperties() throws JMSException {

        }

        @Override
        public boolean propertyExists(String s) throws JMSException {
            return false;
        }

        @Override
        public boolean getBooleanProperty(String s) throws JMSException {
            return false;
        }

        @Override
        public byte getByteProperty(String s) throws JMSException {
            return 0;
        }

        @Override
        public short getShortProperty(String s) throws JMSException {
            return 0;
        }

        @Override
        public int getIntProperty(String s) throws JMSException {
            return 0;
        }

        @Override
        public long getLongProperty(String s) throws JMSException {
            return 0;
        }

        @Override
        public float getFloatProperty(String s) throws JMSException {
            return 0;
        }

        @Override
        public double getDoubleProperty(String s) throws JMSException {
            return 0;
        }

        @Override
        public String getStringProperty(String s) throws JMSException {
            return "";
        }

        @Override
        public Object getObjectProperty(String s) throws JMSException {
            return null;
        }

        @Override
        public Enumeration getPropertyNames() throws JMSException {
            return null;
        }

        @Override
        public void setBooleanProperty(String s, boolean b) throws JMSException {

        }

        @Override
        public void setByteProperty(String s, byte b) throws JMSException {

        }

        @Override
        public void setShortProperty(String s, short i) throws JMSException {

        }

        @Override
        public void setIntProperty(String s, int i) throws JMSException {

        }

        @Override
        public void setLongProperty(String s, long l) throws JMSException {

        }

        @Override
        public void setFloatProperty(String s, float v) throws JMSException {

        }

        @Override
        public void setDoubleProperty(String s, double v) throws JMSException {

        }

        @Override
        public void setStringProperty(String s, String s1) throws JMSException {

        }

        @Override
        public void setObjectProperty(String s, Object o) throws JMSException {

        }

        @Override
        public void acknowledge() throws JMSException {

        }

        @Override
        public void clearBody() throws JMSException {

        }
    }

    private class RecipientType {
        public static final long TO = 0;
    }

    private class Transport {
    }
}