package com.ahbap.GeonamesPostalCodeServiceLib.services;

import com.ahbap.GeonamesPostalCodeServiceLib.geonames.PostalCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class PostalService {
    public static final String m_Url = "http://api.geonames.org/postalCodeSearchJSON?postalcode=%s&maxRows=%d&username=fatihkarabulut&country=tr";
    public static final int m_maxRow= 500;
    public RestTemplate rest;

    public PostalService(RestTemplate rest) {
        this.rest = rest;
    }

    public PostalCode findByPostalCodeAndMaxRow(String postalCode, int maxRow)
    {
        var url = m_Url.formatted(postalCode,maxRow);
        return rest.getForObject(url, PostalCode.class);
    }
    public PostalCode findByPostalList(String postalCode)
    {
        var url = m_Url.formatted(postalCode,m_maxRow);

        return rest.getForObject(url, PostalCode.class);
    }
}
