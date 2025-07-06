package controller;

import model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.BusRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    @Autowired private BusRepository busRepo;

    @GetMapping("/search")
    public List<Bus> searchBuses(@RequestParam String form,@RequestParam String to,@RequestParam String date){
        LocalDate travelDate= LocalDate.parse(date);
        return busRepo.findByFromLocationAndToLocationAndTravelDate(form ,to,travelDate);
    }
}
