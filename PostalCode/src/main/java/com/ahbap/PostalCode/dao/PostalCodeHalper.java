package com.ahbap.PostalCode.dao;

import com.ahbap.PostalCode.entitiy.PostalCodeRepo;
import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;
import com.ahbap.PostalCode.repository.IPostalCode;
import com.ahbap.PostalCode.repository.IPostalCodeInfo;
import com.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.beans.Transient;
import java.util.List;

@Component
@Slf4j
public class PostalCodeHalper {

    public IPostalCodeInfo postalCodeInfo;
    public IPostalCode postalCode;

    public PostalCodeHalper(IPostalCodeInfo postalCodeInfo, IPostalCode postalCode) {
        this.postalCodeInfo = postalCodeInfo;
        this.postalCode = postalCode;
    }

    @Transient
    public void save(List<PostalcodeInfoRepo> info)
    {
        try {

            var postal = new PostalCodeRepo();

            postal.postalCode = info.get(0).postalCode;
            postalCode.save(postal);
            info.forEach(a -> a.postals = postal) ;
           info.forEach(a -> postalCodeInfo.save(a));

        }
        catch (Throwable ex)
        {
            log.info("RepositoryException Save");
            throw new RepositoryException("RepositoryException save",ex);
        }

    }
    public List<PostalcodeInfoRepo> findByCity(String city)
    {
        try {
            return postalCodeInfo.findByCity(city);
        }
        catch (Throwable ex)
        {
            log.info("RepositoryException findByCity ");
            throw new RepositoryException("RepositoryException findByCity ",ex);
        }
    }
    public List<PostalcodeInfoRepo> findByPostalCode(String postal_code)
    {
        try {
            return postalCodeInfo.findByPostalCode(postal_code);
        }
        catch (Throwable ex)
        {
            log.info("RepositoryException findByPostalCode ");
            throw new RepositoryException("RepositoryException findByPostalCode ",ex);
        }
    }
    public boolean existsByCity(String city)
    {
        try {
            return postalCodeInfo.existsByCity(city);
        }
        catch (Throwable ex)
        {
            log.info("RepositoryException existsByCity ");
            throw new RepositoryException("RepositoryException existsByCity ",ex);
        }

    }
    public boolean existsByPostalCode(String postal_code)
    {
        try {
            return postalCode.existsByPostalCode(postal_code);
        }
        catch (Throwable ex)
        {
            log.info("RepositoryException existsByPostalCode ");
            throw new RepositoryException("RepositoryException existsByPostalCode ",ex);
        }
    }

}
