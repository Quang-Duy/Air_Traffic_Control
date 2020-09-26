package ATC;

/**
 * Contains Heap Sort algorithm and Max-Heap Priority Queue
 * @author Quang-Duy Tran
 *
 */

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
	
	private int heap_size;
	
	/**
	 * Default constructor
	 * Set the size of heap to zero
	 */
	public Heap()
	{
		this.heap_size = 0;
	}
	
	/**
	 * Maintaining the max-heap property
	 * Place the given index to the right position (must be smaller than the parent node and bigger than the child nodes)
	 * @param arr the given array 
	 * @param index the index of the node
	 */
	public void Max_Heapify(ArrayList<Airplane> arr, int index)
	{
		int largest = 0;
		int left_child = getLeftChild(index);
		int right_child = getRightChild(index);
		
		if(left_child < this.heap_size && arr.get(left_child).getApproachCode() > arr.get(index).getApproachCode())
			largest = left_child;
		else
			largest = index;
		
		if(right_child < this.heap_size && arr.get(right_child).getApproachCode() > arr.get(largest).getApproachCode())
			largest = right_child;
		
		if(largest != index) {
			swap(arr, index, largest);
			Max_Heapify(arr, largest);
		}
	}
	
	/**
	 * Convert an array into a max-heap
	 * @param arr the given array
	 */
	public void Build_Max_Heap(ArrayList<Airplane> arr)
	{
		this.heap_size = arr.size();
		for(int i = arr.size() / 2; i >= 0; i--)
		{
			Max_Heapify(arr, i);
		}
	}
	
	/**
	 * Sort the array by maintaining the as yet unsorted elements as a max-heap
	 * @param arr the given array
	 */
	public void Heap_Sort(ArrayList<Airplane> arr)
	{
		Build_Max_Heap(arr);
		
		for(int i = arr.size() - 1; i >= 1; i--)
		{
			swap(arr, 0, i);
			this.heap_size--;
			Max_Heapify(arr, 0);	
		}
	}
	
	/**
	 * Insert a new element into the max-heap
	 * @param arr the given array
	 * @param key the new approaching code that is belong to the new added airplane
	 */
	public void Max_Heap_Insert(ArrayList<Airplane> arr, int key)
	{
		this.heap_size++;
		arr.get(heap_size - 1).setApproachCode(Integer.MIN_VALUE);
		Heap_Increase_Key(arr, this.heap_size - 1, key);
	}
	
	/**
	 * Removes and returns the element of max-heap with the largest key
	 * @param arr the given array
	 * @return the airplane has the largest approaching code
	 */
	public Airplane Heap_Extract_Max(ArrayList<Airplane> arr)
	{
		if(this.heap_size < 1) {
			System.err.println("Heap Underflow");
			return null;
		}
		
		Airplane max = arr.get(0);
		
		//Replace the first element with the last element
		arr.set(0, arr.get(this.heap_size - 1));
		
		this.heap_size--;
		Max_Heapify(arr, 0);
		
		return max;
	}
	
	/**
	 * Increases the value of an element to new value key, where key is bigger or equal to the current element
	 * @param arr the given array
	 * @param index the given index of the new element
	 * @param key the approaching code that is being to the new added airplane
	 */
	public void Heap_Increase_Key(ArrayList<Airplane> arr, int index, int key)
	{
		if(key < arr.get(index).getApproachCode()) {
			System.err.println("New key is smaller than current key");
			return;
		}
		
		arr.get(index).setApproachCode(key);
		
		while(index > 0 && arr.get(getParent(index)).getApproachCode() < arr.get(index).getApproachCode())
		{
			swap(arr, index, getParent(index));
			index = getParent(index);
		}
	}
	
	/**
	 * Returns the airplane with the largest approach code
	 * @param arr the given array
	 * @return the flight number
	 */
	public Airplane Heap_Maximum(ArrayList<Airplane> arr) {
		return arr.get(0);
	}
	
	/**
	 * Helper function; Find the parent node of the given index
	 * If the given index is even, we have to minus 1
	 * If the given index is odd, we don't have to minus 1
	 * @param index the given node
	 * @return the parent node of the index
	 */
	public int getParent(int index)
	{
		if(index % 2 == 0)
			return (index / 2 - 1);
		else
			return (index / 2);
	}
	
	/**
	 * Helper function; Find the left child node of the given index
	 * @param index the given node
	 * @return the left child node of the index
	 */
	public int getLeftChild(int index)
	{
		return 2 * index + 1;
	}
	
	/**
	 * Helper function; Find the right child node of the given index
	 * @param index the given node
	 * @return the right child node of the index
	 */
	public int getRightChild(int index)
	{
		return 2 * index + 2;
	}
	
	/**
	 * Helper function; exchange the position of two airplanes in the array
	 * @param arr the given array
	 * @param index1 the index of the first airplane
	 * @param index2 the index of the second airplane
	 */
	public void swap(ArrayList<Airplane> arr, int index1, int index2)
	{
		Collections.swap(arr, index1, index2);
	}
	
			/****** Getter function ******/
	public int getHeapSize() { return this.heap_size; }
	
			/****** Setter function ******/
	public void setHeapSize(int heap_size) { this.heap_size = heap_size; }
}
