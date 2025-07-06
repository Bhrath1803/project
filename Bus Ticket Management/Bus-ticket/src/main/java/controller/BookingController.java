package controller;

import model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookingRepository;
import repository.BusRepository;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired private BookingRepository bookingRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private BusRepository busRepo;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody Booking booking){
        booking.setBookingDate(LocalDate.now());
        bookingRepo.save(booking);
        return ResponseEntity.ok("Booking sucessfull!");

    }
    @GetMapping("/history/{userId}")
    public List<Booking> getUserBookings(@PathVariable Long userId){
        return bookingRepo.findByUserId(userId);
    }
}
