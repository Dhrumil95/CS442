
/*
 * crimeMap: This class instantiates a Google Map window with 
 *   crime information plotted onto it. Data from from the City of Chicago
 *   database (https://data.cityofchicago.org).
 * 
 * --> Be mindful of absolute path used within this class
 * 
 * Partial Code comes directly from TeamDev, creators of JxBrowser, 
 *   for its functionality:
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 */

package test;

import javax.swing.JFrame;

public class CrimeMap {
	public CrimeMap(JFrame mainMenu){
		new ProjectBrowser("City of Chicago Official Site","https://data.cityofchicago.org",mainMenu);
	}
}
