package com.alestrio.isotope;

public class Gui {

	public static void main(String[] args) {
		DB db = new DB("jdbc:postgresql://localhost:5432/","postgres","postgres");
		if(!db.getDriverState());
			System.out.println("Driver non valide");
			
		

	}

}
