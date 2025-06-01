package com.spring.IntroSpringDataJPA.persistence.respository;

import com.spring.IntroSpringDataJPA.persistence.entity.Customer;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ICustomerCrudRepository extends Repository<Customer, Long> {

    //Implementamos una lista para buscar todos los registros
    List<Customer>findAll();

    //Busar por Id, va dentro de un optional para evitar nullpointer en tiempo de ejecucion
    Optional<Customer>findById(Long id);

    //Guardar
    Customer save(Customer customer);

    void deleteById(Long id);
}
