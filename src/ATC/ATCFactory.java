package ATC;

/**
 * Create and set up the menu bar for the GUI
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class ATCFactory implements AppFactory {

	/**
	 * Create a new Air Traffic Control model
	 */
	public Model makeModel() { return new AirTrafficControl(); }

	/**
	 * Create new edit commands 
	 */
	public String[] getEditCommands() { 
		return new String[] {"Insert", "Sort", "Initial List", "Max Heap List", "Sorted List", "First Ranked AC", "Emergency Landing"}; 
	}

	/**
	 * Call the correct command based on the user's selection
	 */
	public Command makeEditCommand(Model model, String type) 
	{
		if (type == "Insert")
			return new InsertCommand(model);
		else if(type == "Sort")
			return new SortCommand(model);
		else if(type == "Initial List")
			return new InitialListCommand(model);
		else if(type == "Max Heap List")
			return new MaxHeapListCommand(model);
		else if(type == "Sorted List")
			return new SortedListCommand(model);
		else if(type == "First Ranked AC")
			return new ViewFirstRankedACCommand(model);
		else if(type == "Emergency Landing")
			return new EmergencyLandingCommand(model);
		
		return null;
	}

	/**
	 * Show the title of the GUI
	 */
	public String getTitle() { return "Air Traffic Control"; }

	/**
	 * Show the instruction, how to use the GUI and what the buttons do
	 */
	public String[] getHelp() {
		return new String[] {"Insert: Add a new flight number", "Sort: Sort the approach code", 
				"Initial List: Show the initial list of flight number", 
				"Max Heap List: Show the Max-Heap property",
				"Sorted List: Show the sorted list of flight number (descendent order)",
				"First Ranked AC: Show and Delete the airplane that has the largest approach code",
				"Emergency Landing: Choose any airplane to land first (ID: 1, 2, 3, ...)"};
	}

	/**
	 * Show the author and copyright
	 */
	public String about() {
		return "Air Traffic Control Simulator version 1.0. Copyright 2020 by Quang-Duy Tran";
	}

}