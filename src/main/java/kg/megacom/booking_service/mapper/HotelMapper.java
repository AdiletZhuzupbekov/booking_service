package kg.megacom.booking_service.mapper;

import kg.megacom.booking_service.mapper.base.CrudMapper;
import kg.megacom.booking_service.model.Hotel;
import kg.megacom.booking_service.model.dto.HotelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper extends CrudMapper<Hotel, HotelDto> {

    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
}
