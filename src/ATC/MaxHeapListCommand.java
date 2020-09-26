package ATC;

/**
 * Control the Max-Heap list button
 * @author Quang-Duy Tran
 *
 */

import mvc.*;

public class MaxHeapListCommand extends Command {

	/**
	 * Default constructor
	 * Set the model to model
	 * @param model the model
	 */
	public MaxHeapListCommand(Model model) { super(model); }
	
	/**
	 * Print the Max-Heap list by calling the maxHeapList method from Air Traffic Control class
	 */
	public void execute() {
		AirTrafficControl atc = (AirTrafficControl) model;
		atc.maxHeapList();
	}
}
