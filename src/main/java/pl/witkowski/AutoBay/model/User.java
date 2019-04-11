package pl.witkowski.AutoBay.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();

    @NotEmpty
    @Column(unique = true)
    @Size(min = 4)
    private String username;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Size(min = 4)
    private String lastName;

    @NotBlank
    private String password;

//    @NotBlank
    @Transient
    private String passwordConfirm;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @ColumnDefault("1")
    private int enabled;

    @CreationTimestamp
    private LocalDate created;

    @Transient
    private String fullName;

    private boolean active;

    @OneToOne()
    private Auction auction;
}
