package com.bah.msd.persistence;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.entities.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {
}
