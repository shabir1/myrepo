/*
* Book
*this program reads n books from standard input and print them on standard output.
*it gets value of n through commaandline.
*/
import org.apache.commons.cli.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

/*this is the this class Book
*
*/
public class CmdBook {
          String title;
         String publisher_name;
         String published_date;
	 String content="";
        ArrayList<String> author_name=new ArrayList<String>();

	/*
	*main function 
	*/
	public static void main(String args[]) {
	String title1=" ";
	String publisher_name1=" ";
	String published_date1="";
	String content1="";
	int n=0;
	String str="";

	  //try block starts here 
	   try{
	    Options option=new Options();
	    option.addOption("hp",false,"help");
	    option.addOption("hlp",false,"help");
	    CommandLineParser parser = new DefaultParser();
	    CommandLine cmd= parser.parse(option,args);
	   // str=cmd.getArgs()[0];

		/*prints the help message here*/
	       if((cmd.hasOption("hp"))||(cmd.hasOption("hlp"))) {
	          System.out.println("this program gets an argument through commandline 'n' number of books. then reads n books from standard input"
	                             +"and prints them on standard output");
		//str=cmd.getArgs()[0];
		 if(cmd.getArgs()[0].isEmpty()){

		        //prints message if user not gives value of n
       			 System.out.println("you not give value of n:");
			 System.exit(0);}
                  }
		str=cmd.getArgs()[0];
	        n=Integer.parseInt(str);

            }catch(Exception e){

	    //if any erroy occurs it catches here
	     System.out.println(e);
	     }


	if(str.isEmpty()){

	//prints message if user not gives value of n
	System.out.println("you not give value of n");
	System.exit(0);
	}

	int num=0;
	Scanner sc1=new Scanner(System.in);		/*create an instance of scanner object*/
	Scanner sc=new Scanner(System.in);

	CmdBook b[]=new CmdBook[n];                	/* create arraylist of objects of class Book*/
	for(int i=0;i<n;i++){
	
	//
	b[i]=new CmdBook();
	}
	for(int i=0;i<n;i++){ 

	/* take input from  standard input*/
	 System.out.println("enter the title of the book:");
	 title1=sc.next();

	 System.out.println("enter the name of publisher");
	 publisher_name1=sc.next();

	 System.out.println("enter published date");
	 published_date1=sc.next();

	 System.out.println("how many authors are");
	 num=sc1.nextInt();

	ArrayList<String> author_name1=new ArrayList<String>();		/*create an ArrayList author_name1 */

	for(int j=0;j<num;j++) {

	/*take input */
	 System.out.println("enter authorname"+(j+1));
	 author_name1.add(sc.next());
	}

	System.out.println("enter contents of book:");
        content1=sc.next();

	/* call the method bookdetail with auguments which contains from
	*  standard input 
	*/

	b[i].bookdetail(title1, publisher_name1, published_date1,content1, author_name1);


   }
        for(int i=0;i<n;i++){

	/*call the methode printbook withe no aurgument*/
	b[i].printbook();
	}
}		/*end of main function here*/

/* bookdetail method gets the book details and save in the respective variables*/
public void bookdetail(String tit , String pub, String dat, String cont, ArrayList<String> aut) {
  
  title=tit;
  publisher_name=pub;
  published_date=dat;
  author_name.addAll(aut); 
  content=cont;
  
}	/*bookdetail method ends here*/



	/*printbook method prints the n book details 
	* on the standard output
	*/
 	public void printbook()
	{
	  
	  
	  System.out.println("Title:            "+title);
	  System.out.println("publisherName:    "+publisher_name);
	  System.out.println("publisher_date:   "+published_date);
	  System.out.println("Authors name:     ");
	  for(int j=0;j<author_name.size();j++) {
	    System.out.println("                  "+author_name.get(j));
          }
	 System.out.println("content of book:"+content);
	 System.out.println("");
	}


}	/*here ends Book class*/
