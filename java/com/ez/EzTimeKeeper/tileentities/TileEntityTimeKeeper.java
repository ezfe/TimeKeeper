package com.ez.EzTimeKeeper.tileentities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.tileentity.TileEntity;

import com.ez.EzTimeKeeper.blocks.BlockTimeKeeper;

public class TileEntityTimeKeeper extends TileEntity {
	
	private int time = 0;
	private String weatherCondition = "";

	public void updateEntity() {
		time++;
		if (time == 20) {
			URL url = null;
			try {
				url = new URL("http://ezekielelin.com/minecraft/mod/timekeeper/loc.php?zip=03755");
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			String zipCodeData = null;
			try {
				BufferedReader reader = new BufferedReader (new InputStreamReader(url.openStream()));
				BufferedWriter writer = new BufferedWriter (new FileWriter("data.html"));
				String line;
				while ((line = reader.readLine()) != null) {
					zipCodeData += line;
					writer.write(line);
					writer.newLine();
				}
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (zipCodeData == "rain") {
				//worldObj.rainingStrength = 1.0F;
				System.out.println("----");
				System.out.println(worldObj.isThundering());
				System.out.println("----");
			}
		}

		//TODO URL http://graphical.weather.gov/xml/SOAP_server/ndfdXMLclient.php?whichClient=LatLonListZipCode&listZipCodeList=ZIPCODEHERE
		BlockTimeKeeper.timeKeep(worldObj);
	}
}
