package az.binary.library_management_system.entities;

import az.binary.library_management_system.validations.EmailValid;
import az.binary.library_management_system.validations.InfoValid;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @InfoValid(message = "firstName structure is incorrect")
    @Column(name = "first_name")
    private String firstName;

    @InfoValid(message = "lastName structure is incorrect")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @EmailValid
    private String email;

    @InfoValid(message = "password structure is incorrect")
    @Column(name = "password")
    private String password;

    @Column(name = "fk_book_id")
    private Long fkBookId;

    @Column(name = "fk_library_id")
    private Long fkLibraryId;

}