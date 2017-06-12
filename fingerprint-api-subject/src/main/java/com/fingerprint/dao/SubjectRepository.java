package com.fingerprint.dao;

import com.fingerprint.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by lauearo on 25/05/2017.
 */
@RepositoryRestResource(path = "subject")
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
