package com.spring.IntroSpringDataJPA.persistence.respository;

import com.spring.IntroSpringDataJPA.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdressRepository extends JpaRepository<Address, Long> {

}
