package kg.megacom.booking_service.mapper;

import kg.megacom.booking_service.mapper.base.CrudMapper;
import kg.megacom.booking_service.model.Booking;
import kg.megacom.booking_service.model.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper extends CrudMapper<Booking, BookingDto> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
}
