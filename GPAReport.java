// Kidus Degefu
// Kwdegefu18@ole.augie.edu
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
public class GPAReport
{
	//Desc:	The program reads the student information stored in "data.txt", computes the GPA of the 
	//		student, and produces a report and store that report in "report.txt"
	//Input:The input file "data.txt" contains the following items, one on each line:
	//	Student name (a string such as John Johnson)
	//	Number of course (an int such as 2)
	//	Course Name (a string such as Computer Science I)
	//	Credit hours (an int such as 4)
	//	Grade (any one of A, B, C, D, F)
	//	Course Name (e.g. Introduction to Art)
	//	Credit hours 
	//	Grade
	//Post:A report in the following format is printed on to a disk file "report.txt":
	//	Name		Courses			Credit Hours	Grade	
	//	-----------------------------------------------------------------------------------
	//	John Johnson	Computer Science I	4		A
	//					Introduction to Art	3		B-
	//	GPA: 3.44
	//	Paul Paulson     Computer Science I 4       C-   
    //               	 Intro to Politics  3       B    
    //                	 Calc I             4       B    
	//	GPA: 2.53

	public static void main(String[]args)throws FileNotFoundException
	{
		PrintWriter p=new PrintWriter("report.txt");
		p.printf("%-20s%-25s%-15s%-5s\n", 
					"Name", "Courses", "Credit Hours", "Grade");
		p.println("-----------------------------------------------------------------");
		Scanner input = new Scanner(new File("data.txt"));
		while(input.hasNextLine())
		{
			Boolean first=true;
			double GP =0.0, totalCreditHr =0.0;
			String studName=input.nextLine();
			int n=input.nextInt();
			input.nextLine();
			for(int j=0;j<n;++j)
			{
				String courseName=input.nextLine();
				int creditHr=input.nextInt();
				input.nextLine();
				totalCreditHr+=creditHr;
				String grade=input.nextLine();
				GP+=creditHr*findPoint(grade);
				if(first)
				{
					p.printf("%-20s%-25s%-15s%-5s\n", 
								studName,courseName,creditHr,grade);
					first=false;						
				}
				else 
					p.printf("%-20s%-25s%-15s%-5s\n", 
								"",courseName,creditHr,grade);
				}							
					p.printf("GPA:%5.2f\n",GP/totalCreditHr);
			}
			input.close();
			p.close();
	}
	//Pre:ch represents a valid grade, which must be A+, A, A-, B+, B, B-, C+, 
	// 		C, C-, D+, D, D- or F
	//Return:the grade point of ch
	public static double findPoint(String ch)
	{
		switch(ch)
		{
			case "A+" : return 4.0;
			case "A" : return 4.0;
			case "A-": return 3.7;
			case "B+": return 3.3;
			case "B": return 3.0;
			case "B-": return 2.7;
			case "C+": return 2.3;
			case "C": return 2.0;
			case "C-": return 1.7;
			case "D+": return 1.3;
			case "D": return 1.0;
			case "D-": return 0.7;
			case "F": return 0.0;
			default: return -1.0;
		}
			
	}	
}