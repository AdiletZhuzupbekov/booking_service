package kg.megacom.booking_service.service;

import kg.megacom.booking_service.model.dto.CustomerDto;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
}
