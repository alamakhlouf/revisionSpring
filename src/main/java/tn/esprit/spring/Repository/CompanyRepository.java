package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entity.Campany;

public interface CompanyRepository extends JpaRepository<Campany,Long> {

    Campany getByCompanyName(String name);
}
