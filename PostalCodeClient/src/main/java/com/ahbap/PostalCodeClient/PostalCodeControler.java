package com.ahbap.PostalCodeClient;

import com.ahbap.PostalCodeDataService.PostalCodeDataService;
import com.ahbap.PostalCodeDataService.entity.PostalcodeInfoDto;
import com.exception.DataServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("Postal")
@Slf4j
public class PostalCodeControler {

    public PostalCodeDataService dataService;

    public PostalCodeControler(PostalCodeDataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/dataPostal")
    public ResponseEntity<List<PostalcodeInfoDto>> Postal(@RequestParam(name = "postalCode") String postalCode)
    {
        try {
            return ResponseEntity.ok(dataService.findByPostalCode(postalCode));
        }
        catch (DataServiceException ex)
        {
            log.error("DataServiceException Client Postal %s ".formatted(ex.getMessage()),ex);
        }
        catch (Throwable ex)
        {
            log.error("Throwable Client Postal %s ".formatted(ex.getMessage()),ex);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList(new PostalcodeInfoDto()));
    }

    @GetMapping("/dataCity")
    public ResponseEntity<List<PostalcodeInfoDto>> findByCity(@RequestParam(name = "cityCode") String city)
    {
        try{
            return ResponseEntity.ok(dataService.findByCity(city));
        }
        catch (DataServiceException ex)
        {
            log.error("DataServiceException Client city %s ".formatted(ex.getMessage()),ex);
        }
        catch (Throwable ex)
        {
            log.error("Throwable Client city %s ".formatted(ex.getMessage()),ex);
        }
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList(new PostalcodeInfoDto()));
    }
}
