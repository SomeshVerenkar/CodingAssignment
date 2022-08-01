package com.codingassignment.validationtest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

public class TestUsingJSON 
{

	public static void main(String[] args) throws IOException, ParseException 
	{
		JSONParser jsonParser = new JSONParser();
		// JSONObject jsonObject = null;

		// Read JSON file
		FileReader reader = new FileReader(".//src/test/resources/testdata.properties");

		// Creating java object
		Object obj = jsonParser.parse(reader);

		// Converting java object into JSON object
		JSONObject royalChallengersBangaloreJsonObj = (JSONObject) obj;

		// Addition
		String team = (String) royalChallengersBangaloreJsonObj.get("team");
		String location = (String) royalChallengersBangaloreJsonObj.get("location");

		System.out.println("team : " + team);
		System.out.println("location : " + location);

//			//Array to store JSON data
		JSONArray rcbTeamArray = (JSONArray) royalChallengersBangaloreJsonObj.get("player");

//			String arr[] = new String[rcbTeamArray.size()];

		System.out.println("RCB Team has only 4 foreign players");

		int j = 0;
		int k = 0;
		for (int i = 0; i < rcbTeamArray.size(); i++) 
		{
			JSONObject player = (JSONObject) rcbTeamArray.get(i);

			String name = (String) player.get("name");
			String country = (String) player.get("country");
			String role = (String) player.get("role");
			String priceInCrores = (String) player.get("rice-in-crores");

			if (!country.contentEquals("India")) 
			{
				System.out.println("Player name is " + name);

				System.out.println("Country name is " + country);
				j++;
			}

			if (role.contentEquals("Wicket-keeper")) 
			{
				System.out.println("Role name is " + role);
				k++;
			}
		}

			if(j == 4 && k >= 1) 
			{
				System.out.println("Team has " +j+ " Foreign players & " +k+ " wicket keeper");

				System.out.println("Condition is satified");
			}
	}
}
