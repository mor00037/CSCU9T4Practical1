// GUI and main program for the Training Record


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener,KeyListener {
	
	private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terr = new JTextField(2);
    private JTextField tmpo = new JTextField(2);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labterr = new JLabel("Terrain :");
    private JLabel labtmpo = new JLabel("Tempo :");
    private JButton addR = new JButton("Add");
    private JButton remove = new JButton("Remove");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find All by Date"); // Part 1, adding new button
    private TrainingRecord myAthletes = new TrainingRecord();
    private JTextArea outputArea = new JTextArea(10, 50);
    String choices[]= {"Run / Sprint","Cycle","Swim"};
    final JComboBox<String> cb = new JComboBox<String>(choices);
    String Runs[] = {"4 * 40m Sprints", "4 * 300m sprints","1 * 5km run"};
    String Pool[] = {"Indoor" , "Outdoor"};
    final JComboBox<String> cbRun = new JComboBox<String>(Runs);
	final JComboBox<String> cbPool = new JComboBox<String>(Pool);
    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        add(labn,gbc);
        gbc.gridx++;
        gbc.gridwidth=3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(name,gbc);
        name.setEditable(false);
        name.addKeyListener(this);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labd,gbc);
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(day,gbc);
        //day.setEditable(true);
        gbc.gridx++;
        add(labm,gbc);
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(month,gbc);
        //month.setEditable(true);
        gbc.gridx++;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(laby,gbc);
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(year,gbc);
        //year.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labh,gbc);
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(hours,gbc);
        //hours.setEditable(true);
        gbc.gridx++;
        add(labmm,gbc);
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(mins,gbc);
        //mins.setEditable(true);
        gbc.gridx++;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(labs,gbc);
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(secs,gbc);
        //secs.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy++;
        add(labdist,gbc);
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(dist,gbc);
        //dist.setEditable(true);
        gbc.gridx++;
        //cb.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(cb,gbc);
        cb.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy++;
        add(cbRun,gbc);
    	cbRun.setEnabled(true);
    	gbc.gridx++;
    	add(labterr,gbc);
    	labterr.setEnabled(false);
    	gbc.gridx++;
    	gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    	add(terr,gbc);
    	terr.setEnabled(false);
    	gbc.gridx++;
    	gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    	add(labtmpo,gbc);
    	labtmpo.setEnabled(false);
    	gbc.gridx++;
    	gbc.gridwidth=2;
    	//gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    	add(tmpo,gbc);
    	tmpo.setEnabled(false);
    	gbc.gridx++;
    	gbc.gridx++;
        add(cbPool,gbc);
		cbPool.setEnabled(false);
		gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		add(addR,gbc);
        addR.addActionListener(this);
        gbc.gridx++;
        gbc.gridwidth=1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(remove,gbc);
        //remove.setAlignmentX(Component.CENTER_ALIGNMENT);
        remove.addActionListener(this);
        remove.setEnabled(false);
        gbc.gridx++;
        add(lookUpByDate,gbc);
        lookUpByDate.addActionListener(this);
        lookUpByDate.setEnabled(false);
        gbc.gridx++;
        add(FindAllByDate,gbc);
        FindAllByDate.addActionListener(this);
        FindAllByDate.setEnabled(false);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridx++;
        gbc.gridwidth=6;
        gbc.gridheight=6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(outputArea,gbc);
        outputArea.setEditable(false);
        setSize(1220, 1080);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        blankDisplay();
        
        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        
        if (event.getSource() == addR) {
        	if ( name.getText().isEmpty() | day.getText().isEmpty() | month.getText().isEmpty() | year.getText().isEmpty() | hours.getText().isEmpty() | mins.getText().isEmpty() | secs.getText().isEmpty() | dist.getText().isEmpty()) {
        		message = " Please fill in all the fields ";
        	}
        	else if ( isInt(day,day.getText()) == false | isInt(month,month.getText()) == false | isInt(year,year.getText()) == false | isInt(hours,hours.getText()) == false | isInt(mins,mins.getText()) == false | isInt(secs,secs.getText()) == false | isInt(dist,dist.getText()) == false) {
        		message = " Please enter correct inputs ";
        	}
        	else if(Integer.parseInt(day.getText())<1 | Integer.parseInt(day.getText())>31 | Integer.parseInt(month.getText())>12 | Integer.parseInt(month.getText())<1 | Integer.parseInt(hours.getText())<0  | Integer.parseInt(hours.getText())>24 | Integer.parseInt(mins.getText())<0  | Integer.parseInt(mins.getText())>60  | Integer.parseInt(secs.getText())<0 | Integer.parseInt(secs.getText())>60 ) {
        		message = " Please enter valid date and time values ";
        	}
        	else if(( Integer.parseInt(month.getText()) == 2 & Integer.parseInt(day.getText()) <= 28 ) | ( Integer.parseInt(month.getText()) == 4 & Integer.parseInt(day.getText()) <= 30 )| ( Integer.parseInt(month.getText()) == 6 & Integer.parseInt(day.getText()) <= 30 ) | ( Integer.parseInt(month.getText()) == 9 & Integer.parseInt(day.getText()) <= 30 ) | ( Integer.parseInt(month.getText()) == 11 & Integer.parseInt(day.getText()) <= 30 )) 
        	{
        		message = addEntry("generic");
				lookUpByDate.setEnabled(true);
                FindAllByDate.setEnabled(true);
                remove.setEnabled(true);
        	}else if(Integer.parseInt(month.getText())==2 & Integer.parseInt(day.getText()) == 30 ) {
        		message = " Please enter a valid day of the month ";
        	}
        	else if (Integer.parseInt(month.getText())==2 & Integer.parseInt(day.getText()) == 29) {
        		
        		if((Integer.parseInt(year.getText())%4 == 0 & Integer.parseInt(year.getText())%100 != 0) | Integer.parseInt(year.getText())%400 == 0) {
        			message = addEntry("leaper");
					lookUpByDate.setEnabled(true);
	                FindAllByDate.setEnabled(true);
	                remove.setEnabled(true);
	                
        		}else { 
        		
            		message = " Please enter a valid date ";

        		}
        	}
        	else {
                message = addEntry("generic");
                lookUpByDate.setEnabled(true);
                FindAllByDate.setEnabled(true);
                remove.setEnabled(true);
        	}
        }
        if (event.getSource() == lookUpByDate) {
        	if ( day.getText().isEmpty() | month.getText().isEmpty() | year.getText().isEmpty()) {
        		message = " Please fill in the full date ";
        	}else {
        		message = lookupEntry();
        		  }
        	}
        if (event.getSource() == FindAllByDate) {
            //message = "Not Implemented Yet"; // Here concludes the first part
        	if ( day.getText().isEmpty() | month.getText().isEmpty() | year.getText().isEmpty()) {
        		message = " Please fill in the full date ";
        	}else {
            	message =FindAllByDate(); // calling the function
        		  }
        	
        }
        if (event.getSource() == remove) {
        	if (name.getText().isEmpty() | day.getText().isEmpty() | month.getText().isEmpty() | year.getText().isEmpty()) {
        		message = "Please enter name and date to delete record";
        		remove.setEnabled(true);
            }else {
            	message = removeE();
            	if (recordExists() == false) {
                	remove.setEnabled(false);
            	}else {
                	remove.setEnabled(true);
            	}
            }
        	
        }
        
        if (event.getSource() == cb) {
        	
        	if(cb.getSelectedItem().toString() == "Run / Sprint") {
        		cbRun.setEnabled(true);
        		terr.setEnabled(false);
        		tmpo.setEnabled(false);
        		labterr.setEnabled(false);
        		labtmpo.setEnabled(false);
        		cbPool.setEnabled(false);
        	}else if(cb.getSelectedItem().toString() == "Cycle") {
        		terr.setEnabled(true);
        		tmpo.setEnabled(true);
        		labterr.setEnabled(true);
        		labtmpo.setEnabled(true);
        		cbPool.setEnabled(false);
        		cbRun.setEnabled(false);
        	}else {
        		cbPool.setEnabled(true);
        		terr.setEnabled(false);
        		tmpo.setEnabled(false);
        		labterr.setEnabled(false);
        		labtmpo.setEnabled(false);
        		cbRun.setEnabled(false);
        	}}
        
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    
    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String c = cb.getSelectedItem().toString();
        String cbRunT = cbRun.getSelectedItem().toString();
        String terrainT = terr.getText();
        String tempoT = tmpo.getText();
        String sbPoolT = cbPool.getSelectedItem().toString();
        Entry e = new Entry(n, d, m, y, h, mm, s, km, c,cbRunT, terrainT , tempoT, sbPoolT);
        myAthletes.addEntry(e);
        return message;
    }
    public String removeE() {
        String message = "Record Deleted\n";
        
        String nm = name.getText(); // name
        int m = Integer.parseInt(month.getText()); // month 
        int d = Integer.parseInt(day.getText()); // date
        int y = Integer.parseInt(year.getText()); // year
        myAthletes.removeEntry(nm,d, m, y);
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    // implementing the new findallbydate function
    public String FindAllByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntryForGivenDay(d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        terr.setText("");
        tmpo.setText("");
    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }
    
    private boolean isInt(JTextField field, String input) {
    	try {
    		Integer.parseInt(field.getText());
    		return true;
    	} catch (NumberFormatException e) {
    		System.out.println("Please input a number");
    		return false;
    	}
    }
    private TrainingRecord TRGUI;
    public boolean recordExists() {
    		TRGUI = new TrainingRecord();
    		java.util.List<Entry> tr = TRGUI.getList();
    		int recordExist = tr.size();
    		if (recordExist > 0) {
    			return true;
    		}else {
    			return false;
    		}
    }

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent event) {
			char c = event.getKeyChar();
            if (Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)) {
            	name.setEditable(true);
            }else {
            	name.setEditable(false);
            }			
		} 
}// TrainingRecordGUI

