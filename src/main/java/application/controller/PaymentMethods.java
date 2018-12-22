package application.controller;

import application.model.PayeeResultItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PaymentMethods {

    @GetMapping(path = "/payment-methods")
    public List<PayeeResultItem> createPayment() {
        List<PayeeResultItem> result = new ArrayList();
        result.add(new PayeeResultItem(UUID.randomUUID(), "Visa[1234]"));
        result.add(new PayeeResultItem(UUID.randomUUID(), "MasterCard[5678]"));
        return result;
    }
}
