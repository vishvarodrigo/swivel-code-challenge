package com.swivel.codechallenge.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.swivel.codechallenge.enums.Source;

public class TicketService {
	private static final TicketService ticketService = new TicketService();
	private final GenericService genericService = GenericService.genericService();

	// Restrict new object creation by making constructor private
	private TicketService() {
	}

	// Provide singleton object Ex: @autowired
	public static TicketService ticketService() {
		return ticketService == null ? new TicketService() : ticketService;
	}

	@SuppressWarnings("unchecked")
	public void appendTicketSubject(JSONObject transformObject) {
		JSONArray jsonArray = genericService.readDataFromFile(Source.TICKETS);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.get("organization_id").equals(transformObject.get("_id"))) {
					transformObject.put("ticket_subject", jsonObject.get("subject"));
					return;
				}
			}
		} catch (NullPointerException ex) {
			transformObject.put("ticket_subject", "no ticket found");
		}
	}

	@SuppressWarnings("unchecked")
	public void appendAssigneeTicketSubjectAndSubmittedTicketSubject(JSONObject transformObject) {
		JSONArray jsonArray = genericService.readDataFromFile(Source.TICKETS);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.get("assignee_id").equals(transformObject.get("_id"))) {
					transformObject.put("assignee_ticket_subject", jsonObject.get("subject"));
				} else if (jsonObject.get("submitter_id").equals(transformObject.get("_id"))) {
					transformObject.put("submitter_ticket_subject", jsonObject.get("subject"));
				}
			}
		} catch (NullPointerException ex) {
			transformObject.putIfAbsent("assignee_ticket_subject", "no assignee ticket found");
			transformObject.putIfAbsent("submitter_ticket_subject", "no submitter ticket found");
		}
	}

}
