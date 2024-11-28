package com.ahbap.PostalCode.repository;

import com.ahbap.PostalCode.entitiy.PostalcodeInfoRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostalCodeInfo extends CrudRepository<PostalcodeInfoRepo,Long> {

    @Query(nativeQuery = true,value = "Select * from postal_code_info p where p.admin_name1 = :city")
    List<PostalcodeInfoRepo> findByCity(@Param(value = "city") String city);

    @Query(nativeQuery = true,value = "Select count(*) > 0 from postal_code_info p where p.admin_name1 = :city")
    boolean existsByCity(@Param(value = "city") String city);

    List<PostalcodeInfoRepo> findByPostalCode(@Param("postal_code") String postal_code);
}
