package com.bah.msd.entities;

import java.util.Date;

public class Registration {
	private long id;
	
	private Customer customer;
	private Event event;
	
	private Date registration_date;
	
	private String notes;

	public Registration(long id, Customer customer, Event event, Date registration_date, String notes) {
		super();
		this.id = id;
		this.customer = customer;
		this.event = event;
		this.registration_date = registration_date;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
}
