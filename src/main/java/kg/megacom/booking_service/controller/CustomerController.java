package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.model.dto.CustomerDto;
import kg.megacom.booking_service.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")//регистрация клиента
    CustomerDto addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.save(customerDto);
    }
}
