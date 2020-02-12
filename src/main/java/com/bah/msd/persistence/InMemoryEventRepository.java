package com.bah.msd.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.bah.msd.entities.Event;

@Component
public class InMemoryEventRepository implements EventRepository {
	public List<Event> eventList = new ArrayList<>(
			Arrays.asList(new Event(1, "CMSCM130", "Hiring Event", "Find your future job"),
					new Event(2, "AMZN", "Amazon Workshop", "Learn about AWS"),
					new Event(3, "LOL", "League of Legend", "Play game!")));
	@Override
	public Collection<Event> findAll() {
		// TODO Auto-generated method stub
		return eventList;
	}
	@Override
	public Event findOne(long id) {
		Optional<Event> eventOptional = eventList.stream().filter(
				x -> x.getId() == id).findAny();
		return eventOptional.orElse(null);
	}
	@Override
	public Event save(Event event) {
		Event foundEvent = findOne(event.getId());
		if(foundEvent == null) {
			eventList.add(event);
			return event;
		}else {
			foundEvent.setId(event.getId());
			foundEvent.setDescription(event.getDescription());
			foundEvent.setTitle(event.getTitle());
			foundEvent.setCode(event.getCode());
		}
		return foundEvent;
	}
	@Override
	public void delete(long id) {
		Event event = findOne(id);
		eventList.remove(event);
	}
	
	

}
