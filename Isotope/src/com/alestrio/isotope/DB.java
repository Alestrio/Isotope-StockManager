/*
 * Copyright (c) 2018.
 * Code written by Alexis LEBEL (aka Alestrio)
 *
 */

package com.alestrio.isotope;

public class DB extends AbsDB{
	public boolean connectIt(){
		if(!this.isAlreadyConnected && this.getDriverState()){
			this.connect();
			this.isAlreadyConnected = true;
			return true;
		}
		else
			return false;
	}

	public void dbQueryU(String arg){
	    this.connectIt();
		this.dbQuery(arg);
		this.disconnectIt();
    }

    public boolean disconnectIt(){
		if(this.isAlreadyConnected){
			this.disconnect();
			this.isAlreadyConnected = false;
			return true;
		}
		else
			return false;
	}
}
