package az.binary.library_management_system.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {

    private Long id;
    private String first_name;
    private String last_name;
    private Email emailAddress;
    private String password;


}
