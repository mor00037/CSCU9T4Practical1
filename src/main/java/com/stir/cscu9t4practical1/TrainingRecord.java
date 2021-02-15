// An implementation of a Training Record as an ArrayList

import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
      if(!tr.contains(e)) // to ensure it takes only unique records
        tr.add(e);    
   } // addClass
   
  public void removeEntry(String nm,int d, int m, int y){
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getName().equals(nm) &&current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             iter.remove();
            }    
   } // addClass
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
          
       }
       return result;
   } // lookupEntry

   // let's use arraylist of string type to store all the values for the given day,
   // and hence convert it back to string for the output
  public String lookupEntryForGivenDay (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       ArrayList<String> result = new ArrayList<String>();
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result.add(current.getEntry());
            }
       return result.toString();
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   public boolean recordExists() {
	   if (getNumberOfEntries()>0) {
		   return true;
	   }else {
		   return false;
	   }
   }
   public List<Entry> getList() {
	   return tr;
   }
   
   
} // TrainingRecord