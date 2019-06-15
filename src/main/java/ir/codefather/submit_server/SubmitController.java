package ir.codefather.submit_server;


import ir.codefather.submit_server.model.User;
import ir.codefather.submit_server.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * this is simple REST for FX project
 */
@RestController
public class SubmitController {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private UserRepo repo;

    /**
     * save user and send email to him/her
     *
     * @param user
     * @return User
     */
    @PostMapping("/submit")
    public User index(@Valid User user) {
        mail(user);
        return repo.save(user);
    }


    /**
     * send mail to given address
     *
     * @param user user instance
     */
    private void mail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Hello " + user.getName() + "!!!");
        message.setText("This is a test task to job hiring");
        try {
            sender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
