package com.MarkdownToJSON.Converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarkdownToJSON {
	// readMarkdownFile accepts the file path of .md file and returns the contents
	// presents in that file as
	// String
	public String readMarkdownFile(String filePath) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		}
		return content.toString();
	}

	// This method accepts the string form of .md file and converts into .json
	// format
	public String convertMarkdownToJson(String markdownContent) {
		// First it splits and stores the content in array of string
		String[] lines = markdownContent.split("\n");
		List<String> jsonLines = new ArrayList<>();

		// iterating each contents present in array of string using for each loop
		for (String line : lines) {
			if (line.startsWith("#")) {
				String heading = line.replace("#", "").trim();
				jsonLines.add("{\"type\":\"heading\",\"content\":\"" + heading + "\"}");
			} else if (line.startsWith("*")) {
				String listItem = line.replace("*", "").trim();
				jsonLines.add("{\"type\":\"list-item\",\"content\":\"" + listItem + "\"}");
			} else {
				jsonLines.add("{\"type\":\"paragraph\",\"content\":\"" + line + "\"}");
			}
		}
		return "[" + String.join(",", jsonLines) + "]";
	}

	// This method accepts the json formatted string and file path of .json file and
	// performs write opration
	public void writeJsonFile(String jsonContent, String filePath) throws IOException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(jsonContent);
		}
	}

}
