package com.ahbap.PostalCodeDataService.mapper;

import com.ahbap.GeonamesPostalCodeServiceLib.geonames.PostalCodeInfo;
import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;
import com.ahbap.PostalCodeDataService.entity.PostalcodeInfoDto;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PostalCodeMapperImpl",componentModel = "spring")
public interface IPostalCodeMapper {

    PostalcodeInfoRepo toPostalCode(PostalcodeInfoDto postalcodeInfoDto);
    PostalcodeInfoDto toPostalCodeDto(PostalcodeInfoRepo postalcodeInfo);
    PostalcodeInfoDto toPostalCodesDto(PostalCodeInfo postalcodeInfo);

}
