package com.bah.msd.persistence;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long>{ 
}
