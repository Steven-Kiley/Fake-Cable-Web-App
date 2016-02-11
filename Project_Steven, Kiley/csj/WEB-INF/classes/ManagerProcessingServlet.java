import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import PublicUtils.AccountManager;
import Beans.PassKeyBean;
import java.util.Enumeration;
import PublicUtils.AccountManager;
import accounts.Customer;
import java.util.ArrayList;
import services.*;
import PublicUtils.Serializer;
import java.util.HashMap;

public class ManagerProcessingServlet extends HttpServlet{
	PassKeyBean pkb;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		pkb = (PassKeyBean)session.getAttribute("PassKey");
		
		try{
			
			int privelege = pkb.getPrivelege();
			if(privelege != 3){response.sendRedirect("InsufficientPermissions");}
			Customer c = (Customer)session.getAttribute("Account");
			String choice = (String)session.getAttribute("choice");
			ArrayList<RecurringService> recurs = c.getRecur();
			ArrayList<SingleService> singles = c.getOneTime();
			RecurringService rs = null;
			SingleService ss = null;
			String name = (String)request.getParameter("service");
			boolean changeMade = false;
			System.out.println(choice);
			System.out.println(name);
			//Delete case
			if(choice.equals("delete")){
				System.out.println("In delete case.");
				for(int i =0; i <recurs.size(); i++){
					rs = recurs.get(i);
					if(rs.getName().equals(name)){
						recurs.remove(i);
						changeMade = true;
						break;
					}
				}	
				for(int j=0; j < singles.size(); j++){
					ss = singles.get(j);
					if(ss.getName().equals(name)){
						singles.remove(j);
						changeMade = true;
						break;
					}
				}
				if(changeMade == true){
					System.out.println("Adjusting account.");
					String filepath = "..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\" + c.getUsername() + ".ser";
					Serializer.serialize(filepath, c);
					Customer cNew = AccountManager.retrieveAccount(c.getUsername());
					synchronized(session){
						session.setAttribute("Account", cNew);
					}
					response.sendRedirect("ManagerChangeSuccessPage");
				}
			}
			
			
			//Cancel case
			if(choice.equals("cancel")){ 
				for(int i =0; i <singles.size(); i++){
					ss = singles.get(i);
					if(ss.getName().equals(name)){
						singles.remove(i);
						changeMade = true;
						SingleService newS = new SingleService(ss.getName(),ss.getDescription(), 0, ss.getType());
						c.setOneTime(newS);
						break;
					}
				}	
				if(changeMade == true){
					System.out.println("Adjusting account.");
					String filepath = "..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\" + c.getUsername() + ".ser";
					Serializer.serialize(filepath, c);
					Customer cNew = AccountManager.retrieveAccount(c.getUsername());
					synchronized(session){
						session.setAttribute("Account", cNew);
					}
					response.sendRedirect("ManagerChangeSuccessPage");
				}				
			}
			
			
			//Update case
			if(choice.equals("update")){response.sendRedirect("ManagerUpdatePage");}
		}catch(Exception e){e.printStackTrace();response.sendRedirect("SomethingWentWrong");}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		try{
			Customer c = (Customer)session.getAttribute("Account");
			HashMap<String, RecurringService> recur = Services.getRecurs();
			String tvChoice = request.getParameter("tvchoice");
			String internetChoice = request.getParameter("internetchoice");
			RecurringService temp = null;
			ArrayList<RecurringService> newServices = new ArrayList<RecurringService>();
			System.out.println(tvChoice);
			System.out.println(internetChoice);
			
			if(!(tvChoice.equals("none"))){
				temp = recur.get(tvChoice);
				newServices.add(temp);
			}
			
			if(!internetChoice.equals("none")){
				temp = recur.get(internetChoice);
				newServices.add(temp);
			}
			
			c.setFullRecurring(newServices);
		
			Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\"+c.getUsername()+".ser", c);
			
			Customer cNew = (Customer)AccountManager.retrieveAccount(c.getUsername());
			
			synchronized(session){
				session.setAttribute("Account", cNew);
			}
			
		
			response.sendRedirect("ManagerChangeSuccessPage");
		}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		
	}
	
}