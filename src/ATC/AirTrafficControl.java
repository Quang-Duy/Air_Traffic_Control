package ATC;

/**
 * Models an air traffic control simulation
 * @author Quang-Duy Tran
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import mvc.*;

public class AirTrafficControl extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isSorted;
	private Heap heap;
	private ArrayList<Airplane> initial_list;
	private ArrayList<Airplane> max_heap_list;
	private ArrayList<Airplane> sorted_list;
	
	/**
	 * Default constructor
	 * Set the isSorted variable to false
	 * Create an empty heap
	 * Create empty array list for all 3 array list variables
	 * Random generate 30 airplanes and put them in the array list
	 */
	public AirTrafficControl()
	{
		this.isSorted = false;
		
		this.heap = new Heap();
		this.initial_list = new ArrayList<>();
		this.max_heap_list = new ArrayList<>();
		this.sorted_list = new ArrayList<>();
		
		//Add 30 airplanes by default and deep copy them into max-heap list.
		//Airplane is passed by reference from max-heap list to sorted list. Because of viewFirstRankedAC and emergencyLanding methods
		for(int i = 0; i < 30; i++) {
			this.initial_list.add(new Airplane());
			this.max_heap_list.add(new Airplane(this.initial_list.get(i)));
			this.sorted_list.add(this.max_heap_list.get(i));
		}
	}
	
	/**
	 * Add new flight number from user using Max-Heap-Insert
	 * @param flight_number new flight number from user
	 */
	public void insert(String flight_number) 
	{
		Airplane newAirPlane = new Airplane(flight_number);
		
		//Add a new airplane into the initial list; Deep copy
		this.initial_list.add(new Airplane(newAirPlane));
		
		//Note that the list won't be sorted until pressing the sort button again; Shallow copy
		this.sorted_list.add(newAirPlane);
		
		//Insert a new airplane into Heap using Max-Heap-Insert; Shallow copy
		this.max_heap_list.add(newAirPlane);
		this.heap.Max_Heap_Insert(this.max_heap_list, newAirPlane.getApproachCode());
		
		//Changing the AC will result in sorting the list again. And if user has not clicked sort button, isSort is false
		this.isSorted = false;
		
		//Save the change that we made, from mvc.Model
		changed();
	}
	
	/**
	 * Sort the array using heap-sort and reverse it so that the list is in descendant order
	 * Inform the user if the list is sorted
	 * Throw error message if the list is empty
	 */
	public void sort() 
	{	
		if(!this.sorted_list.isEmpty())
		{
			//Sort the list using heap_sort
			this.heap.Heap_Sort(this.sorted_list);
			
			//Reverse the list to descendant order 
			Collections.reverse(sorted_list);
			
			//Reset the heap size back to the array size after sorting
			this.heap.setHeapSize(this.sorted_list.size());
			
			Utilities.inform("Sorted!");
			this.isSorted = true;
		}
		else
		{
			Utilities.error("List is empty");
		}
		//Save the change that we made, from mvc.Model
		changed();
	}
	
	/**
	 * Print the initial list; Initial list is unchanged no matter what (except adding new airplane)
	 * Initial list is used to check the requirements
	 */
	public void initialList()
	{
		String[] result = new String[this.initial_list.size() + 1];
		result[0] = "Initial list of airplanes:";
		
		for(int i = 1; i <= this.initial_list.size(); i++)
		{
			result[i] = i + ". (" + this.initial_list.get(i-1).getFlightNumber() + ", " +
						"D: " + this.initial_list.get(i-1).getDistance() + " meters, " +
						"H: " + this.initial_list.get(i-1).getElevation() + " meters) - " +
						"AC: " + this.initial_list.get(i-1).getApproachCode();
		}
		
		Utilities.inform(result);
		
		//Save the change that we made, from mvc.Model
		changed();
	}
	
	/**
	 * Print the Max-Heap list
	 * Throw error message if list is empty
	 */
	public void maxHeapList()
	{
		if(!this.max_heap_list.isEmpty()) {
			this.heap.Build_Max_Heap(this.max_heap_list);
			
			String[] result = new String[this.max_heap_list.size() + 1];
			result[0] = "Max-Heap list of airplanes:";
			
			for(int i = 1; i <= this.max_heap_list.size(); i++)
			{
				result[i] = i + ". (" + this.max_heap_list.get(i-1).getFlightNumber() + ", " +
							"D: " + this.max_heap_list.get(i-1).getDistance() + " meters, " +
							"H: " + this.max_heap_list.get(i-1).getElevation() + " meters) - " +
							"AC: " + this.max_heap_list.get(i-1).getApproachCode();
			}
			
			Utilities.inform(result);
		}
		else {
			Utilities.error("List is empty");
		}
		
		//Save the change that we made, from mvc.Model
		changed();
	}
	
	/**
	 * Print the sorted list
	 * Inform user if the list is not sorted
	 * Throw error message if the list is empty
	 */
	public void sortedList()
	{
		if(this.isSorted == false) {
			Utilities.inform("Airplanes Landing Sequence:");
			changed();
			return;
		}
		
		if(!this.sorted_list.isEmpty()) 
		{
			String[] result = new String[this.sorted_list.size() + 1];
			result[0] = "Airplanes Landing Sequence:";
			
			for(int i = 1; i <= this.sorted_list.size(); i++)
			{
				result[i] = i + ". (" + this.sorted_list.get(i-1).getFlightNumber() + ", " +
							"D: " + this.sorted_list.get(i-1).getDistance() + " meters, " +
							"H: " + this.sorted_list.get(i-1).getElevation() + " meters) - " +
							"AC: " + this.sorted_list.get(i-1).getApproachCode();
			}
			
			Utilities.inform(result);
		}
		else
		{
			Utilities.error("List is empty");
		}
		
		//Save the change that we made, from mvc.Model
		changed();
	}
	
	/**
	 * Allow user to view the first airplane to land using Heap-Extract-Max
	 * Throw error messages if list is not sorted or list is empty
	 */
	public void viewFirstRankedAC()
	{
		if(this.isSorted == false) {
			Utilities.error("List is not sorted");
		}
		else
		{
			if(!this.sorted_list.isEmpty()) 
			{
				Airplane max = this.heap.Heap_Maximum(this.sorted_list);
				this.heap.Heap_Extract_Max(this.sorted_list);
				
				String result = "(" + max.getFlightNumber() + ", " +
								"D: " + max.getDistance() + " meters, " +
								"H: " + max.getElevation() + " meters) - " +
								"AC: " + max.getApproachCode();
				
				//Print the first airplane to land
				Utilities.inform(result);
				
				//Remove the extracted element in order to print
				this.sorted_list.remove(this.sorted_list.size() - 1);
				
				//Looking for the index of the remove airplane inside max-heap list
				int index = -1;
				for(int i = 0; i < this.max_heap_list.size(); i++)
				{
					if(this.max_heap_list.get(i).getFlightNumber().equalsIgnoreCase(max.getFlightNumber())) {
						index = i;
						break;
					}
				}
				this.max_heap_list.remove(index);
			}
			else
			{
				Utilities.error("List is empty");
			}
		}
		
		//Save the change that we made, from mvc.Model
		changed();
	}
	
	/**
	 * Allow user to choose any airplane and increase its AC in case of emergency landing
	 * @param index the index of the airplane in the Max-Heap list; given by user
	 */
	public void emergencyLanding(int index)
	{	
		if(!this.sorted_list.isEmpty())
		{
			//Check if index is larger than array size
			if(index > this.max_heap_list.size() - 1) {
				Utilities.error("ID not found");
				return;
			}
			
			//Changing the AC will result in sorting the list again. And if user has not clicked sort button, isSort is false
			this.isSorted = false;
			
			this.heap.Heap_Increase_Key(this.max_heap_list, index, Integer.MAX_VALUE);
		} 
		else
		{
			Utilities.error("List is empty");
		}
		//Save the change that we made, from mvc.Model
		changed();
	}
}
