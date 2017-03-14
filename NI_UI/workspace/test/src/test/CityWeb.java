/*
 * cityWeb: This class instantiates the City of Chicago data 
 *   website (https://data.cityofchicago.org) for the user.
 * 
 * Partial Code comes directly from TeamDev, creators of JxBrowser, 
 *   for its functionality:
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 * 
 */

package test;

import javax.swing.JFrame;

public class CityWeb {
	public CityWeb(JFrame mainMenu){
		new ProjectBrowser("City of Chicago Official Site","https://data.cityofchicago.org", mainMenu);
	}
}