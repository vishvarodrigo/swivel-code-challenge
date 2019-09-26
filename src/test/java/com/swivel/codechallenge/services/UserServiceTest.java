package com.swivel.codechallenge.services;

import org.json.simple.JSONObject;
import org.junit.Test;

public class UserServiceTest {

	private UserService userService;

	public UserServiceTest() {
		this.userService = UserService.userService();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void appendUsernameTest() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("organization_id", 101);
		
		userService.appendUsername(jsonObject);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void appendAssigneeNameAndSubmitterNameTest() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("submitter_id", 38);
		jsonObject.put("submitter_id", 24);
		userService.appendAssigneeNameAndSubmitterName(jsonObject);
	}
	
	@Test
	public void appendAssigneeNameAndSubmitterNameTestException() {
		JSONObject jsonObject = new JSONObject();
		userService.appendAssigneeNameAndSubmitterName(jsonObject);
	}
}
