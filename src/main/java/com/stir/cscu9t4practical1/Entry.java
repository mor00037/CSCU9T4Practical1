// This class holds information about a single training session


import java.util.Arrays;
import java.util.Calendar;
public class Entry {
  private String name, choice, comboBoxRun, terrainTxt, tempoTxt, Pool;
  private Calendar dateAndTime;
  private float distance;
  
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist, String c,String cbRunT,String terrainT, String tempoT, String sbPoolT) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
    choice = c;
    comboBoxRun = cbRunT;
    terrainTxt = terrainT;
    tempoTxt = tempoT;
    Pool = sbPoolT;
  } //constructor
  
  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  public float getDistance () {
    return distance;
  } //getYear
  
  public String getChoice() {
	  return choice;
  } //getChoice
  
  public String getRunDetails() {
		  return comboBoxRun;
  }
  
  public String getCycTerrDetails() {
	  return terrainTxt;
  }
  public String getCycTmpoDetails() {
	  return tempoTxt;
  }
  public String getSwimDetails() {
	  return Pool;
  }
   

  public String getEntry () {
	  if(getChoice() == "Run / Sprint") {
		  String result = getName()+ " ran "+ getRunDetails() + " for a total distance of " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
	  }else if (getChoice() == "Swim") {
		  String result = getName()+ " swam "+ getSwimDetails() + " a distance of " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
	  }else {
		  String result = getName()+ " cycled on "+ getCycTerrDetails() + " having tempo: " +getCycTmpoDetails() + " for a distance of " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
	  }
   
  } //getEntry
   
} // Entry