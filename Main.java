package com.gmail.oastro36;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		MyMap myMap = new MyMap();
		Scanner sc = new Scanner(System.in);
		System.out.println("Input English word:");
		String angl = sc.nextLine();
		System.out.println("Input Ukrainian word:");
		String ukr = sc.nextLine();
		
		InteractiveFillingVocabulary ifv = new InteractiveFillingVocabulary(angl, ukr, myMap);
		writeMap(myMap);
		
		MyMap mapLoad = null;
		mapLoad = readMap();
		System.out.println(mapLoad.getHm());
	}
	
	public static void writeMap(MyMap map) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myMap.txt"))) {
			oos.writeObject(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MyMap readMap() {
		MyMap mapLoad = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myMap.txt"))) {
			mapLoad = (MyMap) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mapLoad;
	}

}
