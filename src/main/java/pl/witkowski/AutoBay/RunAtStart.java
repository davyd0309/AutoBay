package pl.witkowski.AutoBay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.witkowski.AutoBay.model.Role;
import pl.witkowski.AutoBay.model.User;
import pl.witkowski.AutoBay.repository.RoleRepository;
import pl.witkowski.AutoBay.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
public class RunAtStart {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Autowired
    public RunAtStart(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @PostConstruct
    public void runAtStart(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User admin =new User();
        User user = new User();

        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));

        user.setUsername("user");
        user.setPassword(bCryptPasswordEncoder.encode("user"));

        Role roleAdmin = new Role();
        Role roleUser = new Role();

        roleAdmin.setName("ROLE_ADMIN");
        roleUser.setName("ROLE_USER");

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        admin.getRoles().add(roleAdmin);
        admin.getRoles().add(roleUser);

        user.getRoles().add(roleUser);

        userRepository.save(admin);
        userRepository.save(user);

    }
}
