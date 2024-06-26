package tn.esprit.spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.*;
import tn.esprit.spring.Repository.CompanyRepository;
import tn.esprit.spring.Repository.DonationRepository;
import tn.esprit.spring.Repository.EmployeeRepository;
import tn.esprit.spring.Repository.RedCrescentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;
    EmployeeRepository employeeRepository;
    DonationRepository donationRepository;
    RedCrescentRepository redCrescentRepository;

    @Override
    public Campany addCompany(Campany campany) {
        return companyRepository.save(campany);
    }

    @Override
    public Emlpoyee addEmployeeAndAssignToCompany(Emlpoyee emlpoyee, String companyName) {
        Campany campany = companyRepository.getByCompanyName(companyName);
        emlpoyee.setCampany(campany);
        return employeeRepository.save(emlpoyee);
    }

    public Donation addDonation(Donation donation) {
        if (donation.getType() == DonationType.MONETARY) {
            if (donation.getAmount() == 0) {
                return null;
            } else {

                return donationRepository.save(donation);
            }
        }
        donation.setAmount(0);
        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> getDonationByType(DonationType type) {
        return donationRepository.getDonationByTypeOrderByDate(type);
    }

    @Override
    public List<Emlpoyee> getEmployeeByCompanyNameAndArea(String company, String area) {
        return employeeRepository.getEmployeeByCompanyNameAndArea(company,area);
    }

    @Override
    public RedCrescent addCroissantEtAffecterDon(RedCrescent croissantRouge, Long idDon) {
        Donation donation = donationRepository.findById(idDon).orElse(null);
        croissantRouge.getDonationList().add(donation);
        return redCrescentRepository.save(croissantRouge) ;
    }

}
