package az.binary.library_management_system.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "library_name")
    private String name;

    @Column(name = "status")
    private String status;

//    @Column(name = "fk_user_id")
//    private Long fkUserId;

//    @Column(name = "fk_book_id")
//    private Long fkBookId;

    @PrePersist
    public void preStatus(){
        if(status == null){
            status = "D";
        }
    }

}
