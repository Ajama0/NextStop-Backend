package com.example.RailwayExpress.RailwayEXP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface RailwayRepository extends JpaRepository<RailwayExpress, Long> {


//custom querys can be done here, with hibernate

    @Query(value ="select * from railway_express order by ticket_Price LIMIT 1", nativeQuery= true)
   Optional<RailwayExpress> findCheapestTicket();

    @Query("Select s from RailwayExpress s Where s.departureLocation=?1 And s.Destination=?2")
    List<RailwayExpress> getTicketInfo(String departureLocation, String Destination);

    @Query(value = "Select * from railway_express Order by departure_date Limit 1", nativeQuery = true)
    Optional<RailwayExpress> firstAvailableTicket();


    @Query("SELECT COUNT(s) = 0 FROM RailwayExpress s WHERE s.departureLocation = :departureLocation AND s.Destination = :Destination")
    boolean CheckIfTicketExists(@Param("departureLocation") String departureLocation, @Param("Destination") String Destination);




    @Query("Select s from RailwayExpress s WHERE s.Destination =?1")
    Optional<RailwayExpress>findByDestination(String oldDestination);
}
