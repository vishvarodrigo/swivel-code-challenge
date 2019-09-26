package com.swivel.codechallenge;

import org.json.simple.JSONObject;

import com.swivel.codechallenge.enums.Source;
import com.swivel.codechallenge.services.GenericService;
import com.swivel.codechallenge.services.OrganizationService;
import com.swivel.codechallenge.services.TicketService;
import com.swivel.codechallenge.services.UserService;
import com.swivel.codechallenge.utils.Util;

public class Application {
	private final UserService userService;
	private final TicketService ticketService;
	private final OrganizationService organizationService;
	private final GenericService genericService;

	public Application() {
		this.userService = UserService.userService();
		this.ticketService = TicketService.ticketService();
		this.organizationService = OrganizationService.origanizationService();
		this.genericService = GenericService.genericService();
	}

	public static void main(String[] args) {
		try {
			Application application = new Application();
			application.run();
		} catch (Exception ex) {
			System.out.println(Util.INVALID_INPUT_TEXT + ex.getMessage());
		}
	}
	
	private void displayHeaders() {
		genericService.displayTitle(Util.MAIN_HEADER_TEXT);
		genericService.displayTitle(Util.OPTIONS_TEXT);
	}
	
	@SuppressWarnings("unchecked")
	private void initiateSearchOption(int input) {
		JSONObject jsonObject = null;
		
		if(input==Source.USERS.getValue()) {
			jsonObject = genericService.initiate(Source.USERS);
			ticketService.appendAssigneeTicketSubjectAndSubmittedTicketSubject(jsonObject);
			organizationService.appendOrganizationName(jsonObject);
		}
		else if(input==Source.TICKETS.getValue()) {
			jsonObject = genericService.initiate(Source.TICKETS);
			userService.appendAssigneeNameAndSubmitterName(jsonObject);
			organizationService.appendOrganizationName(jsonObject);
		}
		else if(input==Source.ORGANIZATIONS.getValue()) {
			jsonObject = genericService.initiate(Source.ORGANIZATIONS);
			ticketService.appendTicketSubject(jsonObject);
			userService.appendUsername(jsonObject);
		}else {
			System.out.println(Util.INVALID_INPUT_TEXT);
		}
		
		jsonObject.forEach((k, v) -> {
			System.out.printf("%-20s %-20s%n", k, v);
		});
		
		genericService.displayEmptyLine();
	}
	
	public void run(){
		while (true) {
			displayHeaders();
			switch (genericService.getInputString()) {
			case "1":
				genericService.displayTitle(Util.SEARCH_OPTION_TEXT);
				initiateSearchOption(genericService.getInputInteger());
				break;
			case "2":
				genericService.displaySearchKeys(Source.USERS);
				genericService.displaySearchKeys(Source.TICKETS);
				genericService.displaySearchKeys(Source.ORGANIZATIONS);
				break;
			case "q":
				System.out.println(Util.THANK_YOU_TEXT);
				return;
			default:
				break;
			}
		}
	}
	
}
