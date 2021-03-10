package QuizLibrary;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Topic extends Questions {

	private int  topicId;
	
	
	public Topic(int id)
	{
		
		this.topicId=id;
		
	}
	public Topic()
	{
		
	}
	
	Scanner sobj = new Scanner(System.in);
	
	public void AddQuestion(String path)
	{
		int choice;
		do {
			
		
		System.out.println("Enter 1 to Add Question");
		System.out.println("Enter 0 to Exit");
		choice = sobj.nextInt();
		
		switch(choice)
		{
		
		case 1:
		{
			try
					{
						FileWriter fWriter = new FileWriter(path,true);
		//				fWriter.write("hi this is vinay");
		//				fWriter.close();
						BufferedWriter bWriter =  new BufferedWriter(fWriter);
						bWriter.newLine();
						System.out.println("Enter the Question :");
						bWriter.append(sobj.next().toString());
						bWriter.append(",".toString());
						System.out.println("Enter option for Ans 1: ");
						bWriter.append(sobj.next()).toString();
						bWriter.append(",".toString());
						System.out.println("Enter option for Ans 2: ");
						bWriter.append(sobj.next()).toString();
						bWriter.append(",".toString());
						System.out.println("Enter option for Ans 3: ");
						bWriter.append(sobj.next()).toString();
						bWriter.append(",".toString());
						System.out.println("Enter option for Ans 4: ");
						bWriter.append(sobj.next()).toString();
						bWriter.append(",".toString());
						System.out.println("Enter option for Ans: ");
						bWriter.append(sobj.next());
						bWriter.append(",".toString());
						bWriter.newLine();
						bWriter.close();
						
						
					}
					catch(Exception e)
					{
						 e.printStackTrace();
						
						
					}
				}
				case 0:
				{
					break;
				}
				
				
				
				}
		
		
		System.out.println();
		
		
		}while(!(choice==0));
		
		
		
		
		
		
		
		
	}
	
	
	public void displayQuestion(Questions[] ques)
	{
		 for(int i=0;i<=ques.length;i++)
	 	    {
	 	    	System.out.println("Q"+i+" "+ques[i].getQuestion());
	 	    	System.out.println("1 "+ques[i].getAns1());
	 	    	System.out.println("2 "+ques[i].getAns2());
	 	    	System.out.println("3 "+ques[i].getAns3());
	 	    	System.out.println("4 "+ques[i].getAns4());
	 	    }
		
	}
	
	public void modifyQuestion(String path) throws IOException
	{
		int len =0 ;
		int choice;
		int Choice;
		int quesChoice ; 
		do {
			
		
			System.out.println("Enter 1 to Modify Question");
			System.out.println("Enter 0 to Exit");
			choice = sobj.nextInt();
			
			switch(choice)
			{
			
				case 1:
				{
				
					
					
					Questions[] ques = new Questions[9];
					ques = getQuestions(path);
					len = ques.length;
					
					//displayQuestion(ques);
					System.out.println("Enter the question which you want to Modify : ");
					Choice = sobj.nextInt();
					System.out.println("Enter 0 to midify " + ques[Choice].getQuestion());
					System.out.println("Enter 1 to midify " + ques[Choice].getAns1());
					System.out.println("Enter 2 to midify " + ques[Choice].getAns2());
					System.out.println("Enter 3 to midify " + ques[Choice].getAns3());
					System.out.println("Enter 4 to midify "+ ques[Choice].getAns4());
					System.out.println("Enter 5 to midify " + ques[Choice].getAns());
					quesChoice = sobj.nextInt();
					switch(quesChoice)
					{
						case 0:
						{
							System.out.println("Enter the question : ");
							ques[Choice].setQuestion(sobj.next());
							break;
						}
						
						case 1:
						{
							System.out.println("Enter the option 1 : ");
							ques[Choice].setAns(sobj.next());
							break;
						}
						case 2:
						{
							System.out.println("Enter the option 2 : ");
							ques[Choice].setAns2(sobj.next());
							break;
						}
						case 3:
						{
							System.out.println("Enter the option 3 : ");
							ques[Choice].setAns3(sobj.next());
							break;
						}
						case 4:
						{
							System.out.println("Enter the Option 4 : ");
							ques[choice].setAns4(sobj.next());
							break;
						}
						case 5:
						{
							System.out.println("Enter the Crt Answer : ");
							ques[Choice].setAns(sobj.next());
							break;
						}
					}
					
					setQuestion(path,ques);
				}
				
				case 2:
				{
					break;
				}
		
				
			}
		}while(!(choice==0));
		
		
	}
	public void deleteQuestion(String path) throws IOException
	{
		int len;
		int choice;
		int Choice;
		do {
			System.out.println("Enter 1 to Delete Question");
			System.out.println("Enter 0 to Exit");
			choice = sobj.nextInt();
			
			switch(choice)
			{
			
				case 1:
				{
//					Runtime r= Runtime.getRuntime();
//					r.exec("Notepad"+path);
					Questions[] ques = new Questions[9];
					ques = getQuestions(path);
					len = ques.length;
					System.out.println("Enter the question which you want to Delete :");
					Choice = sobj.nextInt() -1;
			        for(int i = 0; i < ques.length; i++){
			            if( i == (Choice)){
			                // shifting elements
			                for(int j = i; j < ques.length - 1; j++){
			                    ques[j] = ques[j+1];
			                }
			                break;
			            }
			        }
			        setQuestion(path,ques);
				}
				
				case 2:
				{
					break;
				}
		
			}
		}while(!(choice==0));
	}
	
	
	public void setQuestion(String path,Questions[] ques)
	{
		try
		{
			
			
			
			FileWriter fWriter = new FileWriter(path);
			BufferedWriter bWriter =  new BufferedWriter(fWriter);
			bWriter.write("");
			bWriter.close();
			FileWriter fWriter1 = new FileWriter(path,true);
			BufferedWriter bWriter1 =  new BufferedWriter(fWriter1);
			//System.out.println(ques[0].getQuestion());
			for(int i =0;i<ques.length;i++)
			{
			bWriter1.append(ques[i].getQuestion().toString());
			bWriter1.append(",".toString());
			bWriter1.append(ques[i].getAns1().toString());
			bWriter1.append(",".toString());
			bWriter1.append(ques[i].getAns2().toString());
			bWriter1.append(",".toString());
			bWriter1.append(ques[i].getAns3().toString());
			bWriter1.append(",".toString());
			bWriter1.append(ques[i].getAns4().toString());
			bWriter1.append(",".toString());
			bWriter1.append(ques[i].getAns().toString());
			bWriter1.newLine();
			
			}
			bWriter1.close();
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			
			
		}
	}
	
	
	
	
	
	
//	public int nbQuestions(String path) throws FileNotFoundException
//	{
//		int nbQuestion = 0;
//		Scanner read = new Scanner (new File(path));
//		while(read.hasNextLine())
//		{
//			nbQuestion +=1;
//		}
//		
//		
//		return nbQuestion;
//	}
	
	public Questions[] getQuestions(String path) throws FileNotFoundException
	{
		
		String mainstring;
		String[] ArrayStr =null ;
		Questions[] ques = new Questions[8];
		//ArrayList<String> questions = new ArrayList();
		int i=0;
		try 
		{
			
			Scanner read = new Scanner (new File(path));
			
			while(read.hasNextLine())
			{
				
				mainstring = read.nextLine();
				ArrayStr = mainstring.split(",");
				//System.out.println(Arrays.toString(ArrayString));
//				for(int i=0;i<6;i++)
//				{
//					System.out.println(ArrayStr[i]);
//				}
//				questions.addAll(Arrays.asList(ArrayStr));
				//read.nextLine();
				ques[i] = new Questions(ArrayStr[0],ArrayStr[1],ArrayStr[2],ArrayStr[3],ArrayStr[4],(ArrayStr[5]));
				i++;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ques;
		
		
		
	}

	
}
