package application.controller;

import application.api.CustomerDto;
import application.api.PaymentMethodDto;
import application.exception.BasicRestException;
import application.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payees")
public class PayeeController {

    Logger logger = LoggerFactory.getLogger(PayeeController.class);
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<CustomerDto> getPayees() {
        try {
            List<CustomerDto> result = customerService.getAllCustomers().stream().
                    map(obj -> {
                        return new CustomerDto(obj.getCustomerId(), obj.getName(), obj.getMail());
                    }).collect(Collectors.toList());
            return result;
        } catch (RuntimeException e) {
            logger.error(e.toString());
            e.printStackTrace();
            throw new BasicRestException("Can't get customers");
        }
    }

    @GetMapping("/{id}/payment-methods")
    public List<PaymentMethodDto> getPaymentMethod(@PathVariable UUID id) {
        try {
            System.out.println("id=" + id.toString());
            List<PaymentMethodDto> result = customerService.getPaymentMethodByCustomerId(id).stream().
                    map(obj -> {
                        return new PaymentMethodDto(obj.getId(), obj.getType().name(), obj.getNumber());
                    }).collect(Collectors.toList());
            return result;
        } catch (RuntimeException e) {
            logger.error(e.toString());
            throw new BasicRestException(HttpStatus.NOT_FOUND);
        }
    }

}
