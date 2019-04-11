package pl.witkowski.AutoBay.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.witkowski.AutoBay.repository.AuctionRepository;
import pl.witkowski.AutoBay.repository.CarRepository;
import pl.witkowski.AutoBay.repository.RoleRepository;
import pl.witkowski.AutoBay.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RunAtStart {


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private AuctionRepository auctionRepository;

    private CarRepository carRepository;

    @Autowired
    public RunAtStart(UserRepository userRepository, RoleRepository roleRepository, AuctionRepository auctionRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.auctionRepository = auctionRepository;
        this.carRepository = carRepository;
    }

    @PostConstruct
    public void runAtStart(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        User user1 =new User();
        User user2 = new User();

        user1.setName("Konrad");
        user1.setLastName("Dawydiuk");
        user1.setEmail("konrad@gmail.com");
        user1.setPassword("Haslo12");  //bCryptPasswordEncoder.encode(
        user1.setCreated(LocalDate.of(2019,03,07));
        user1.setUsername("kowala12");
        user1.setFullName("Adam Kowal");
        user1.setActive(true);

        user2.setName("Adam1");
        user2.setLastName("Kowal1");
        user2.setEmail("a.kowal1@gmail.com");
        user2.setPassword("Haslo22"); //bCryptPasswordEncoder.encode(
        user2.setCreated(LocalDate.of(2019,03,06));
        user2.setUsername("kowala22");
        user2.setFullName("Adam Kowal1");
        user2.setActive(true);


        Car car1 = new Car();
        Car car2 = new Car();

        car1.setCapacity(5996);
        car1.setCategory("passenger car");
        car1.setCondition("used");
        car1.setColor("red");
        car1.setDoors(4);
        car1.setFuel("petrol");
        car1.setGearbox("automatic");
        car1.setMake("Ferrari");
        car1.setMileage(12000);
        car1.setModel("599 GTO");
        car1.setPostCrash(false);
        car1.setPower(670);
        car1.setSeats(2);
        car1.setType("supercar");
        car1.setYear(2010);
//        car1.setAuction();

        car2.setCapacity(280);
        car2.setCategory("heavy goods vehicle");
        car2.setCondition("used");
        car2.setColor("white");
        car2.setDoors(4);
        car2.setFuel("diesel");
        car2.setGearbox("5-speed manual");
        car2.setMake("VW");
        car2.setMileage(278000);
        car2.setModel("LT28");
        car2.setPostCrash(true);
        car2.setPower(150);
        car2.setSeats(3);
        car2.setType("Truck");
        car2.setYear(1985);
//        car2.setAuction();

        carRepository.save(car1);
        carRepository.save(car2);



        Role role1 = new Role();
        Role role2 = new Role();

        role1.setRole("ROLE_ADMIN");
        role2.setRole("ROLE_USER");

        roleRepository.save(role1);
        roleRepository.save(role2);



        user1.getRoles().add(role1);
        user1.getRoles().add(role2);

        user2.getRoles().add(role2);

        userRepository.save(user1);
        userRepository.save(user2);




        BigDecimal bd1 = new BigDecimal("21200.00");
        BigDecimal bd2 = new BigDecimal("1787000.00");


        Auction auction1 = new Auction();
        Auction auction2 = new Auction();

        auction1.setStartTime(LocalDate.of(2019,04,05));
        auction1.setFinishTime(LocalDate.of(2019,05,05));
        auction1.setPrice(bd1);
        auction1.setUser(user1);
        auction1.setCar(car1);



        auction2.setStartTime(LocalDate.of(2019,04,21));
        auction2.setFinishTime(LocalDate.of(2019,05,20));
        auction2.setPrice(bd2);
        auction2.setUser(user2);
        auction2.setCar(car2);


        auctionRepository.save(auction1);
        auctionRepository.save(auction2);


    }
}
