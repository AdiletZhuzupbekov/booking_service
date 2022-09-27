package kg.megacom.booking_service.service.impl;

import kg.megacom.booking_service.mapper.CustomerMapper;
import kg.megacom.booking_service.model.Customer;
import kg.megacom.booking_service.model.dto.CustomerDto;
import kg.megacom.booking_service.repository.CustomerRepo;
import kg.megacom.booking_service.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
        this.customerMapper = CustomerMapper.INSTANCE;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepo.save(customer);
        return customerDto;
    }
}
