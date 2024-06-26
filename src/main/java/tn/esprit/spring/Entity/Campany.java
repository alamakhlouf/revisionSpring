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
public class Campany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long companyId;

    String companyName;

    String address;

    @OneToMany(mappedBy = "campany")
    @JsonIgnore
    List<Emlpoyee> emlpoyeeList;
}
