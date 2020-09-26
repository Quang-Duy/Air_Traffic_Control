package ATC;

/**
 * Control the Insert button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class InsertCommand extends Command {
	
	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public InsertCommand(Model model) { super(model); }
	
	/**
	 * Ask the user a new flight number
	 */
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		
		String response = Utilities.ask("New Flight Number:");
		atc.insert(response);
	}
}
