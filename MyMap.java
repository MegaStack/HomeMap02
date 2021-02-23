package com.gmail.oastro36;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class MyMap implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<String, String> hm = new HashMap<>();

	public MyMap() {
		super();
		fillingMapFromTxt();
	}

	public HashMap<String, String> getHm() {
		return hm;
	}

	private void fillingMapFromTxt() {
		File fileVocabulary = new File("Vocabulary(angl-ukr).txt");
		try (BufferedReader br = new BufferedReader(new FileReader(fileVocabulary))) {
			String readRow = "";
			for (; (readRow = br.readLine()) != null;) {
				String[] wordsPair = readRow.split("[\t]");
				hm.put(wordsPair[0], wordsPair[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
