package application.controller;

import application.Exception.BasicRestException;
import application.model.Customer;
import application.model.PaymentMethod;
import application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payees")
public class Payee {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<Customer> getPayees() {
        try {
            List<Customer> result = customerService.getAllCustomers();
            return result;
        } catch (RuntimeException e) {
            throw new BasicRestException("Can't get customers");
        }
    }

    @GetMapping("/{id}/payment-methods")
    public List<PaymentMethod> getPaymentMethod(@PathVariable UUID id) {
        try {
            System.out.println("id=" + id.toString());
            List<PaymentMethod> result = customerService.getPaymentMethodByCustomerId(id);
            return result;
        } catch (RuntimeException e) {
            throw new BasicRestException(HttpStatus.NOT_FOUND);
        }
    }

}
