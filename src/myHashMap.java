import java.util.ArrayList;

//array based hashmap implementation
class myHashMap<K,V> {
	private int capacity; //capacity for our array of entries
	private Entry<String, ArrayList<String>>[] table; //create new array to store the anagram classes

	//constructor that takes in the number of lines in the file
	myHashMap(int lines){
		capacity = lines;
		table = new Entry[capacity]; //give anagram table a size of number of lines in a dictionary
	}
	//put function that takes care of inserting every word in the dictionary one by one
	public void put (String key, String data){
		int hash = hashCode(key); //get hashcode for a given key, which is the word sorted in an alphabetical order

		if(table[hash] == null) //if there is no entry at the index produced by hash method, create new entry there and add the first anagram
			table[hash] = new Entry<>(key, new ArrayList<String>());
		table[hash].addValue(data); //add one more anagram at the given hash index

	}

	//get method returns a list of all anagrams for a given word/key
	public ArrayList<String> get(String key){
		int hash = hashCode(key); //get hash so that we can look up the correct entry
		if(table[hash] == null) //if there is no entry at given hash, then there is no anagrams for the word
			return null;
		else { //otherwise return the list of anagrams for a given word
			Entry<String, ArrayList<String>> temp = table[hash];

			while(temp != null)
					return temp.getList();
			return null;
		}
	}

	//just a lil function that prints all the anagram classes
	public void allClasses(){
		for(int i=0; i < capacity; i++){
			if(table[i] != null)
				System.out.println(table[i].getList());
		}
	}

	//hashcode function that gets the correct hashcode based on a given key, so that put function doesn't have to resolve collisions
	private int hashCode(String key){
		int hash = Math.abs(hashFunction(key)) % capacity; //calculates hash based on hash function

		if(table[hash] == null || table[hash].getKey().equals(key)) //checks whether the entry doesn't exist at given key or whether the key for existing entry matches
			return hash; //returns hash if so
		else{ //otherwise gotta do quadratic probing until there's an empty slot or keys match, so that we can put the key at that index
			int i = 1;
			while(table[hash] != null && !table[hash].getKey().equals(key)){ //quadratic probing of the form (hash(key)+7i+3i^2)%capacity
				hash = Math.abs(hash + i + 3*(int)Math.pow(i++, 2)) % capacity;
			}

			return hash;
		}
	}

	
	private int hashFunction(String key){
		final int prime = 0x01000193;
		int hash = 0x811c9dc5;
		int length = key.length();

		for(int i = 0; i < length; i++){
			hash ^= key.charAt(i);
			hash *= prime;
		}
		return hash;

	}
}
