package com.ahbap.PostalCode;


import com.ahbap.GeonamesPostalCodeServiceLib.geonames.PostalCodeInfo;
import com.ahbap.GeonamesPostalCodeServiceLib.services.PostalService;
import com.ahbap.PostalCode.entitiy.PostalCodeRepo;
import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;
import com.ahbap.PostalCode.mapper.PostalCodeMapper;
import com.ahbap.PostalCode.repository.IPostalCode;
import com.ahbap.PostalCode.repository.IPostalCodeInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootApplication
@SpringBootTest
@EntityScan("com.ahbap")
@EnableJpaRepositories
@TestPropertySource(locations = "classpath:application.properties")
@ComponentScan(basePackages = "com.ahbap")
@Slf4j
class PostalCodeServicesTest {

	@Autowired
	public IPostalCode IPostal;
	@Autowired
	public PostalService service;

	@Autowired
	public IPostalCodeInfo IPostalInfos;

	@Autowired
	public PostalCodeMapper m_mapper;

	public void Save(PostalCodeInfo postal, PostalCodeRepo postalCode)
	{
		var PostalInfo = m_mapper.toPostalCode(postal);


		PostalInfo.postals = postalCode;
		IPostalInfos.save(PostalInfo);
	}
	@BeforeEach
	void setUp()
	{

		var postal = service.findByPostalCodeAndMaxRow("72000",10);
		var postalCode = new PostalCodeRepo();

		postalCode.postalCode = postal.postalCodes.get(0).postalCode;
		IPostal.save(postalCode);
		postal.postalCodes.forEach(a -> Save(a,postalCode));


	}

	@Test
	public void findByCity()
	{
		var citiy = "Batman";
		assertEquals(citiy, IPostalInfos.findByCity(citiy).get(0).adminName1);
	}
	@Test
	void findByDateNotnull()
	{
		var s = IPostal.findByDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue());

		if (s.isEmpty())
			s = null;

		assertNotNull(s);

	}
	@Test
	void findByDateNull()
	{
		var s = IPostal.findByDate(LocalDate.now().getYear()+1, LocalDate.now().getMonthValue() +1);
		if (s.isEmpty())
			s = null;

			assertNull(s);

	}
	@Test
	void existsByCityTrue()
	{
		assertTrue(IPostalInfos.existsByCity("Batman"));
	}
	@Test
	void existsByPostalCodeTrue()
	{
		assertTrue(IPostal.existsByPostalCode("72000"));
	}
	@Test
	void existsByPostalCodeFalse()
	{
		assertFalse(IPostal.existsByPostalCode("72500"));
	}
	@Test
	void findByPostalCode()
	{
		List<PostalcodeInfoRepo> postal = null;
		if (IPostal.existsByPostalCode("72000"))
			 postal = IPostalInfos.findByPostalCode("72000");

		assertNotNull(postal);
		assertEquals("Batman",postal.get(0).adminName1);
	}
}
