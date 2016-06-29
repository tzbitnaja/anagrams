import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//finder class that takes care of processing the dictionary files
public class Finder {
	MergeSort mySort = new MergeSort(); //sort object
	myHashMap<String, ArrayList<String>> myMap;//hashmap object

	Finder(int lines){
		myMap = new myHashMap<>(lines);
	}
	//process file function
	public void processFile(File dictionary) throws FileNotFoundException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(dictionary)); //buffered reader to process the passed file
			String line;
			while((line = br.readLine()) != null) //line by line, pass sorted line (as key) and the line itself into put function
				myMap.put(mySort.sort(line), line);
	}

	//get list of anagrams for a given word
	public ArrayList<String> getList(String key){
		return myMap.get(mySort.sort(key));
	}

	//display all anagram classes
	public void display(){
		myMap.allClasses();
	}
}
