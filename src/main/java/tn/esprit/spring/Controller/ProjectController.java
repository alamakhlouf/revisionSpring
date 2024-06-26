package tn.esprit.spring.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entity.*;
import tn.esprit.spring.Service.CompanyService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    CompanyService companyService;


    @PostMapping("/addCompany")
    public Campany addCompany(@RequestBody Campany campany) {
        System.out.println(campany.getAddress());
        return companyService.addCompany(campany);
    }

    @PostMapping("/addEmployee/{companyName}")
    public Emlpoyee addEmployeeAndAssignToCompany(@RequestBody Emlpoyee emlpoyee,
                                                  @PathVariable("companyName") String companyName) {
        return companyService.addEmployeeAndAssignToCompany(emlpoyee, companyName);
    }

    @PostMapping("/addDonation")
    public Donation addDonation(@RequestBody Donation donation) {
        return companyService.addDonation(donation);
    }

    @GetMapping("/getDonation/{donationType}")
    public List<Donation> getDonation(@PathVariable DonationType donationType) {
        return companyService.getDonationByType(donationType);
    }

    @GetMapping("/getEmployee/{companyName}/{area}")
    public List<Emlpoyee> getEmployee(@PathVariable String companyName, @PathVariable String area) {
        return companyService.getEmployeeByCompanyNameAndArea(companyName,area);
    }

    @PostMapping("/addCroissant/{id}")
    public RedCrescent addCroissantEtAffecterDon(@RequestBody RedCrescent redCrescent, @PathVariable Long id)
    {
        return  companyService.addCroissantEtAffecterDon(redCrescent,id);
    }



}

