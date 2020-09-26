package ATC;

/**
 * Control the First Ranked AC button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class ViewFirstRankedACCommand extends Command {
	
	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public ViewFirstRankedACCommand(Model model) { super(model); }
	
	/**
	 * Print the first airplane in queue to land by calling viewFirstRankedAC from Air Traffic Control class
	 */
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		atc.viewFirstRankedAC();
	}
}
