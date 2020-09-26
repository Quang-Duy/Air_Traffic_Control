package ATC;

/**
 * Control the Sorted List button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class SortedListCommand extends Command {

	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public SortedListCommand(Model model) { super(model); }
	
	/**
	 * Print the sorted list by calling the sortedList method from Air Traffic Control class
	 */
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		atc.sortedList();
	}
}
