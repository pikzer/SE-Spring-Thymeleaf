package th.ac.ku.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id ;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
}
