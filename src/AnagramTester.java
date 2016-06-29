import java.io.*;
import java.util.ArrayList;

//tester class
public class AnagramTester {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File dict;

		//if input argument was provided, use that file as input
		if(args.length > 0)
			dict = new File(args[0]);
		else  //otherwise use first dictionary
			dict = new File("..\\dictionary\\dict1");

		LineNumberReader lnr = new LineNumberReader(new FileReader(dict)); //count the lines in the file
		lnr.skip(Long.MAX_VALUE);

		Finder myFinder = new Finder(lnr.getLineNumber()+1); //create new anagram finder object and pass it the number of lines for correct hashMap array size
		lnr.close();
		
		myFinder.processFile(dict); //process the dictionary file

		File anagram = new File("..\\output\\anagrams");

		//if output argument was provided, create a file at given location, otherwise print to default output file
		if(args.length > 1)
			anagram = new File(args[1]);

		FileOutputStream fos = new FileOutputStream(anagram); //print output to file
		System.setOut(new PrintStream(fos));

		myFinder.display();

	}
}
