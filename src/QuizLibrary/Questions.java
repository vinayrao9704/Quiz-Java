package QuizLibrary;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Questions {


	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String  ans;
	
	
	public Questions(String question,String ans1,String ans2,String ans3,String ans4, String  ans)
	{
		this.setQuestion(question);
		this.setAns1(ans1);
		this.setAns2(ans2);
		this.setAns3(ans3);
		this.setAns4(ans4);
		this.setAns(ans);
	}
	
	

	public Questions()
	{
		
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
	
	
	

	


	private int String(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getAns() {
		return ans;
	}
	
	public void setAns(String Ans)
	{
		this.ans= Ans;
	}
	
	
	
	
	
	
}
