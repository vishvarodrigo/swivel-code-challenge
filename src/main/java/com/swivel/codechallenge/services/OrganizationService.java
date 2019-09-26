package com.swivel.codechallenge.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.swivel.codechallenge.enums.Source;

public class OrganizationService {
	private static final OrganizationService organizationService = new OrganizationService();
	private final GenericService genericService = GenericService.genericService();

	// Restrict new object creation by making constructor private
	private OrganizationService() {
	}

	// Provide singleton object Ex: @autowired
	public static OrganizationService origanizationService() {
		return organizationService == null ? new OrganizationService() : organizationService;
	}

	@SuppressWarnings("unchecked")
	public void appendOrganizationName(JSONObject transformObject) {
		JSONArray jsonArray = genericService.readDataFromFile(Source.ORGANIZATIONS);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.get("_id").equals(transformObject.get("organization_id"))) {
					transformObject.put("organization_name", jsonObject.get("name"));
					return;
				}
			}
		} catch (NullPointerException ex) {
			transformObject.putIfAbsent("organization_name", "no organization found");
		}
	}

}
