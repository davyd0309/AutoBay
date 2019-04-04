package pl.witkowski.AutoBay.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class RunAtStart {


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private AuctionRepository auctionRepository;

    @Autowired
    public RunAtStart(UserRepository userRepository, RoleRepository roleRepository, AuctionRepository auctionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.auctionRepository = auctionRepository;
    }

//    @PostConstruct
    public void runAtStart(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        User user1 =new User();
        User user2 = new User();

        user1.setName("Konrad");
        user1.setLastName("Dawydiuk");
        user1.setEmail("konrad@gmail.com");
        user1.setPassword(bCryptPasswordEncoder.encode("Haslo12"));
        user1.setCreated(LocalDate.of(2019,03,07));
        user1.setUserName("kowala12");
        user1.setFullName("Adam Kowal");
        user1.setActive(true);

        user2.setName("Adam1");
        user2.setLastName("Kowal1");
        user2.setEmail("a.kowal1@gmail.com");
        user2.setPassword(bCryptPasswordEncoder.encode("Haslo22"));
        user2.setCreated(LocalDate.of(2019,03,06));
        user2.setUserName("kowala22");
        user2.setFullName("Adam Kowal1");
        user2.setActive(true);


        BigDecimal bd1 = new BigDecimal("212.000");
        BigDecimal bd2 = new BigDecimal("787.000");




        Auction auction1 = new Auction();
        Auction auction2 = new Auction();

        auction1.setStartTime(LocalDate.of(2019,04,05));
        auction1.setFinishTime(LocalDate.of(2019,05,05));
        auction1.setPrice(bd1);
        auction1.setUser(user1);


        auction2.setStartTime(LocalDate.of(2019,04,21));
        auction2.setFinishTime(LocalDate.of(2019,05,20));
        auction2.setPrice(bd2);
        auction2.setUser(user2);


        auctionRepository.save(auction1);
        auctionRepository.save(auction2);


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
    }
}
