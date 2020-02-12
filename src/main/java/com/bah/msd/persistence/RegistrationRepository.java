package com.bah.msd.persistence;

import java.util.Collection;

import com.bah.msd.entities.Registration;

public interface RegistrationRepository {
	public Collection<Registration> findAll();
}
