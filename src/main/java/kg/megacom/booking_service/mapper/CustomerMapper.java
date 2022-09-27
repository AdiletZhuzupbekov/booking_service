package kg.megacom.booking_service.mapper;

import kg.megacom.booking_service.mapper.base.CrudMapper;
import kg.megacom.booking_service.model.Customer;
import kg.megacom.booking_service.model.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper extends CrudMapper<Customer, CustomerDto> {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
}
