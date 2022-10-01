package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.mapper.CustomerMapper;
import kg.megacom.booking_service.model.Customer;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.dto.BookingDto;
import kg.megacom.booking_service.repository.CustomerRepo;
import kg.megacom.booking_service.service.BookingService;
import kg.megacom.booking_service.service.CustomerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("hotel")
public class BookingController {
    private final BookingService bookingService;
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final CustomerRepo customerRepo;

    public BookingController(BookingService bookingService, CustomerService customerService, CustomerRepo customerRepo) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.customerRepo = customerRepo;
        this.customerMapper = CustomerMapper.INSTANCE;
    }

    @GetMapping("/available")// проверка свободных намеров
    List<ApartmentDto> checkAvailable(

            @RequestParam(required = false) Byte person,
            @RequestParam Long id,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return bookingService.getInfo(person,id,startDate, endDate);
    }
    @PostMapping("/reservation")// бронирование номера
    BookingDto reservation(@RequestParam Long apartId,
                           @RequestParam String name,
                           @RequestParam String phone,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){

        Customer customer = customerRepo.findByName(name);
        if (customer == null) {
            customer.setName(name);
            customer.setPhone(phone);
            customerRepo.save(customer);
        }

        return bookingService.reservation(apartId,customer, startDate, endDate);

    }
}
