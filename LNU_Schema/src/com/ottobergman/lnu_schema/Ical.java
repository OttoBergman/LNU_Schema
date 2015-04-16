package com.ottobergman.lnu_schema;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Environment;
import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;

public class Ical {
	
private static List<ICalendar> icals = new ArrayList<ICalendar>();
	

	public void getIcal(String fileLoc) {
		File sdcard = Environment.getExternalStorageDirectory();
		//Get the text file
		File getIcal = new File(sdcard,fileLoc);
		try {
			icals = Biweekly.parse(getIcal).all();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	
	public String getStartDate (int eventNr){
		
		VEvent event = icals.get(0).getEvents().get(eventNr);
		Date startDate = event.getDateStart().getValue();
		SimpleDateFormat sD = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String startDate2 = sD.format(startDate);
		return startDate2;
		
	}
	
	public String getEndDate (int eventNr){
		
		VEvent event = icals.get(0).getEvents().get(eventNr);
		Date endDate = event.getDateEnd().getValue();
		SimpleDateFormat eD = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String endDate2 = eD.format(endDate);
		return endDate2;
		
	}
	
	public String getLocation (int eventNr){
		
		VEvent event = icals.get(0).getEvents().get(eventNr);
		String location = event.getLocation().getValue();
		
		return location;
		
	}
	
	public String getSummary (int eventNr){
		
		VEvent event = icals.get(0).getEvents().get(eventNr);
		String summary = event.getSummary().getValue();
		
		return summary;
		
	}
	
	public String getDescription (int eventNr){
		
		VEvent event = icals.get(0).getEvents().get(eventNr);
		String description = event.getDescription().getValue();
		
		return description;
		
	}
	
}


