package com.example.RailwayExpress.RailwayEXP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RailwayService {

    private final RailwayRepository railwayRepository;

    @Autowired
    public RailwayService(RailwayRepository railwayRepository) {
        this.railwayRepository = railwayRepository;
    }
    public List<railwayDTO> findAllRailwayExpress() {
        List<RailwayExpress>ticketList = railwayRepository.findAll();
               return  ticketList.stream().map
                        ( railwayDTO::new) .collect(Collectors.toList());


    }


    public Optional <RailwayExpress> findCheapestTicket() {
        //logic for retrieving the least expensive tickets
       Optional<RailwayExpress>cheapestTicket = railwayRepository.findCheapestTicket();

        if(cheapestTicket.isPresent()){
            RailwayExpress ticket = cheapestTicket.get();
            return Optional.of(ticket);
        } else {

            throw new IllegalStateException("We have currently sold out.. sorry :");
        }
    }

    public List<RailwayExpress> getTicketInfo(String departureLocation, String Destination) {
        // finding Ticket information based on set criteria

        List<RailwayExpress> journeyInfo = railwayRepository.getTicketInfo
                (departureLocation, Destination);

        if (journeyInfo.isEmpty()) {

            throw new IllegalStateException("Location's coming soon... ;)");
        }
        return journeyInfo;
    }

    public Optional<RailwayExpress> firstAvailableTicket() {
        Optional<RailwayExpress> latestTicket = railwayRepository.firstAvailableTicket();

        if (latestTicket.isPresent()) {
            return latestTicket;
        } else {
            throw new IllegalStateException("we are out of tickets... Try again later");
        }

    }

    public Optional<RailwayExpress> findbyId(Long train_id) {
        Optional<RailwayExpress> ticketId = railwayRepository.findById(train_id);

        if (ticketId.isPresent()) {
            RailwayExpress ticketFound = ticketId.get();
            return Optional.of(ticketFound);

        } else {
            throw new IllegalStateException("This id does not exist");
        }
    }
//
//************************************************8
//    creating a ticket,and ensuring this ticket does not already exist in the database
//    also ensure the ticket is not exceeding the pre-existing maximum price already
    public Optional<RailwayExpress> CreateTicket(RailwayExpress ticket) {
        String departure = ticket.getDepartureLocation();
        String destination = ticket.getDestination();
        if (railwayRepository.CheckIfTicketExists(departure, destination)) {
            railwayRepository.save(ticket);
            return Optional.of(ticket);
        } else {
            throw new IllegalStateException("This ticket already exists, and ticket can not be created");
        }

    }


    //
    public Optional<RailwayExpress> rescheduleTrain(Long train_id, LocalDate departureDate) {
        Optional<RailwayExpress> train = railwayRepository.findById(train_id);

        if (train.isPresent()) {
            RailwayExpress railway = train.get();
            railway.setDepartureDate(departureDate);
            railwayRepository.save(railway);
            return Optional.of(railway);


        } else {
            throw new IllegalStateException("this train does not exist..");
        }

    }


    //Allow users to Buy tickets, however consider under which constraints
    public Optional<RailwayExpress> buyTicket(RailwayExpress purchase) {
       Long purchaseId = purchase.getTrainId();

        Optional<RailwayExpress> isPresent = railwayRepository.findById(purchaseId);

        //if the id is present, allow users to purchase and remove from database
        if (isPresent.isPresent()) {
           RailwayExpress purchasedTicket = isPresent.get();
            railwayRepository.delete(purchasedTicket);
            //returning the purchased ticket
            return Optional.of(purchasedTicket);

        } else {
            throw new IllegalStateException("The ticket you are trying to buy are currently unavailable");
        }


    }

    //ensure the correct data type of the price is being inputted
    //check if the ticket exists, if so we may need to update the price
    public Optional<RailwayExpress> updateTicketPrice(Long id, double ticketPrice) {
        Optional<RailwayExpress> getId = railwayRepository.findById(id);

        if (getId.isPresent()) {
            RailwayExpress ticket = getId.get();

            try {
                ticket.setTicketPrice(ticketPrice);
                railwayRepository.save(ticket);
                return Optional.of(ticket);

            } catch (NumberFormatException e) {
                throw new NumberFormatException("enter correct input " + e);


            }

        }else{
                throw new IllegalStateException("The id: " + id + "doesnt exist");
            }
        }

    public Optional<RailwayExpress> TrainDiversion(String oldDestination, String newDestination) {
        Optional<RailwayExpress>getDestination=railwayRepository.findByDestination(oldDestination);

        if(getDestination.isPresent()) {
            RailwayExpress railway = getDestination.get();

            try {
                railway.setDestination(newDestination);
                railwayRepository.save(railway);
                return Optional.of(railway);
            } catch (IllegalStateException e) {
                throw new IllegalStateException("please enter a final destination" + e);
            }

        }else{
            throw new IllegalStateException("please check the initial destination location again " );
        }


    }

    //allow Admins to delete tickets based on a specific id.
    public void deleteTicket(Long id) {
        Optional<RailwayExpress>findTicket = railwayRepository.findById(id);

        if(findTicket.isPresent()){
            RailwayExpress ticketDeletion = findTicket.get();
            railwayRepository.delete(ticketDeletion);
        }
        else{
            throw new IllegalStateException("please select an available train id");
        }
    }
}



























































