package com.ahbap.PostalCode.entitiy;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "postal_code_info")
public class PostalcodeInfoRepo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postal_code_info_id")
    public long id;
    @Column(name = "admin_code1")
    public String adminCode1;
    @Column(name = "admin_name2")
    public String adminName2;
    public double lng;
    @Column(name = "country_code")
    public String countryCode;
    @Column(name = "postal_code")
    public String postalCode;
    @Column(name = "admin_name1")
    public String adminName1;
    @Column(name = "iSO3166-2")
    public String iSO31662;
    @Column(name = "place_name")
    public String placeName;
    public double lat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Postal_Code_id",nullable = false)
    public PostalCodeRepo postals;

}

