/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.model;

import back.entitys.Usuario;
import back.implents.Emailimp;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author juang
 */
public class EmailM implements Emailimp {

    // Datos del correo remitente
    private static final String EMAIL_FROM = "citamatchpasionlove@gmail.com";
    private static final String PASSWORD_FROM = "ktvxscivkxpiaoic";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final Logger LOGGER = Logger.getLogger(EmailM.class.getName());

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public EmailM() {
        mProperties = new Properties();
        configurarSMTP();
    }

    /**
     * Configura las propiedades del servidor SMTP.
     */
    private void configurarSMTP() {
        mProperties.put("mail.smtp.host", SMTP_HOST);
        mProperties.put("mail.smtp.ssl.trust", SMTP_HOST);
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", SMTP_PORT);
        mProperties.setProperty("mail.smtp.user", EMAIL_FROM);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);
    }

    /**
     * Prepara el contenido del correo con el código de validación.
     *
     * @param emailTo Dirección del destinatario
     * @param subject Asunto del correo
     * @param content Contenido del correo
     * @return El código de validación generado o 0 si ocurre un error.
     */
    private int prepararCorreo(String emailTo, String subject, String content) {
        Random random = new Random();
        int codigo = 0;
        try {
            codigo = 100000 + random.nextInt(900000);  // Genera un número entre 100000 y 999999
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(EMAIL_FROM));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content + " " + codigo, "ISO-8859-1", "plain");  // Incluye el código en el contenido
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error preparando el correo", ex);
            return 0;  // Si hay error, el código será 0
        }
        return codigo;
    }

    /**
     * Envía el correo previamente configurado.
     *
     * @return true si el correo se envió correctamente, false en caso
     * contrario.
     */
    private boolean enviarCorreo() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(EMAIL_FROM, PASSWORD_FROM);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            LOGGER.log(Level.INFO, "Correo enviado exitosamente a {0}", mCorreo.getRecipients(Message.RecipientType.TO)[0]);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error enviando el correo", ex);
            return false;
        }
    }

    /**
     * Envía un correo de validación o recuperación con un código al usuario.
     *
     * @param user Usuario al que se le enviará el correo
     * @param tipo Tipo de correo ("registro" o "recuperar")
     * @return El código de validación o recuperación enviado, o 0 si no se pudo
     * enviar.
     */
    @Override
    public int EmailValidar(Usuario user, String tipo) {
        int codigo = 0;

        // Determinar el tipo de correo a enviar
        if (tipo.equalsIgnoreCase("registro")) {
            codigo = prepararCorreo(user.getEmail(), "Código de Validación", "Su código de validación es:");
        } else if (tipo.equalsIgnoreCase("recuperar")) {
            codigo = prepararCorreo(user.getEmail(), "Código de Recuperación", "Su código de recuperación es:");
        }

        // Intentar enviar el correo solo si se generó un código
        if (codigo != 0 && enviarCorreo()) {
            return codigo;  // Retornar el código si el correo fue enviado exitosamente
        } else {
            return 0;  // Si hay error, retornar 0
        }
    }
}
