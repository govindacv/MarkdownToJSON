package com.MarkdownToJSON.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.MarkdownToJSON.Converter.MarkdownToJSON;

class Main {

	public static void main(String[] args) {
		// String variables to store the file paths of .md file
		String markdownPath = "D:\\Java project\\Vtiger\\MarkdownToJSON\\src\\markdownfile.md";
		// String variables to store the file paths of .json file
		String jsonPath = "D:\\Java project\\Vtiger\\MarkdownToJSON\\src\\JSON.json";

		// Creating object of MarkdownToJSON class present in
		// com.MarkdownToJSON.Converter package
		MarkdownToJSON json = new MarkdownToJSON();

		// As the .md and .json files are not native it should be surrounded with try
		// and catch blok
		try {
			// Method to read the content of .md file and store in string variable
			String markdownContent = json.readMarkdownFile(markdownPath);

			// Method to convert the .md to .json(in form of string)
			String jsonContent = json.convertMarkdownToJson(markdownContent);

			// Method to write the converted json(String) to jsonFile(.json)
			json.writeJsonFile(jsonContent, jsonPath);
			System.out.println("Markdown to JSON converted successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

}
