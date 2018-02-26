package com.alestrio.isotope;

public class Gui {

	public static void main(String[] args) {
		DB db = new DB("jdbc:postgresql://localhost:5432/","postgres","postgres");
		System.out.println(db.getDriverState());
		System.out.println(db.connect());
		

	}

}
