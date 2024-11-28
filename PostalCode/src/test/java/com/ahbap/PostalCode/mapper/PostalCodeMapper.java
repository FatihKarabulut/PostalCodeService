package com.ahbap.PostalCode.mapper;

import com.ahbap.GeonamesPostalCodeServiceLib.geonames.PostalCodeInfo;
import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;

public interface PostalCodeMapper {

     PostalcodeInfoRepo toPostalCode(PostalCodeInfo postalCodes);
}
