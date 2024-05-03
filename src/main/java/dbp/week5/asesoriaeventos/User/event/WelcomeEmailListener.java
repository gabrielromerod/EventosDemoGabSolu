package dbp.week5.asesoriaeventos.User.event;

import dbp.week5.asesoriaeventos.Email.domain.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {

    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void sendWelcomeEmail(WelcomeEmailEvent welcomeEmailEvent) {
        emailService.sendEmail(welcomeEmailEvent.getEmail(), "Bienvenido", "Hola " + welcomeEmailEvent.getName() + ", bienvenido a nuestra plataforma.");
    }
}
