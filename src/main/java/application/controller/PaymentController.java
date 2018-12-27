package application.controller;

import application.Exception.BasicRestException;
import application.api.RequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("")
    public UUID createPayment(@RequestBody RequestDto request) {
        try {
            logger.info("request is " + request.toString());
            return UUID.randomUUID();
        } catch (RuntimeException e) {
            throw new BasicRestException("Can't process payment request " + request);
        }
    }
}
