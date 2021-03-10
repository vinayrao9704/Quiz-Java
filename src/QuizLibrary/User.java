package QuizLibrary;
import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class User {

	private  String userName;
	private  String password;
	
	public  void setUserName( String uName)
	{
		this.userName = uName;
	}
	public void setPassword(String pwd)
	{
		this.password = pwd; 
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	public boolean createFile(String path)
	{
		boolean check =true;
		File file= new File(path);
		try {
			if(file.createNewFile())
			{
				check = true;
			}
			else
			{
				check = false;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace(); 
		}
		
		
		
		return check;
	}
	public boolean Register(String UserName,String Password,String path)
	{
		try
		{
			FileWriter fWriter = new FileWriter(path,true);
//			fWriter.write("hi this is vinay");
//			fWriter.close();
			BufferedWriter bWriter =  new BufferedWriter(fWriter);
			bWriter.append(UserName.toString());
			bWriter.append(",".toString());
			bWriter.append(Password.toString());
			bWriter.newLine();
			bWriter.close();
			return true;
			
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			
			 return false;
		}
		
	}
	
	public boolean checklogin(String UserName, String Password,String path)
	{
		int uName,pass,Username,password;
		String mainstring,usName="";
		String[] ArrayString ; 
		boolean check = false;
//		System.out.println(UserName);
//		System.out.println(Password);
		try 
		{
			Scanner read = new Scanner (new File(path));
			
			while(read.hasNextLine())
			{
				mainstring= read.nextLine();
				ArrayString = mainstring.split(",");
				//System.out.println(Arrays.toString(ArrayString));
				uName =Integer.parseInt(ArrayString[0]) ;
				pass = Integer.parseInt(ArrayString[1]);
				Username = Integer.parseInt(UserName);
				password = Integer.parseInt(Password);
//				System.out.println(uName);
//				System.out.println(pass);
				//read.nextLine();
				
//				System.out.println(uName);
//				
//				System.out.println(pass);
				//&& Password == pass.toUpperCase()
				if(Username == uName &&  pass == password)
				{
//					System.out.println("inside if");
					check = true;
					break;
				}
//				else
//				{
//					System.out.println("inside else ");
//				}
//				while(uName == UserName && pass == Password)
//				{
//					System.out.println("inside");
//					check= true;
//					break;
//				}
				
//				
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return check;
	
	}
	
	
}
