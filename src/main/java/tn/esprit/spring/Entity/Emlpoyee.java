package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Emlpoyee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeId;

    String firstName;

    String lastName;

    String position;

    @ManyToOne
    Campany campany;

    @OneToMany(mappedBy = "emlpoyee")
    @JsonIgnore
    List<Donation> donationList = new ArrayList<>();
}
