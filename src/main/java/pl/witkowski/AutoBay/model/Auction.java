package pl.witkowski.AutoBay.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auction {

//    @ManyToOne
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal price;

    private LocalDate startTime;

    private LocalDate finishTime;
}
