package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.*;

import java.util.List;

public interface CompanyService {

    public Campany addCompany(Campany campany);

    public Emlpoyee addEmployeeAndAssignToCompany(Emlpoyee emlpoyee, String companyName);

    public Donation addDonation(Donation donation);


    public List<Donation> getDonationByType(DonationType type);

    public List<Emlpoyee> getEmployeeByCompanyNameAndArea(String company, String area);

    public RedCrescent addCroissantEtAffecterDon(RedCrescent croissantRouge, Long idDon);
}
