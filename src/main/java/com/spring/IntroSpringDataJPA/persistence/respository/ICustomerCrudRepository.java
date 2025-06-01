package com.spring.IntroSpringDataJPA.persistence.respository;

import com.spring.IntroSpringDataJPA.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ICustomerCrudRepository extends CrudRepository<Customer, Long> {


}
