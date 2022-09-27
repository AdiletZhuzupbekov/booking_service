package kg.megacom.booking_service.mapper;

import kg.megacom.booking_service.mapper.base.CrudMapper;
import kg.megacom.booking_service.model.Apartment;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApartmentMapper extends CrudMapper<Apartment, ApartmentDto> {
    ApartmentMapper INSTANCE = Mappers.getMapper(ApartmentMapper.class);

}
