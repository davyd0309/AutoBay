package pl.witkowski.AutoBay.model;


import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String category;  // osobowe / ciezarowe

    private String make;

    private String model;

    private Integer year;

    private Integer mileage;

    private Integer capacity;

    private String fuel;

    private Integer power;

    private String gearbox;

    private String type;  // suv  / sportowy/ limuzyna

    private Integer doors;

    private Integer seats;

    private String color;

    private String condition;

    private Boolean postCrash;

    @OneToOne()
    private Auction auction;
}
