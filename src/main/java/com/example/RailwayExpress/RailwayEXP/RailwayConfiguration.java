package com.example.RailwayExpress.RailwayEXP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RailwayConfiguration {

    @Bean
    CommandLineRunner commandLineRunner (RailwayRepository repository){

        return args -> {
            RailwayExpress r1 = new RailwayExpress(
                    "london", LocalDate.of(2024, Month.MARCH,6),
                    "paris", 15.99);

            RailwayExpress r2 = new RailwayExpress(
                    "new york", LocalDate.of(2024, Month.APRIL, 15),
                    "chicago", 25.99);

            RailwayExpress r3 = new RailwayExpress(
                    "tokyo", LocalDate.of(2024, Month.MAY, 10),
                    "osaka", 18.50);

            RailwayExpress r4 = new RailwayExpress(
                    "berlin", LocalDate.of(2024, Month.JUNE, 20),
                    "munich", 22.75);

            RailwayExpress r5 = new RailwayExpress(
                    "sydney", LocalDate.of(2024, Month.JULY, 5),
                    "melbourne", 30.00);

            RailwayExpress r6 = new RailwayExpress(
                    "beijing", LocalDate.of(2024, Month.AUGUST, 12),
                    "shanghai", 19.99);

            RailwayExpress r7 = new RailwayExpress(
                    "moscow", LocalDate.of(2024, Month.SEPTEMBER, 8),
                    "stpetersburg", 28.50);

            RailwayExpress r8 = new RailwayExpress(
                    "madrid", LocalDate.of(2024, Month.OCTOBER, 25),
                    "barcelona", 24.75);

            RailwayExpress r9 = new RailwayExpress(
                    "rome", LocalDate.of(2024, Month.NOVEMBER, 3),
                    "florence", 27.00);

            RailwayExpress r10 = new RailwayExpress(
                    "rio de janeiro", LocalDate.of(2024, Month.DECEMBER, 18),
                    "sao paulo", 35.25);

            repository.saveAll(
                    List.of(r1,r2,r3,r4,r5,r6,r7,r8,r9,r10)
            );

        };

    }



}
