package QuizLibrary;
import java.util.*;
import java.io.File;  
import java.io.IOException;
import java.io.FileWriter; 
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MainQuiz {
	

	public static void main(String[] args) throws IOException {
		Scanner sobj= new Scanner(System.in);
		String userName = null;
		String password = null;
		int nbQues = 0;
		int crtAns = 0;
		int Ans;
		int choice;
		String Path = "D:/filename.txt";
	    User user = new User();
		
	    do {
	    	
			    	System.out.println("Enter 1 to Register ");
			    	System.out.println("Enter 2 to Login");
			    	System.out.println("Enter 0  to Exit");
			    	System.out.println("Enter the Choice :");
			    	choice = sobj.nextInt();
			    	
			    	switch(choice)
			    	{
				    	case 1:
				    	{
				    		System.out.println(" -----Register------ ");
				    		System.out.println("Enter the User Name: ");
				    		userName = sobj.next();
				    		System.out.println("Enter the Password : ");
				    		password = sobj.next();
				    		if(user.Register(userName, password, Path))
				    		{
				    			System.out.println(" Register Sucess ");
				    			break;
				    		}
				    		else
				    		{
				    			System.out.println(" Register UnSucess ");
				    		}
				    		
				    		break;
				    	}
				    	case 2:
				    	{
				    		System.out.println(" -----Login------ ");
				    		System.out.println("Enter the User Name: ");
				    		userName = sobj.next();
				    		System.out.println("Enter the Password : ");
				    		password = sobj.next();
				    		if(user.checklogin(userName, password, Path))
				    		{
				    			System.out.println(" Login Sucess ");
				    			choice =0;
				    			break;
				    		}
				    		else
				    		{
				    			System.out.println(" Login UnSucess ");
				    		}
				    		break;
				    	}
				    	
				    	case 0:
				    	{
				    		break;
				    	}
			    	}
	    	
	    	}while(!(choice== 0));
//	    System.out.println(userName);
//	    System.out.println(password);
	   if(Integer.parseInt(userName) == Integer.parseInt("123") && 
			   Integer.parseInt(password) == Integer.parseInt("123"))
	    {
		   
		   int questionChoice = 0;
		   Topic ques =  new Topic();
		   Questions[] ques1 = new Questions[8];
		   String path = "";
		   do {
			   questionChoice = topicMenu();
			   
			   switch(questionChoice) 
			 	 {
				 	 case 1:
				 	 {
				 		 ques1 =  ques.getQuestions("Art.txt"); 
				 		 path= "Art.txt";
				 		questionChoice = 0;
				 		break;
				 	 }
				 	 case 2:
				 	 {
				 		ques1 =  ques.getQuestions("Food.txt"); 
				        path = "Food.txt";
				        questionChoice = 0;
				        break;
				 	 }
				 	 case 3:
				 	 {
				 		ques1 =  ques.getQuestions("History.txt"); 
				        path = "History.txt";
				        questionChoice = 0;
				        break;
				 	 }
				 	 case 4:
				 	 {
				 		ques1 =  ques.getQuestions("Java.txt"); 
				 		path = "Java.txt";
				 		questionChoice = 0;
				 		break;
				        
				 	 }
				 	 case 0:
				 	 {
				 		 break;
				 	 }
				 }
			   
			   
			   
		   }while(!(questionChoice== 0));
		   
		   int adminChoice;
		do {
			   
		    	 System.out.println("Enter one option to: ");
		    	 System.out.println("1.Add new question and answer for the (selected Trivia category) ");
		    	 System.out.println("2.Modify question and/or answer for the (selected Trivia category)");
		    	 System.out.println("3.Delete question and answer for the (selected Trivia category)");
		    	 System.out.println("0.Exit this section with confirmation");
		    	 System.out.println("Enter your choice:");
		    	 adminChoice = sobj.nextInt();
		    	 switch(adminChoice)
		    	 {
			    	 case 1:
			    	 {
			    		 ques.AddQuestion(path);
			    		 break;
			    	 }
			    	 case 2:
			    	 {
			    		 ques.modifyQuestion(path);
			    		 break;
			    	 }
			    	 case 3:
			    	 {
			    		 ques.deleteQuestion(path);
			    		 break;
			    	 }
			    	 case 0:
			    	 {
			    		 	break;
			    	 }
		    	 }  
			 	 
			 	    
		 	}while(!(adminChoice == 0));
	   
	    
	    }
	   else
	    {
	    
		   
		   int questionChoice = 0;
		    
		    do {
			    questionChoice = topicMenu();
			    Topic ques =  new Topic();
			    Questions[] ques1 = new Questions[8];
			 	    
			 	 switch(questionChoice) 
			 	 {
				 	 case 1:
				 	 {
				 		 ques1 =  ques.getQuestions("Art.txt"); 
				 		 
				         crtAns = displayQues(ques1);
				         break;
				 		 
				 	 }
				 	 case 2:
				 	 {
				 		ques1 =  ques.getQuestions("Food.txt"); 
				         crtAns = displayQues(ques1);
				         break;
				 	 }
				 	 case 3:
				 	 {
				 		ques1 =  ques.getQuestions("History.txt"); 
				         crtAns = displayQues(ques1);
				         break;
				 	 }
				 	 case 4:
				 	 {
				 		ques1 =  ques.getQuestions("Java.txt"); 
				         crtAns = displayQues(ques1);
				         break;
				 	 }
				 }
			 	 
			 	 displayResult(crtAns);
			 	 
		   
		   }while(!(questionChoice== 0));
	    	
	    }
	    
	}
	    
	
	public static int displayQues(Questions ques[])
	{
		int Ans,crtAns = 0,quesAns = 0;
		 for(int i=0;i<ques.length;i++)
	 	    {
	 	    	System.out.println("Q"+(i+1)+" "+ques[i].getQuestion());
	 	    	System.out.println("1 "+ques[i].getAns1());
	 	    	System.out.println("2 "+ques[i].getAns2());
	 	    	System.out.println("3 "+ques[i].getAns3());
	 	    	System.out.println("4 "+ques[i].getAns4());
//	 	    	System.out.println(ques1[i].getAns());
	 	    	
	 	    	System.out.println("Answer : ");
	 	    	Scanner sobj = new Scanner(System.in);
				Ans = sobj.nextInt();
				 
	 	    	if(Ans == Integer.parseInt(ques[i].getAns()))
	 	    	{
	 	    		crtAns += 1;
	 	    	}
	 	    	
	 	    }
		 return crtAns;
	}
		
	public static void displayResult(int crtAns)
	{
		System.out.println("Your Result is :" +crtAns);
	}
	public static int topicMenu()
	{
		int choice=0;
		System.out.println("The user menu could be as following:\n To start Trivia app. - enter one option (or special code to manage it):\n\t\t1.Art\n\t\t2.Food\n\t\t3.History\n\t\t4.Java\n\t\t0.Exit the application with confirmation \r\n" + 
				"Enter The Choice:");
		Scanner sobj= new Scanner(System.in);
		choice = sobj.nextInt();
		
		return choice;
	}
	
	
}
