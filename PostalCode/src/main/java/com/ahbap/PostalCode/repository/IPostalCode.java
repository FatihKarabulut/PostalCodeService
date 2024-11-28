package com.ahbap.PostalCode.repository;

import com.ahbap.PostalCode.entitiy.PostalCodeRepo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IPostalCode extends CrudRepository<PostalCodeRepo,Long> {

    @Query(nativeQuery = true,value = "select * from postal_code pc  \n" +
            "where date_part('year',pc.postal_code_date) = :year and  date_part('month',pc.postal_code_date) = :month ")
    List<PostalCodeRepo> findByDate(@Param(value = "year") int year, @Param(value = "month") int month);

    boolean existsByPostalCode(@Param("postal_code") String PostalCode);

}
