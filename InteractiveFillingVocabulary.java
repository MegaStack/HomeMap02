package com.gmail.oastro36;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InteractiveFillingVocabulary {
	private String angl;
	private String ukr;
	private MyMap mm;

	public InteractiveFillingVocabulary(String angl, String ukr, MyMap mm) {
		super();
		this.angl = angl;
		this.ukr = ukr;
		this.mm = mm;

		addNewWordToMap();
	}

	public InteractiveFillingVocabulary() {
		super();
	}

	private void addNewWordToMap() {
		if (!mm.getHm().containsKey(angl)) {
			(mm.getHm()).put(angl, ukr);
			addNewWordToVocabulary();
		} else {
			System.out.println("word " + angl + " already exists");
		}

	}

	private void addNewWordToVocabulary() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Vocabulary(angl-ukr).txt", true))) {
			bw.write(System.lineSeparator());
			bw.write(angl);
			bw.write("\t");
			bw.write(ukr);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
