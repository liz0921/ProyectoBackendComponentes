package com.dynamocrud.repository;

import com.dynamocrud.entity.TipoVacuna;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository

public interface TipoVacunaRepository  extends CrudRepository<TipoVacuna, String> {
    boolean existsByIdTipoVacuna(String idTipoVacuna);
}