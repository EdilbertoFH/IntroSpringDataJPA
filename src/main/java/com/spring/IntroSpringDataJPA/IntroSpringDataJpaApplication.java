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

			Address rosendoAddresOne = new Address();
			rosendoAddresOne.setCountry("United States");
			rosendoAddresOne.setAddress("1st street");
			Address rosendoAddrestwo = new Address();
			rosendoAddrestwo.setCountry("Mexico");
			rosendoAddrestwo.setAddress("La rosa, rosarito sinaloa.");
			//rosendo.setAddresses(rosendoAddres);


			Customer juan = new Customer();
			juan.setName("Juan Murillo");
			juan.setPassword("juanito123");
			juan.setUsername("juanito123");
			Address juanAddres = new Address();
			juanAddres.setCountry("Russia");
			juanAddres.setAddress("2nd street");

			Address juanAddrestwo = new Address();
			juanAddrestwo.setCountry("United States");
			juanAddrestwo.setAddress("3rd street");
			//juan.setAddresses(juanAddres);


			Customer liz = new Customer();
			juan.setName("Liz Torres de Hernandez");
			juan.setPassword("liz124");
			juan.setUsername("liz124");
			Address lizAddresone = new Address();
			lizAddresone.setCountry("Mexico");
			lizAddresone.setAddress("Petatlan");
			Address lizAddrestow = new Address();
			lizAddrestow.setCountry("Mexico");
			lizAddrestow.setAddress("Ciudad de mexico, Coyoacan Pedregal de SantoDomingo");
			//liz.setAddress(lizAddres);


			rosendo.setAddresses(List.of(rosendoAddresOne, rosendoAddrestwo));
			juan.setAddresses(List.of(juanAddres));
			liz.setAddresses(List.of(lizAddresone, lizAddrestow));

			iCustomerCrudRepository.save(juan);
			iCustomerCrudRepository.save(liz);
			iCustomerCrudRepository.save(rosendo);

		};

	}




}
