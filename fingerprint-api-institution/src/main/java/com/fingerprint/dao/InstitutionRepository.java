package com.fingerprint.dao;

import com.fingerprint.model.Institution;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by lauearo on 25/05/2017.
 */
@RepositoryRestResource(path = "/api")
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
