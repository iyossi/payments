package application.controller;

import application.api.RequestDto;
import application.exception.BasicRestException;
import application.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @PostMapping("")
    public UUID createPayment(@RequestBody RequestDto request) {
        try {
            logger.info("request is " + request.toString());
            UUID paymentId = paymentService.handleRequest(request);
//            return UUID.randomUUID();
            return paymentId;

        } catch (RuntimeException e) {
            logger.error(e.toString());
            e.printStackTrace();
            throw new BasicRestException("Can't process payment request " + request);
        }
    }
}
