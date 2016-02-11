package PublicUtils;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
 
public class Serializer {
   public static void serialize(String filePath, Account account) {
	   //File dir = new File(".");
	   //String[] dirs = dir.list();
	   //for(int i = 0; i < dirs.length; i++){
		   //System.out.println(dirs[i]);
	   //}
	   try{    
			FileOutputStream fout = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fout); 
			Object obj = (Object)account;
			oos.writeObject(obj);
			oos.close();
		   }catch(Exception ex){
			   ex.printStackTrace();
		   } 
   }
   
   
   
   public static boolean serializeTicket(String filePath, Ticket ticket){
	   boolean attempt = false;
	   try{
		   FileOutputStream fout = new FileOutputStream(filePath);
		   ObjectOutputStream oos = new ObjectOutputStream(fout);
		   Object obj = (Object)ticket;
		   oos.writeObject(obj);
		   oos.close();
		   attempt = true;
		   return attempt;
	   }catch(Exception ex){
		   ex.printStackTrace();
		   return attempt;
	   }
   	}
 
}