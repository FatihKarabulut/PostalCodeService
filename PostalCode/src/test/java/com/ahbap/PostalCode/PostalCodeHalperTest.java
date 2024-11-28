package com.ahbap.PostalCode;

import com.ahbap.GeonamesPostalCodeServiceLib.services.PostalService;
import com.ahbap.PostalCode.dao.PostalCodeHalper;
import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;
import com.ahbap.PostalCode.mapper.PostalCodeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@EntityScan(basePackages = "com.ahbap")
@ComponentScan(basePackages = "com.ahbap")

public class PostalCodeHalperTest {

    @Autowired
    public PostalService service;
    @Autowired
    public PostalCodeHalper pos;

    @Autowired
    public PostalCodeMapper m_mapper;
    @BeforeEach
    public void setUp()
    {
        var postal = service.findByPostalList("72000");

        pos.save(postal.postalCodes.stream().map(m_mapper::toPostalCode).toList());


    }
    @Test
    public void findByCity()
    {
        var citiy = "Batman";
        assertEquals(citiy, pos.findByCity(citiy).get(0).adminName1);
    }

    @Test
    void existsByCityTrue()
    {
        assertTrue(pos.existsByCity("Batman"));
    }
    @Test
    void existsByPostalCodeTrue()
    {
        assertTrue(pos.existsByPostalCode("72000"));
    }
    @Test
    void existsByPostalCodeFalse()
    {
        assertFalse(pos.existsByPostalCode("72500"));
    }
    @Test
    void findByPostalCode()
    {
        List<PostalcodeInfoRepo> postal = null;
        if (pos.existsByPostalCode("72000"))
            postal = pos.findByPostalCode("72000");

        assertNotNull(postal);
        assertEquals("Batman",postal.get(0).adminName1);
    }
}
