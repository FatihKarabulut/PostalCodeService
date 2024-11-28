package com.ahbap.GeonamesPostalCodeServiceLib.geonames;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PostalCodeInfo {
    public String adminCode1;
    public String adminName2;
    public double lng;
    public String countryCode;
    public String postalCode;
    public String adminName1;
    @JsonProperty("ISO3166-2")
    public String iSO31662;
    public String placeName;
    public double lat;
}

