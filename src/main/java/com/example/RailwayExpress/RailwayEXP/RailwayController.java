package com.example.RailwayExpress.RailwayEXP;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/RailwayExpress")
public class RailwayController {

    private final RailwayService railwayService;

    @Autowired
    public RailwayController(RailwayService railwayService) {
        this.railwayService = railwayService;
    }

    @GetMapping
    public List<railwayDTO> RetrieveTicketInfo() {
        return railwayService.findAllRailwayExpress();

    }

    @GetMapping(path = "/CheapestPrice")
    public Optional<RailwayExpress> findCheapestTicket() {
        return railwayService.findCheapestTicket();


    }

    @GetMapping(path = "journey/{Departure}/{Destination}")
    public List<RailwayExpress> getTicketInfo(@PathVariable("Departure") String DepartureLocation,
                                              @PathVariable("Destination") String Destination) {

        return railwayService.getTicketInfo(DepartureLocation, Destination);
    }


    @GetMapping(path = "Earliest/train")
    public Optional<RailwayExpress> firstAvailalbeTicket() {
        return railwayService.firstAvailableTicket();
    }


    @GetMapping(path = "available/ticket/by/id/{id}")
    public Optional<RailwayExpress> getTicketbyId(@PathVariable("id") Long train_id) {
        return railwayService.findbyId(train_id);

    }


    //Admin can have access to adding a new ticket
    @PostMapping(path="/Create/Ticket")
    public Optional<RailwayExpress>CreateTicket(@RequestBody RailwayExpress ticket)
    {
        return railwayService.CreateTicket(ticket);
    }


    //allow users to purchase available tickets
    @PostMapping(path = "/purchaseTicket")
    public Optional<RailwayExpress> buyTicket(@RequestBody RailwayExpress purchase) {
        return railwayService.buyTicket(purchase);
    }


    //Admins can change a tickets price, due to a Sale
    @PutMapping(path = "/ticket/sale/{id}/{price}")
    public Optional<RailwayExpress> updateTicketPrice(@PathVariable("id") Long id,
                                                      @PathVariable("price") double ticketPrice) {

        return railwayService.updateTicketPrice(id, ticketPrice);
    }


    //Admin can reschedule dates of the train tickets
    @PutMapping("/updateDate/{id}/{date}")
    public Optional<RailwayExpress> rescheduleTrain(@PathVariable("id") Long train_id,
                                                    @PathVariable("date") LocalDate departureDate) {

        return railwayService.rescheduleTrain(train_id, departureDate);
    }


    //destination location has changed. ensure to enter previous destination and the new destination
    @PutMapping(path = "{prevDestination}/{destination}")
    public Optional<RailwayExpress> TrainDiversion(@PathVariable("destination") String newDestination,
                                                   @PathVariable("prevDestination") String oldDestination) {
        return railwayService.TrainDiversion(oldDestination, newDestination);
    }

    //delete a specific ticket
    @DeleteMapping(path = "{id}")
    public void deleteTicket(@PathVariable("id")Long id){
        railwayService.deleteTicket(id);
    }

    //due to suspension of the railway, the railway destination is changed.



     }

























































































































































