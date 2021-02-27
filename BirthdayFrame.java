import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BirthdayFrame extends JFrame implements ActionListener {
	private JSpinner birthYear;
	private JSpinner birthMonth;
	private JSpinner birthDay;
	private JLabel userAge;
	private JLabel prompt;
	private JLabel userYear;
	private JLabel userMonth;
	private JLabel userDay;
	private JLabel userResult;
	private JButton calculate;
	private int years = 0;
	private int months = 0;
	private int currentYear = 0;
	private int currentMonth = 0;
	private int currentDay = 0;
	private int yearInt = 0;
	private int monthInt = 0;
	private int dayInt = 0;
	
	
	BirthdayFrame() {
		
		//applies title to the frame
		setTitle("Current Age Calculator");
		
		//dimensions and sets values for all labels
		prompt = new JLabel("Enter your birthday");
		userDay = new JLabel("Day:");
		userYear = new JLabel("Year:");
		userMonth = new JLabel("Month:");
		userResult = new JLabel("Your current age:");
		
		//dimesions and sets constraints for all spinners
		SpinnerNumberModel yearSpinner = new SpinnerNumberModel(2000, 1900, 2020, 1);
		birthYear = new JSpinner(yearSpinner);
		SpinnerNumberModel monthSpinner = new SpinnerNumberModel(1, 1, 12, 1);
		birthMonth = new JSpinner(monthSpinner);
		SpinnerNumberModel daySpinner = new SpinnerNumberModel(1, 1, 31, 1);
		birthDay = new JSpinner(daySpinner);
		
		//labels button and sets its function
		calculate = new JButton("Calculate");
		calculate.addActionListener(this);
		
		//dimensions output variable
		userAge = new JLabel("");
		
		//applies the gridbag layout
		setLayout(new GridBagLayout());
		
		//positions the prompt label
		GridBagConstraints layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 10);
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 0;
	    add(prompt, layoutConst);
	    
	    //positions the day label
		layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 1);
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 1;
	    add(userDay, layoutConst);
	    
	    //positions the day spinner
		layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 1, 10, 10);
	    layoutConst.gridx = 1;
	    layoutConst.gridy = 1;
	    add(birthDay, layoutConst);
	    
	    //positions the month label
		layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 1);
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 2;
	    add(userMonth, layoutConst);
		
	    //positions the month spinner
	    layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 1, 10, 10);
	    layoutConst.gridx = 1;
	    layoutConst.gridy = 2;
	    add(birthMonth, layoutConst);
	    
	    //positions the year label
		layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 1);
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 3;
	    add(userYear, layoutConst);
	    
	    //positions the year spinner
	    layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 1, 10, 10);
	    layoutConst.gridx = 1;
	    layoutConst.gridy = 3;
	    add(birthYear, layoutConst);
	    
	    //positions the calculate button
	    layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 10);
	    layoutConst.gridx = 1;
	    layoutConst.gridy = 4;
	    add(calculate, layoutConst);
	    
	    //positions the result label
	    layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 10, 10, 1);
	    layoutConst.gridx = 0;
	    layoutConst.gridy = 5;
	    add(userResult, layoutConst);
	    
	    //positions the output
	    layoutConst = new GridBagConstraints();
	    layoutConst.insets = new Insets(10, 1, 10, 10);
	    layoutConst.gridx = 1;
	    layoutConst.gridy = 5;
	    add(userAge, layoutConst);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//imports the current date
		LocalDate currentDate = LocalDate.now();
		
		//gets values for all current states
		currentDay = currentDate.getDayOfMonth();
		currentMonth = currentDate.getMonthValue();
		currentYear = currentDate.getYear();
		monthInt = (Integer) birthMonth.getValue();
		yearInt = (Integer) birthYear.getValue();
		dayInt = (Integer) birthDay.getValue();
		
		//determines how to calculate age based on current date
		if(monthInt < currentMonth || (monthInt == currentMonth && currentDay >= dayInt)) {
			years  = currentYear - yearInt;
			months = currentMonth - monthInt;
		}
		
		else {
			years = currentYear - yearInt - 1;
			months = (currentMonth - monthInt) + 12;
		}
		
		//sets the new display for current age
		userAge.setText("" + years + " years and " + months + " months old");
	}
	
	public static void main(String[] args) {
		
		//initializes the frame
		BirthdayFrame frame = new BirthdayFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
