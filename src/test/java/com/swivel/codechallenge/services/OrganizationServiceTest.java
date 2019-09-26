package com.swivel.codechallenge.services;

import org.json.simple.JSONObject;
import org.junit.Test;

public class OrganizationServiceTest {

	private OrganizationService organizationService;

	public OrganizationServiceTest() {
		this.organizationService = OrganizationService.origanizationService();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void appendOrganizationNameTest() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("organization_id", 101);
		
		organizationService.appendOrganizationName(jsonObject);
	}
}
