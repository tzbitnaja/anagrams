//class for a basic Merge Sort implementation
public class MergeSort {
	private char[] outgoing;
	private char[] helper;

	private int length;

	//sort(String incoming) takes care of converting passed String into char array, creates helper array based on the string's length
	//sort also calls merge sort method and then returns the sorted char array in a String form
	public String sort(String incoming){
		if(incoming.length() <= 1)
			return incoming;

		outgoing = incoming.toCharArray(); //convert incoming string to char array
		length = incoming.length(); //get length of the string
		helper = new char[length]; //create a helper array
		
		mergesort(0, length-1);
		return String.valueOf(outgoing); //returning a String formed from the sorted char array
	}

	//recursive mergesort. basic divide and conquer idea that then calls merge to merge the array back together in a correct sorted order
	public void mergesort(int start, int end){
		if(start < end){
			int middle = start + (end-start)/2; //find the mid point
			mergesort(start, middle); //call merge sort on first half
			mergesort(middle+1, end); //call merge sort on second half
			merge(start, middle, end); //merge both halves
		}
	}

	//merge method, the workhorse of merge sort, switches the characters around in respective halves
	public void merge(int start, int middle, int end){
		for(int i = start; i <= end; i++)
			helper[i] = outgoing[i]; //copy parts into array
		
		int i = start; //start index
		int j  = middle + 1; //midpoint index
		int k = start;
		
		while(i <= middle && j <= end){ //put smallest elements back into the outgoing array
			if(helper[i] <= helper[j]){
				outgoing[k] = helper [i];
				i++;
			}
			else{
				outgoing[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i <= middle){ //put the rest of the elements into the outgoing array
			outgoing[k] = helper[i];
			k++;
			i++;
		}
	}
}
