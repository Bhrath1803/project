package service;

import model.Booking;
import model.Bus;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookingRepository;
import repository.BusRepository;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired private BookingRepository bookingRepository;
    @Autowired private BusRepository busRepository;
    @Autowired private UserRepository userRepository;
    public String bookticket(Long userId, Long busId, String passengerName, int seatNumber) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Bus> busopt = busRepository.findById(busId);

        if (userOpt.isEmpty() || busopt.isEmpty()) {
            return "Invalid user or bus Id";
        }
        Booking booking = new Booking();
        booking.setUser (userOpt.get());
        booking.setBus(busopt.get());
        booking.setPassengerName(passengerName);
        booking.setBookingDate(LocalDate.now());

        bookingRepository.save(booking);
        return "Booking sucessfull";

    }
    public List<Booking> getBookingsByUserId(Long userId){
        return bookingRepository.findByUserId(userId);
    }
    public Optional<Booking> getBookingById(Long bookingId){
        return bookingRepository.findById(bookingId);
    }


    }

