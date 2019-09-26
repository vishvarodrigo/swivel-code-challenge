package com.swivel.codechallenge.services;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.swivel.codechallenge.enums.Source;
import com.swivel.codechallenge.utils.Util;

public class GenericService {

	private static final GenericService genericService = new GenericService();
	private final Scanner scanner = new Scanner(System.in);

	// Restrict new object creation by making constructor private
	private GenericService() {
	}

	// Provide singleton object Ex: @autowired
	public static GenericService genericService() {
		return genericService == null ? new GenericService() : genericService;
	}

	public String getInputString() {
		String input = null;
		try {
			input = scanner.nextLine();
		} catch (Exception ex) {
			System.out.println(Util.INVALID_INPUT_TEXT.concat(ex.getMessage()));
		}
		return input;
	}

	public int getInputInteger() {
		int input = 0;
		try {
			input = scanner.nextInt();
		} catch (Exception ex) {
			System.out.println(Util.INVALID_INPUT_TEXT.concat(ex.getMessage()));
		}
		return input;
	}

	public void displayTitle(String title) {
		System.out.println(title);
	}

	public void displayEmptyLine() {
		System.out.println();
	}

	public void displayLine() {
		System.out.println("---------------------------------------------------------");
	}

	public JSONObject initiate(Source source) {
		scanner.nextLine(); // throw away the \n not consumed by nextInt()

		System.out.println(Util.SEARCH_TERM_TEXT);
		String searchTerm = getInputString();

		System.out.println(Util.SEARCH_VALUE_TEXT);
		String searchValue = getInputString();

		displayEmptyLine();

		JSONObject jsonObject = searchObjectByKeyAndValue(searchTerm, searchValue, source);
		if (jsonObject == null) {
			System.out.println(Util.NO_RESULT_FOUND_TEXT);
			return new JSONObject();
		}
		return jsonObject;
	}

	// Read data from the file based on the source
	public JSONArray readDataFromFile(Source source) {
		JSONParser jsonParser = new JSONParser();
		try (FileReader fileReader = new FileReader("./".concat(source.getFileName()))) {
			JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
			return jsonArray;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private JSONObject searchObjectByKeyAndValue(String key, String value, Source source) {
		JSONArray jsonArray = readDataFromFile(source);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				if (jsonObject.get(key).equals((value.matches("\\d+") ? Long.parseLong(value) : value))) {
					return jsonObject;
				}
			}
		} catch (Exception ex) {
			System.out.println(Util.INVALID_INPUT_TEXT);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void displaySearchKeys(Source source) {
		JSONArray jsonArray = readDataFromFile(source);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		System.out.println("Search ".concat(source.name().concat(" with : ")));
		jsonObject.keySet().forEach(key -> {
			System.out.println(key);
		});
		displayEmptyLine();
		displayLine();
	}

	@SuppressWarnings("unchecked")
	public void displayJsonObject(JSONObject jsonObject) {
		jsonObject.forEach((k, v) -> {
			System.out.printf("%-20s %-20s%n", k, v);
		});
	}
}
