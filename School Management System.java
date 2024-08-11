import java.util.*;
class Variables{
	static int rno = 0;
	String fname;
	String lname;
	String mNo;
	int phy;
	int chem;
	int math;
	double pr;
}
class School extends Variables{
	Scanner sc = new Scanner(System.in);
	School()
	{
		System.out.println("Enter First Name");
		fname = sc.next();
		System.out.println("Enter Last Name");
		lname = sc.next();
		System.out.println("Enter Mobile number");
		mNo = sc.next();
	}
	School(String s)
	{
		super();
	}
	void display()
	{
		System.out.println("Student Name: " + fname + " " + lname);
		System.out.println("Roll Number: " + rno);
		System.out.println("Mobile Number: " + mNo);
		System.out.println("Marks in Physics: " + phy);
		System.out.println("Marks in Chemistry: " + chem);
		System.out.println("Marks in Maths: " + math);
		System.out.println("Percentage: " + pr);
	}
	void updateStudent()
	{
		System.out.println("Enter First Name");
		fname = sc.next();
		System.out.println("Enter Last Name");
		lname = sc.next();
		System.out.println("Enter Mobile number");
		mNo = sc.next();
	}
	boolean search()
	{
		System.out.println("Enter roll number");
		int roll = sc.nextInt();
		if(rno==roll)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void setMarks()
	{
		System.out.println("Enter marks for Physics");
		phy = sc.nextInt();
		System.out.println("Enter marks for Chemistry");
		chem = sc.nextInt();
		System.out.println("Enter marks for Maths");
		math = sc.nextInt();
	}
	void calcPercentage(School s[])
	{
		boolean se;
		for(int i=0;i<1;i++)
		{
			se = s[i].search();
			if(se==true)
			{
				 pr = (s[i].phy+s[i].chem+s[i].math)*100/300;
				System.out.println("Percentage: " + pr +"%");
				if(pr>=75 || pr<=100)
				{
					System.out.println("Above Average");
				}
				else if(pr>=50 || pr<75)
				{
					System.out.println("Average");
				}
				else
				{
					System.out.println("Below Average");
				}
			}
			else
			{
				System.out.println("Invalid Roll Number");
			}
		}
	}
}
class Main{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		School s[] = new School[100];
		int ch,c;
		int count = 0;
		do{
			System.out.println("\n **********School Management System***********");
			System.out.println("1.Add students\n 2.Update Student Details\n 3.Remove Student Details\n 4.Input Marks\n 5.Calculate Percentage\n 6.Display Student Details\n 7.Exit");
			ch = sc.nextInt();
		switch(ch)
		{
			case 1: System.out.println("Enter Number of Students to be added");
					int n = sc.nextInt();
			for(int i=0;i<n;i++)
			{
				s[i] = new School();
				s[i].rno +=1;
				count++;
			}
			break;
			case 2: boolean ue;
					for(int i=0;i<count;i++)
					{
						ue = s[i].search();
						if(ue==true)
						{
							s[i].updateStudent();
						}
						else
						{
							 System.out.println("Student Not Found");
						}
					}
					break;
			case 3: boolean re;
					for(int i=0;i<count;i++)
					{
						re = s[i].search();
						if(re==true)
						{
							s[i]=new School("remove");
						}
						else
						{
							System.out.println("Student Not Found");
						}
					}
			case 4: boolean sm;
					for(int i=0;i<count;i++)
					{
						sm = s[i].search();
						if(sm==true)
						{
							s[i].setMarks();
						}
						else
						{
							System.out.println("Student Not Found");
						}
					}
					break;
			case 5: 
					for(int i=0;i<count;i++)
					{
						
							s[i].calcPercentage(s);
						
						
					}
					break;
			case 6: boolean de;
					for(int i=0;i<count;i++)
					{
						de = s[i].search();
						if(de==true)
						{
							s[i].display();
						}
						else
						{
							System.out.println("Student Not Found");
						}
					}
					break;
			case 7:	break;
			}
		}while(ch!=7);
	}
}