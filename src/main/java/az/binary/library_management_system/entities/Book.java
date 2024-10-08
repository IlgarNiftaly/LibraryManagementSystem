package az.binary.library_management_system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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

    @Column(name = "book_name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @Column(name = "fk_library_id")
    private Long fkLibraryId;

    @Column(name = "fk_user_id")
    private Long fkUserId;

    @Column(name = "book_status")
    private String status;


    @PrePersist
    public void prePersist(){
        if(status == null){
            status = "D";
        }
    }


}
