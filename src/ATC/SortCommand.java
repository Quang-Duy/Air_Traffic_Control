package ATC;

/**
 * Control the Sort button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class SortCommand extends Command {
	
	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public SortCommand(Model model) { super(model); }
	
	/**
	 * Sort the list by calling the sort method from Air Traffic Control class
	 */
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		atc.sort();
	}
}
