package com.example.RailwayExpress.RailwayEXP;

import java.time.LocalDate;

public class railwayDTO {
    private String departureLocation;
    private LocalDate departureDate;
    private String Destination;
    private double ticketPrice;

    public railwayDTO(RailwayExpress railwayExpress){
        this.departureLocation=railwayExpress.getDepartureLocation();
        this.departureDate=railwayExpress.getDepartureDate();
        this.Destination=railwayExpress.getDestination();
        this.ticketPrice=railwayExpress.getTicketPrice();
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
