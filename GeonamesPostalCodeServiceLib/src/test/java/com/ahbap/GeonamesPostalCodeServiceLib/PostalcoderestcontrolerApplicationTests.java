package com.ahbap.GeonamesPostalCodeServiceLib;

import com.ahbap.GeonamesPostalCodeServiceLib.services.PostalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootApplication
@SpringBootTest
class PostalcoderestcontrolerApplicationTests {

	@Autowired
	public PostalService service;
	@Test
	void contextLoads() {
	}

}
