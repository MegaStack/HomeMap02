package com.gmail.oastro36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Translater {
	private File fileIn;
	private File fileOut;
	private HashMap<String, String> hm;

	public Translater(File fileIn, File fileOut, HashMap<String, String> hm) {
		super();
		this.fileIn = fileIn;
		this.fileOut = fileOut;
		this.hm = hm;
		
	}

	public Translater() {
		super();
	}

	public void loadEnglText() {
		StringBuilder sb = new StringBuilder();
		String text = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileIn))) {
			for (; (text = br.readLine()) != null;) {
				sb.append(text);				
				translateEnglUkr(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void translateEnglUkr(String text) {
		
		StringBuilder sb = new StringBuilder();
		String[] words = text.split("[ ]");
		for (String word : words) {
			sb.append(hm.get(word));
			sb.append(" ");
		}
		writeUkrToFile(sb.toString());

	}

	private void writeUkrToFile(String text) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut, true))) {
			bw.write(text);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
