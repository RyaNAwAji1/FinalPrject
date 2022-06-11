package com.example.demo.Service;

import com.example.demo.Model.Company;
import com.example.demo.Model.Invoice;
import com.example.demo.Model.User;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Repository.InvoiceRepository;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

   private final InvoiceRepository invoiceRepository;
   private final CompanyRepository companyRepository;
   private final UserRepository userRepository;



    public List<Invoice> getAllTotalPrice() {
        return invoiceRepository.findAll();
    }

    public void addNewTotalPrice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void addInvoice(Integer invoiceID, Integer companyID)
    {
        Invoice invoice= invoiceRepository.findById(invoiceID).get();
        Company company= companyRepository.findById(companyID).get();

        invoice.setCompany(company);
        invoiceRepository.save(invoice);

        company.getInvoices().add(invoice);
//        company.setPrice(company.getPrice()+(0.15*company.getPrice());
        companyRepository.save(company);

    }
    public void addUserToInvoice(Integer invoiceID, Integer UserId){

        Invoice invoice= invoiceRepository.findById(invoiceID).get();
        User user= userRepository.findById(UserId).get();

        invoice.setUser(user);
        invoiceRepository.save(invoice);

        user.getInvoices().add(invoice);
        userRepository.save(user);
    }
}
