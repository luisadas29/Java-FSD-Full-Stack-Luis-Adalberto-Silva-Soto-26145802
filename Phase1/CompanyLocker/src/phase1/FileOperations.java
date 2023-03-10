package phase1;
import java.io.File;
import java.util.*;
import java.io.IOException;

public class FileOperations {
	File path = new File(System.getProperty("user.dir"));// home directory so it can run in any environment
	String set [] = path.list();
	SortedSet<String> temp = new TreeSet<String> (String.CASE_INSENSITIVE_ORDER); // To ignore case sensitive in the sorting
	Scanner choice2= new Scanner(System.in);
	String d;
	
	// Method to retrieve the files - Adding the Array with all the names of the files to a SortedSet and then returning the SortedSet 
	public SortedSet<String> retrieveFiles(){ 
	    set = path.list();
		for (int i=0; i < set.length; i++) {
			temp.add(set[i]);
		}
		return temp;		
	}
	//This Method adds a file, with exception handling in case there is a issue with the method of File createNewFile
	public void addFile() throws IOException 
	{
		System.out.println("Name of the File to be created ->");
		d = choice2.next();
		int c=this.findFile(d);
		if (c<1) {
			File newFile = new File(path.getAbsolutePath()+"\\"+d);
			newFile.createNewFile();
		}else {System.out.println("File Already Exists! \n");}
		
	}
	//This Method Searches a specific File Name in the directory
	public void search(){
		System.out.println("Name of the File to be searched ->");
		d = choice2.next();
		int b = this.findFile(d);
		if (b >= 0) {
			System.out.println("File Found! \n");
		}else {System.out.println("File Not Found! \n");}
	}
	
	public void deleteFile() {
		System.out.println("Name of the File to be deleted ->");
		d = choice2.next();
		int a = this.findFile(d);
		if (a>=0) {
		    File newFile1 = new File (path.getAbsolutePath()+"\\"+d);
		    newFile1.delete();
		}else {
			System.out.println("File does not exist! \n");
		}
	}
	// This Function received the User inputed String - and then checks if it matches with any of the File names in
	// the directory - if it does it returns the Index in the set, if it does not it returns a negative number.
	public int findFile(String a) { //STRCMPI find
		int j;
		int c = -1;
		set = path.list();
		for (int i=0; i < set.length; i++) {
		 j = set[i].compareTo(a);
			if (j == 0 ) {
				c = i;
			}	
		}
		return c;
	}
}
