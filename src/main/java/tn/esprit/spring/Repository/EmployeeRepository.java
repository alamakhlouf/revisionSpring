package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.Entity.Campany;
import tn.esprit.spring.Entity.Emlpoyee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Emlpoyee,Long> {


    @Query("select e from Emlpoyee e, RedCrescent r where  r.area = :area and e.campany.companyName = :company")
    public List<Emlpoyee> getEmployeeByCompanyNameAndArea(String company, String area);
}
