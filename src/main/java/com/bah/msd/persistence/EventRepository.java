package com.bah.msd.persistence;

import org.springframework.data.repository.CrudRepository;

import com.bah.msd.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long>{ 
}
