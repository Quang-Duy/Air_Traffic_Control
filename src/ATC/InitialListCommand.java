package ATC;

/**
 * Control the Initial List button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class InitialListCommand extends Command {

	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public InitialListCommand(Model model) { super(model); }
	
	/**
	 * Call the initialList method from Air Traffic Control class
	 */
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		atc.initialList();
	}
}
