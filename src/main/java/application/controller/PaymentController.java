package application.controller;

import application.Exception.BasicRestException;
import application.api.RequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @PostMapping(path = "/payments")
    public UUID createPayment(@RequestBody RequestDto request) {
        try {
            System.out.println("request is " + request.toString());
            return UUID.randomUUID();
        } catch (RuntimeException e) {
            throw new BasicRestException("Can't get customers");
        }
    }
}
