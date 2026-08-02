package com.spring.IntroSpringDataJPA;

import com.spring.IntroSpringDataJPA.persistence.entity.Address;
import com.spring.IntroSpringDataJPA.persistence.entity.Customer;
import com.spring.IntroSpringDataJPA.persistence.respository.IAdressRepository;
import com.spring.IntroSpringDataJPA.persistence.respository.ICustomerCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;


@SpringBootApplication
public class IntroSpringDataJpaApplication {

/*coments*/
	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}
	@Autowired
	private ICustomerCrudRepository iCustomerCrudRepository;

	@Bean
	public CommandLineRunner testOnetoOneRelationShipsCommand(){
		return args -> {

			System.out.println("Ejecutando testCustomerRepositoryCommand");


			Customer rosendo = new Customer();
			rosendo.setName("Rosendo Rosas");
			rosendo.setPassword("rose123");
			rosendo.setUsername("rose123");
			Address rosendoAddres = new Address();
			rosendoAddres.setCountry("United States");
			rosendoAddres.setAddress("1st street");
			rosendo.setAddress(rosendoAddres);


			Customer juan = new Customer();
			juan.setName("Juan Murillo");
			juan.setPassword("juanito123");
			juan.setUsername("juanito123");
			Address juanAddres = new Address();
			juanAddres.setCountry("Russia");
			juanAddres.setAddress("2nd street");
			juan.setAddress(juanAddres);


			Customer liz = new Customer();
			juan.setName("Liz Torres de Hernandez");
			juan.setPassword("liz124");
			juan.setUsername("liz124");
			Address lizAddres = new Address();
			lizAddres.setCountry("Mexico");
			lizAddres.setAddress("Petatlan");
			liz.setAddress(lizAddres);


			List<Customer>clientes = List.of(rosendo, juan, liz);
			iCustomerCrudRepository.saveAll(clientes);
			System.out.println("\n Se guardaron los 3 registros");

			System.out.println("\n Consutla general");
			iCustomerCrudRepository.findAll().forEach(System.out::println);



		};

	}

	@Bean
	public CommandLineRunner testAddresCrudRepository(IAdressRepository address){
		return args -> {
			address.findAll().forEach(each ->{
				System.out.println(each.getAddress() + " - " + each.getCustomer().getId());
			});
		};
	}





}
