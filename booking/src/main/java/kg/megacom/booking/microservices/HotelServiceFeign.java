package kg.megacom.booking.microservices;

import kg.megacom.booking.microservices.json.ApartmentServiceResponse;
import kg.megacom.booking.microservices.json.BookingResponse;
import kg.megacom.booking.microservices.json.HotelServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@FeignClient(value = "${micro.hotel-service.name}", url = "${micro.hotel-service.url}")
public interface HotelServiceFeign {


    @GetMapping(value = "hotel/info")
    HotelServiceResponse[] getInfo();

    @GetMapping(value = "hotel/findByCity")
    HotelServiceResponse[] findByCity(@RequestParam String city);

    @GetMapping(value = "hotel/{name}")
    HotelServiceResponse findByName(@PathVariable String name);

    @GetMapping(value = "apartment/{name}")
    ApartmentServiceResponse[] findByHotelName(@PathVariable String name);

    @GetMapping(value = "hotel/available")// проверка свободных намеров
    ApartmentServiceResponse[] checkAvailable(
            @RequestParam Byte person,
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate);

    @PostMapping("hotel/reservation")// бронирование номера
    BookingResponse reservation(@RequestParam Long apartId,
                                @RequestParam String name,
                                @RequestParam String phone,
                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate);

}
