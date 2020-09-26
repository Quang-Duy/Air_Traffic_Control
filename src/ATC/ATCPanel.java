package ATC;

/**
 * Create the buttons for the GUI
 * @author Quang-Duy Tran
 *
 */

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.*;

public class ATCPanel extends AppPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton insert, sort, initialList, maxHeapList, sortedList, firstRankedAC, emergencyLanding;
	
	/**
	 * Default constructor
	 * Create all buttons and set the layout of them on the GUI
	 * @param factory the interface AppFactory (from mvc package)
	 */
	public ATCPanel(AppFactory factory) {
		super(factory);
		
		this.insert = new JButton("Insert");
		this.insert.addActionListener(this);
		
		this.sort = new JButton("Sort");
		this.sort.addActionListener(this);
		
		this.initialList = new JButton("Initial List");
		this.initialList.addActionListener(this);
		
		this.maxHeapList = new JButton("Max Heap List");
		this.maxHeapList.addActionListener(this);
		
		this.sortedList = new JButton("Sorted List");
		this.sortedList.addActionListener(this);
		
		this.firstRankedAC = new JButton("First Ranked AC");
		this.firstRankedAC.addActionListener(this);
		
		this.emergencyLanding = new JButton("Emergency Landing");
		this.emergencyLanding.addActionListener(this);
		
		JPanel mathPanel = new JPanel();
		mathPanel.setLayout(new GridLayout(4, 2));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.add(insert);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(initialList);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(sort);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(maxHeapList);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(firstRankedAC);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(sortedList);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(emergencyLanding);
		mathPanel.add(panel);
		
		buttonPanel.add(mathPanel, "North");
		this.add(buttonPanel, "Center");
	}
	
	public static void main(String[] args) {
		AppFactory factory = new ATCFactory();
		AppPanel panel = new ATCPanel(factory);
		panel.display();
	}
}
