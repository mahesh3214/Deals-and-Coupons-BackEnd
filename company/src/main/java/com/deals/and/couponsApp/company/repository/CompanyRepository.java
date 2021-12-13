package com.deals.and.couponsApp.company.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.deals.and.couponsApp.company.model.Companys;

public interface CompanyRepository extends MongoRepository<Companys, String> {



	

	void deleteByCompanyname(String companyname);

	





	Companys findBycompanyname(String companyname);



	

}
