/*
* Book
*this program reads n books from standard input and print them on standard output.
*
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

/*this is the this class Book
*
*/
public class Book {
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
	int n=-1;
	int num=1;
		Scanner sc1=new Scanner(System.in);		/*create an instance of scanner object*/
		Scanner sc=new Scanner(System.in);
                ArrayList<Book> objbook=new ArrayList<Book>();	/* create arraylist of objects of class Book*/
	int choice=0;
 
	do{
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
        Book b1=new Book();
	objbook.add(b1);
	b1.bookdetail(title1, publisher_name1, published_date1,content1, author_name1);

	System.out.println("you want to continue then press 1 otherwise enter any number");
	choice=sc1.nextInt();
	n++;
   }while(choice==1);
        for(int i=0;i<=n;i++){

	/*call the methode printbook withe no aurgument*/
        Book b2=new Book();
	b2=objbook.get(i);
	b2.printbook();
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
