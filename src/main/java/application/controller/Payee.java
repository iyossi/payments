package application.controller;

import application.model.PayeeResultItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class Payee {

    @GetMapping(path = "/payees")
    public List<PayeeResultItem> createPayment() {
        List<PayeeResultItem> result = new ArrayList();
        result.add(new PayeeResultItem(UUID.randomUUID(), "David"));
        result.add(new PayeeResultItem(UUID.randomUUID(), "Moshe"));
        return result;
    }
}
