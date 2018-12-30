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
class PayeeController {

    private final Logger logger = LoggerFactory.getLogger(PayeeController.class);
    @Autowired
    private
    CustomerService customerService;

    @GetMapping("")
    public List<CustomerDto> getPayees() {
        try {
            return customerService.getAllCustomers().stream().
                    map(obj -> new CustomerDto(obj.getCustomerId(), obj.getName(), obj.getMail())).collect(Collectors.toList());
        } catch (RuntimeException e) {
            logger.error(e.toString());
            e.printStackTrace();
            throw new BasicRestException("Can't get customers");
        }
    }

    @GetMapping("/{id}/payment-methods")
    public List<PaymentMethodDto> getPaymentMethod(@PathVariable UUID id) {
        try {
            return customerService.getPaymentMethodByCustomerId(id).stream().
                    map(obj -> new PaymentMethodDto(obj.getId(), obj.getType().name(), obj.getNumber())).collect(Collectors.toList());
        } catch (RuntimeException e) {
            logger.error(e.toString());
            throw new BasicRestException(HttpStatus.NOT_FOUND);
        }
    }

}
