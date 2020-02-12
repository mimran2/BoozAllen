package com.bah.msd.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

}
