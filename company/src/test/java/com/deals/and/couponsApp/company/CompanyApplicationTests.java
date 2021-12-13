package com.deals.and.couponsApp.company;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.deals.and.couponsApp.company.controller.CompanyController;
import com.deals.and.couponsApp.company.model.Companys;
import com.deals.and.couponsApp.company.repository.CompanyRepository;

@SpringBootTest
class CompanyApplicationTests {
	@MockBean
    CompanyRepository companyrepos;
    @Autowired
	CompanyController companycontroll;
	
	


	@Test
    public void getAllCompanysTest() {
        when(companyrepos.findAll()).thenReturn(
                Stream.of(
                                new Companys("amazon", "mobiles@gamil.com", "1234578","sponser"))
                        .collect(Collectors.toList()));
        assertEquals(1,companycontroll. getAllCompanys().size());

    }

    @Test
    public void addCompanyTest() {
    	Companys com = new  Companys("amazon", "mobiles@gamil.com", "1234578","sponser");
        when(companyrepos.save(com)).thenReturn(com);
        assertEquals("company added :"+com.getCompanyname(),  companycontroll.addCompany(com));
    }
    
    

    @Test
    public void deleteCompanyTest() {

        String companyname = "amazon";

        Companys com= new Companys("amazon", "mobiles@gamil.com", "1234578","sponser");
        companyrepos.deleteById(companyname );
        verify(companyrepos).deleteById(companyname);


    }

}
