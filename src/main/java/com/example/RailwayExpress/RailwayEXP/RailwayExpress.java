package com.example.RailwayExpress.RailwayEXP;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table

public class RailwayExpress {

    @Id
        @SequenceGenerator(name = "railwayexpress_sequence",
                sequenceName = "railwayexpress_sequence",
                allocationSize = 1
        )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "railwayexpress_sequence"
    )


    private Long train_id;
    private String departureLocation;
    private LocalDate departureDate;
    private String Destination;
    private double ticketPrice;


    public RailwayExpress(){}


    public RailwayExpress(Long train_id, String departureLocation, LocalDate departureDate){
        this.train_id=train_id;
        this.departureLocation=departureLocation;
        this.departureDate=departureDate;
    }
    public RailwayExpress(String departureLocation, LocalDate DepartureDate,
                          String Destination,double ticketPrice ) {
        this.departureLocation=departureLocation;
        this.departureDate=DepartureDate;
        this.Destination=Destination;
        this.ticketPrice=ticketPrice;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Long getTrainId() {
        return train_id;
    }

    public void setTrainId(Long train_id) {
        this.train_id = train_id;
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

    @Override
    public String toString() {
        return "RailwayExpress{" +
                "trainId='" + train_id + '\'' +
                ", departureLocation='" + departureLocation + '\'' +
                ", departureDate=" + departureDate +
                ", Destination='" + Destination + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
