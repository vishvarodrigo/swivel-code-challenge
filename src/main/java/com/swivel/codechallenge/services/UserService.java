package com.swivel.codechallenge.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.swivel.codechallenge.enums.Source;

public class UserService {

	private static final UserService userService = new UserService();
	private final GenericService genericService = GenericService.genericService();

	private UserService() {
	}

	public static UserService userService() {
		return userService == null ? new UserService() : userService;
	}

	@SuppressWarnings("unchecked")
	public void appendUsername(JSONObject transformObject) {
		JSONArray jsonArray = genericService.readDataFromFile(Source.USERS);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.get("organization_id").equals(transformObject.get("_id"))) {
					transformObject.put("username", jsonObject.get("name"));
					return;
				}
			}
		} catch (NullPointerException ex) {
			transformObject.put("username", "no user found");
		}
	}

	@SuppressWarnings("unchecked")
	public void appendAssigneeNameAndSubmitterName(JSONObject transformObject) {
		JSONArray jsonArray = genericService.readDataFromFile(Source.USERS);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.get("_id").equals(transformObject.get("submitter_id"))) {
					transformObject.put("submitter_name", jsonObject.get("name"));
				}
				if (jsonObject.get("_id").equals(transformObject.get("assignee_id"))) {
					transformObject.put("assignee_name", jsonObject.get("name"));
				}
			}
		} catch (NullPointerException ex) {
			transformObject.putIfAbsent("submitter_name", "no submitter found");
			transformObject.putIfAbsent("assignee_name", "no assignee found");
		}
	}

}
