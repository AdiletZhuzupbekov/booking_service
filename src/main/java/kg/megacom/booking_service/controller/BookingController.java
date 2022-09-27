package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.enums.ApartmentClassification;
import kg.megacom.booking_service.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("available")// проверка свободных намеров
    List<ApartmentDto> checkAvailable(
            @RequestParam(required = false) Long hotelId,
            @RequestParam(required = false) ApartmentClassification classification,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return bookingService.getInfo(hotelId, classification,startDate, endDate);
    }
}
