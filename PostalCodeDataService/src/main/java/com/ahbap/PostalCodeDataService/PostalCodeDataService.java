package com.ahbap.PostalCodeDataService;

import com.ahbap.GeonamesPostalCodeServiceLib.services.PostalService;
import com.ahbap.PostalCode.dao.PostalCodeHalper;
import com.ahbap.PostalCodeDataService.entity.PostalcodeInfoDto;
import com.ahbap.PostalCodeDataService.mapper.IPostalCodeMapper;
import com.exception.DataServiceException;
import com.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@ComponentScan(basePackages = "com.ahbap")
public class PostalCodeDataService {
    public IPostalCodeMapper m_Mapper;
    public PostalCodeHalper m_PostalCodeHalper;
    public PostalService service;

    public PostalCodeDataService(IPostalCodeMapper m_Mapper, PostalCodeHalper m_PostalCodeHalper, PostalService service) {
        this.m_Mapper = m_Mapper;
        this.m_PostalCodeHalper = m_PostalCodeHalper;
        this.service = service;
    }
    private List<PostalcodeInfoDto> PostalCodeInDb(String postalcode)
    {
        return m_PostalCodeHalper.findByPostalCode(postalcode).stream().map(m_Mapper::toPostalCodeDto).toList();
    }
    private List<PostalcodeInfoDto> PostalCodeNotInDb(String postalcode)
    {
        var postal = service.findByPostalList(postalcode).postalCodes.stream().map(m_Mapper::toPostalCodesDto).toList();

        m_PostalCodeHalper.save(postal.stream().map(m_Mapper::toPostalCode).toList());

        return postal;
    }
    public List<PostalcodeInfoDto> findByCity(String city)
    {
        try {
            if (existsByCity(city))
                return m_PostalCodeHalper.findByCity(city).stream().map(m_Mapper::toPostalCodeDto).toList();
            return null;
        }
        catch (RepositoryException ex)
        {
            log.error("RepositoryException PostalCodeDataService findByCity ");
            throw new DataServiceException("RepositoryException PostalCodeDataService findByCity %s".formatted(ex.getMessage()),ex);
        }
        catch (Throwable ex)
        {
            log.error("Throwable PostalCodeDataService findByCity ");
            throw new RepositoryException("Throwable PostalCodeDataService findByCity ",ex);
        }
    }
    public List<PostalcodeInfoDto> findByPostalCode(String postal_code)
    {
        try {
            var postal = m_PostalCodeHalper.findByPostalCode(postal_code);
            return postal.isEmpty() ? PostalCodeNotInDb(postal_code): PostalCodeInDb(postal_code);
        }
        catch (RepositoryException ex)
        {
            log.error("RepositoryException PostalCodeDataService findByPostalCode ");
            throw new DataServiceException("RepositoryException PostalCodeDataService findByPostalCode %s".formatted(ex.getMessage()),ex);
        }
        catch (Throwable ex)
        {
            log.error("Throwable PostalCodeDataService findByPostalCode ");
            throw new RepositoryException("Throwable PostalCodeDataService findByPostalCode ");
        }
    }
    public boolean existsByCity(String city)
    {
        try {
            return m_PostalCodeHalper.existsByCity(city);
        }
        catch (RepositoryException ex)
        {
            log.error("RepositoryException PostalCodeDataService existsByCity ");
            throw new DataServiceException("RepositoryException PostalCodeDataService existsByCity %s".formatted(ex.getMessage()),ex);
        }
        catch (Throwable ex)
        {
            log.error("Throwable PostalCodeDataService existsByCity ");
            throw new DataServiceException("Throwable PostalCodeDataService existsByCity %s".formatted(ex.getMessage()),ex);
        }


    }
    public boolean existsByPostalCode(String postal_code)
    {
        try {
            return m_PostalCodeHalper.existsByPostalCode(postal_code);
        }
        catch (RepositoryException ex)
        {
            log.error("RepositoryException PostalCodeDataService existsByPostalCode ");
            throw new DataServiceException("RepositoryException PostalCodeDataService existsByPostalCode %s".formatted(ex.getMessage()),ex);
        }
        catch (Throwable ex)
        {
            log.error("Throwable PostalCodeDataService existsByPostalCode ");
            throw new RepositoryException("Throwable PostalCodeDataService existsByPostalCode ");
        }
    }

}
