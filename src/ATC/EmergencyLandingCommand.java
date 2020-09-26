package ATC;

/**
 * Control the Emergency Landing button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class EmergencyLandingCommand extends Command {

	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public EmergencyLandingCommand(Model model) { super(model); }
	
	/**
	 * Ask user the index of the airplane that has emergency
	 */
	@Override
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		
		String response = Utilities.ask("ID of the airplane that is in emergency:");
		
		try {
			int index = Integer.parseInt(response) - 1;
			atc.emergencyLanding(index);
		} catch (Exception e) {
			Utilities.error("Input must be a positive integer");
		}
		
	}
}
