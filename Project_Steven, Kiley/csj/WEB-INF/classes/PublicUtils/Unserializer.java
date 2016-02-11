package PublicUtils;

import java.util.HashMap;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Unserializer {
	public static HashMap<String, Account> deserializeDirectory(String directory) throws ClassNotFoundException, IOException {
		Account acct = null;
		HashMap<String, Account> accounts = new HashMap<String, Account>();
		//System.out.println(directory);
		//File curdir = new File(".");
		//String[] curdirs = curdir.list();
		//for(int k = 0; k < curdirs.length; k++){
			//System.out.println(curdirs[k]);
		//}
		
		File dir = new File(directory);
		String[] files = dir.list();
		//System.out.println(dir.exists());
		//System.out.println(files.length);
		for(int i = 0; i < files.length; i++){
			String file = directory + "\\" + files[i];
			acct = readFile(file);  
			accounts.put(acct.getUsername(), acct);
		}
		  
	return accounts;
	}
	
	private static Account readFile(String fileName) throws IOException, ClassNotFoundException{
		boolean test = true;
		Object obj = null;
		Account temp = null;
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fileIn);  
			while(test == true){
				obj = ois.readObject();
				temp = (Account)obj;
			}
			ois.close();
			fileIn.close();
		   }catch(EOFException ex){
			   test = false;
		   }
		return temp;
	}
}