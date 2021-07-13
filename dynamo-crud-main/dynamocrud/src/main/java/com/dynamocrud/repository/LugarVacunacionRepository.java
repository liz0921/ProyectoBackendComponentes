package com.dynamocrud.repository;

import com.dynamocrud.entity.LugarVacunacion;
import com.dynamocrud.entity.TipoVacuna;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface LugarVacunacionRepository extends CrudRepository<LugarVacunacion, String> {
}
