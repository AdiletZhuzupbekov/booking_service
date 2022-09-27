package kg.megacom.booking.microservices;

import kg.megacom.booking.microservices.json.HotelServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "${micro.hotel-service.name}", url = "${micro.hotel-service.url}")
public interface HotelServiceFeign {


    @GetMapping(value = "hotel/info")
    HotelServiceResponse[] getInfo();

    @GetMapping(value = "hotel/findByCity")
    HotelServiceResponse[] findByCity(@RequestParam String city);
}
