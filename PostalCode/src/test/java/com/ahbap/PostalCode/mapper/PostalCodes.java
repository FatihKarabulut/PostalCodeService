package com.ahbap.PostalCode.mapper;

import com.ahbap.GeonamesPostalCodeServiceLib.geonames.PostalCodeInfo;
import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;
import org.springframework.stereotype.Component;

@Component
public class PostalCodes implements PostalCodeMapper{
    @Override
    public PostalcodeInfoRepo toPostalCode(PostalCodeInfo postalCodes) {
        var postal = new PostalcodeInfoRepo();
        postal.adminCode1 = postalCodes.adminCode1;
        postal.adminName1 = postalCodes.adminName1;
        postal.countryCode = postalCodes.countryCode;
        postal.adminName2 = postalCodes.adminName2;
        postal.lng  = postalCodes.lng;
        postal.countryCode = postalCodes.countryCode;
        postal.placeName = postalCodes.placeName;
        postal.lat = postalCodes.lat;
        postal.iSO31662 = postalCodes.iSO31662;
        postal.postalCode = postalCodes.postalCode;
        return postal;
    }
}
