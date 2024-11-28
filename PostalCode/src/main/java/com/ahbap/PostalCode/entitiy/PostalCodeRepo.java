package com.ahbap.PostalCode.entitiy;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;


@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Postal_Code")
public class PostalCodeRepo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Postal_Code_id")
    public long id;
    @Column(name = "Postal_Code_Date",nullable = false)
    public LocalDateTime datetime = LocalDateTime.now();
    @Column(name = "postal_code")
    public String postalCode;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "postals",cascade = CascadeType.ALL)
    public Set<PostalcodeInfoRepo> postalCodes;
}
