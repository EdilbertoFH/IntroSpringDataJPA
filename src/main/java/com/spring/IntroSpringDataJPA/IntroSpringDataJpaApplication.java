package com.spring.IntroSpringDataJPA;

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

@SpringBootApplication
public class IntroSpringDataJpaApplication {


	public static void main(String[] args) {
		SpringApplication.run(IntroSpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner validateDSComand(DataSource ds){
		return args -> {
			System.out.println("\nIniciando datasource y Data Source\n");

		Connection con = ds.getConnection();
		PreparedStatement pstm = (PreparedStatement) con.prepareStatement("select * from videojuego");
		ResultSet rs = pstm.executeQuery();

		while(rs.next()){
			String mensaje= rs.getString("FIIDVIDEOJ") + "-" + rs.getString("NOMBREVIDEOJ") +
					"-" + rs.getString("DESCVIDEOJ") + "-" + rs.getString("GENERO")+
					"-" + rs.getString("PLATAFORMA") + "-" + rs.getString("ANIOLANZ");
			System.out.println("\n" + mensaje + "\n");

		}
		};

	}
	@Bean
	public CommandLineRunner validaEntityManagerFact(EntityManager em){
		return args -> {
			System.out.println("\nProbando EntityManagerFactory\n");

			List<Object[]> registros =  em.createNativeQuery("SELECT * FROM VIDEOJUEGO").getResultList();
			registros.forEach(row -> {
				String mensaje = row[0] + "-" + row[1] + "-" + row[2] + "-" + row[3];
				System.out.println("\n" + mensaje + "\n");
			});




		};
	}

}
