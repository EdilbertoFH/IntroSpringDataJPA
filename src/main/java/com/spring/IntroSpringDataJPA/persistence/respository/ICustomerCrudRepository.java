package com.spring.IntroSpringDataJPA.persistence.respository;

import com.spring.IntroSpringDataJPA.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
/*
    Resumen de las JPARepository sirve para armar querys personalizadas a nivel persistencia de base de datos para consultas u operaciones mas especificas
    CRUD repository contiene las operaciones de consulta, guardar o eliminar para realizar a nivel generico.
 */
public interface ICustomerCrudRepository extends JpaRepository<Customer, Long> {

   Customer searchByUsername(String username);

    Optional<Customer> findByUsername(String username);

    List<Customer> searchByNameContaining(String name);//SELECT c.* FROM customers c WHERE c.name LIKE %?%

    List<Customer> queryByNameStartingWith(String username);//SELECT c.* FROM customers c WHERE c.name LIKE ?%

    List<Customer> readByNameIsEndingWith(String username);//SELECT c.* FROM customers c WHERE c.name LIKE %?

    List<Customer> findByNameContainingAndIdGreaterThanOrderByIdDesc(String name, Long id);
    // SELECET c. * FROM customer c where c.name like %?1% and c.id > ? %2 order by desc

   @Query("select c from Customer c where c.name like %?1% and c.id >= ?2 order by c.id desc")
   List <Customer> findAllByNameAndIdGreatherThan(String name, Long id);


}
