package com.alestrio.isotope.observable;

import java.util.Observer;

public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver();
	public void notifyObserver(String str);
}
