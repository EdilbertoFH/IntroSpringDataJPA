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


			Customer rosendo = new Customer();
			rosendo.setName("Rosendo");
			rosendo.setPassword("rose123");
			rosendo.setUsername("rose123");

			Customer juan = new Customer();
			juan.setName("Juan Murillo");
			juan.setPassword("juan123");
			juan.setUsername("juan123");

			//Creamos uno repetido
			Customer juan2 = new Customer();
			juan.setName("Juan Mauricio");
			juan.setPassword("juan123");
			juan.setUsername("juanito123");


			List<Customer>clientes = List.of(rosendo, juan,juan2);
			iCustomerCrudRepository.saveAll(clientes);

			System.out.println("\n Se guardaron los 2 registros");
			iCustomerCrudRepository.searchByUsername("juan123");
			System.out.println("\n Se busco por username");

			System.out.println("\n Se guardaron los 2 registros");
			iCustomerCrudRepository.findByUsername("juan123");
			System.out.println("\n Se busco por username");

			//Pruebas parte2 jpa
			System.out.println("\n Nombres que contienen la letra o");
			iCustomerCrudRepository.searchByNameContaining("o").forEach(System.out::println);

			System.out.println("\n Nombres que terminan con las letras ez");
			iCustomerCrudRepository.readByNameIsEndingWith("ez").forEach(System.out::println);

			System.out.println("\n Nombres que inician la letra");
			iCustomerCrudRepository.queryByNameStartingWith("o").forEach(System.out::println);



		};

	}





}
