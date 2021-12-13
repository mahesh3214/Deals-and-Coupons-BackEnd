package com.dealsand.couponsApp.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dealsand.couponsApp.Admin.AdminRepository.AdminRepository;
import com.dealsand.couponsApp.Admin.controller.AdminController;
import com.dealsand.couponsApp.Admin.model.Admin;

@SpringBootTest
class AdminApplicationTests {

	@MockBean
    AdminRepository adminrepos;
    @Autowired
	AdminController admincontroll;
	
	


	@Test
    public void getAllAdminTest() {
        when(adminrepos.findAll()).thenReturn(
                Stream.of(
                                new  Admin(" ","amazon", "mobiles@gamil.com", "1234578"))
                        .collect(Collectors.toList()));
        assertEquals(1,admincontroll. getAllAdmins().size());

    }

    @Test
    public void addAdminTest() {
    	Admin ad = new  Admin(" ","amazon", "mobiles@gamil.com", "1234578");
        when(adminrepos.save(ad)).thenReturn(ad);
        assertEquals("Admin is created :"+ad.getName(), admincontroll.addAdmin(ad));
    }
    
    

    @Test
    public void deleteAdminTest() {

        String id = "1";

        Admin ad= new Admin("1","amazon", "mobiles@gamil.com", "1234578");
        adminrepos.deleteById(id);
        verify(adminrepos).deleteById(id);


    }


}
