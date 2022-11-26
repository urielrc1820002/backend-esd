package com.crud.repository;

import com.crud.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer> {
}
