package com.ahbap.PostalCodeDataService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;


@SpringBootApplication
@SpringBootTest
@EntityScan(basePackages = "com.ahbap")
@EnableJpaRepositories(basePackages = "com.ahbap")
@TestPropertySource(locations = "classpath:application.properties")
@ComponentScan("com.ahbap")
class PostalCodeDataServiceTest {
	@Autowired
	private PostalCodeDataService postalCodeDataService;
	@BeforeEach
	void contextLoads() {

		assertEquals("Batman",postalCodeDataService.findByPostalCode("72000").get(0).adminName1);
	}



	@Test
	void existsByCityTrue()
	{
		assertTrue(postalCodeDataService.existsByCity("Batman"));
	}
	@Test
	void existsByPostalCodeTrue()
	{
		assertTrue(postalCodeDataService.existsByPostalCode("72000"));
	}
	@Test
	void existsByPostalCodeFalse()
	{
		assertFalse(postalCodeDataService.existsByPostalCode("72500"));
	}

}
