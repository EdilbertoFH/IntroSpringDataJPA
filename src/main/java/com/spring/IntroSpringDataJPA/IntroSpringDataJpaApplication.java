package com.spring.IntroSpringDataJPA;

import com.spring.IntroSpringDataJPA.persistence.entity.Customer;
import com.spring.IntroSpringDataJPA.persistence.respository.ICustomerCrudRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
public class IntroSpringDataJpaApplication {

/*coments*/
	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}
	@Autowired
	private ICustomerCrudRepository iCustomerCrudRepository;

	@Bean
	public CommandLineRunner testCustomerRepositoryCommand(){
		return args -> {
			System.out.println("Ejecutando testCustomerRepositoryCommand");

			Customer juan = new Customer();
			juan.setName("Juan Murillo");
			juan.setPassword("juan123");

			iCustomerCrudRepository.save(juan);

			System.out.println("Se guardo la entidad Juan");

			System.out.println("\n Mostrando los registros existentes");
			iCustomerCrudRepository.findAll().forEach(System.out::println);

			Optional<Customer>icustomerCrudRepository = iCustomerCrudRepository.findById(1L);
			if(icustomerCrudRepository.isPresent()){
				System.out.println("El registro con id 1 existe");
			}else{
				System.out.println("El registro con id 1 no existe");
			}
			System.out.println("\n Borrar registro con id 1");
			iCustomerCrudRepository.deleteById(1L);

		};

	}





}
