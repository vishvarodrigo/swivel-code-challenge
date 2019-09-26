package com.swivel.codechallenge.services;

import org.json.simple.JSONObject;
import org.junit.Test;

public class TicketServiceTest {

	private TicketService ticketService;

	public TicketServiceTest() {
		this.ticketService = TicketService.ticketService();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void appendTicketSubjectTest() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("organization_id", 101);
		
		ticketService.appendTicketSubject(jsonObject);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void appendAssigneeTicketSubjectAndSubmittedTicketSubjectTest() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("organization_id", 101);
		
		ticketService.appendAssigneeTicketSubjectAndSubmittedTicketSubject(jsonObject);
	}
	
}
