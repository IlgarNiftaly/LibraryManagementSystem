package az.binary.library_management_system.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "FirstName cannot be blank")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "LastName cannot be blank")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Email cannot be blank")
    @Column(name = "email")
    @Email(message = "invalid email structure")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Column(name = "password")
    private String password;

    @Column(name = "fk_book_id")
    private Long fkBookId;

    @Column(name = "fk_library_id")
    private Long fkLibraryId;


}
