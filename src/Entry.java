import java.util.ArrayList;

//Entry class that holds a key,value tuple in a form of String, ArrayList<String>
//the tuple represents an anagram class, the array list holds a list of all anagrams in that class
//the key is an alphabetically sorted representation of anagrams in a given anagram class
public class Entry<String, V>{
	private String key;
	private ArrayList<String> value = new ArrayList<String>();

	//constructor for entry
	Entry(String key, ArrayList<String> value){
		this.key = key;
		this.value = value;
	}

	//add value to the array list of given entry
	public void addValue(String value){
		this.value.add(value);
	}

	//get list of anagrams from given entry
	public ArrayList<String> getList(){
		return this.value;
	}

	//get the key of given entry
	public String getKey(){
		return key;
	}


}
