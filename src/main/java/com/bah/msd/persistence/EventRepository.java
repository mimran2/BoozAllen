package com.bah.msd.persistence;

import java.util.Collection;

import com.bah.msd.entities.Event;

public interface EventRepository {
	public Collection<Event> findAll();
	public Event findOne(long id);
	public Event save(Event event);
	public void delete(long id);
}
