package az.binary.library_management_system.entities;

import az.binary.library_management_system.enums.LibraryStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "name cannot be blank")
    @Column(name = "library_name")
    private String name;

    @Column(name = "fk_user_id")
    private Long fkUserId;

    @Column(name = "fk_book_id")
    private Long fkBookId;

    @Column(name = "library_status")
    @Enumerated(EnumType.STRING)
    private LibraryStatus status;

    @PrePersist
    public void preStatus(){
        if(status == null){
            status = LibraryStatus.INACTIVE;
        }
    }

}
