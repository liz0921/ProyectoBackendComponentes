package com.dynamocrud.repository;

import com.dynamocrud.entity.Cita;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface CitaRepository extends CrudRepository<Cita, String> {
    boolean existsById(String idCita);
}
