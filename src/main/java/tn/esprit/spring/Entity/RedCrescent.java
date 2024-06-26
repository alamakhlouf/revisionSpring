package tn.esprit.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class RedCrescent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long redCID;

    String area;

    @OneToMany
    @JsonIgnore
    List<Donation> donationList;
}
