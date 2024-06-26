package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entity.Donation;
import tn.esprit.spring.Entity.DonationType;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {


    public  List<Donation> getDonationByTypeOrderByDate(DonationType type);

}
