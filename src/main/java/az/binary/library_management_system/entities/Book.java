package az.binary.library_management_system.entities;

import az.binary.library_management_system.enums.BookStatus;
import az.binary.library_management_system.validations.InfoValid;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoValid(message = "name structure is incorrect")
    @Column(name = "book_name")
    private String name;

    @InfoValid(message = "author structure is incorrect")
    @Column(name = "author")
    private String author;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "fk_library_id")
    private Long fkLibraryId;

    @Column(name = "fk_user_id")
    private Long fkUserId;

    @Column(name = "book_status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;


    @PrePersist
    public void prePersist(){
        if(status == null){
            status = BookStatus.INACTIVE;
        }
    }

}
