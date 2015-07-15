/*
*create 'n' objects of Book and
*Write those n objects into File in "Comma Separated Values(CSV)" format.
* read those values from file and create 'n' Students
*/
package com.shabir;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Book implements Serializable {
    String title;
    String publisher_name;
    String published_date;
    String content="";
    ArrayList<String> author_name=new ArrayList<String>();
    public static void main(String args[]){

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
	    title1=sc.nextLine();

	    System.out.println("enter the name of publisher");
	    publisher_name1=sc.nextLine();

	    System.out.println("enter published date");
	    published_date1=sc.nextLine();

	    System.out.println("how many authors are");
	    num=sc1.nextInt();

	    ArrayList<String> author_name1=new ArrayList<String>();		/*create an ArrayList author_name1 */

	    for(int j=0;j<num;j++) {

	        /*take input */
	        System.out.println("enter authorname"+(j+1));
	        author_name1.add(sc.nextLine());
	    }

	    System.out.println("enter contents of book:");
            content1=sc.nextLine();

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

      //try block
       try{
           // creates a CSVWriter object
           CSVWriter writer=new CSVWriter(new FileWriter("test.csv"));
           for(int i=0;i<objbook.size();i++){
 
	   /*call the methode printbook withe no aurgument*/
               Book b2=new Book();
	       b2=objbook.get(i);
               String str2="";
               String str=b2.getTitle();
               str=str.concat(",");
               str2=b2.getPublisher();
               str=str.concat(str2);
               str=str.concat(",");
               str2=b2.getdate();
               str=str.concat(str2);
               str=str.concat(",");
               str2=b2.getAuthor();
               str=str.concat(str2);
               str=str.concat(",");
               str2=b2.content();
               str=str.concat(str2);
               String[] str3=str.split(",");
               writer.writeNext(str3);          //writes book detail in test.csv file
           }
           writer.close();  //file close
           }catch(Exception e){
	       System.out.println(e);
	   }

           /*
           *this block serialize the arraylist of objects of class book
           */
	   try {
	       FileOutputStream fileout=new FileOutputStream("objects.txt");
               ObjectOutputStream out=new ObjectOutputStream(fileout);
               out.writeObject(objbook);
               out.close();
               fileout.close();
               System.out.println("object  serialize");
           }catch(Exception exptn){
                System.out.println(exptn);
            }
         try {
               FileInputStream filein=new FileInputStream("objects.txt");
               ObjectInputStream in=new ObjectInputStream(filein);
               System.out.println("Deserialized Data:\n" +in.readObject().toString());

               in.close();
               filein.close();
          }catch(Exception ee) {
               System.out.println(ee);
           }
         //creates object of Student class then call studentcreate method of student
         Student student=new Student();
         student.StudentCreate();
    }		/*end of main function here*/


public String toString(){
    return "book [title=" +title +", publisher_name=" + publisher_name +", published_date=" + published_date + ",author_name=" +author_name + "content=" +content +"]";
}
/* bookdetail method gets the book details and save in the respective variables*/
public void bookdetail(String tit , String pub, String dat, String cont, ArrayList<String> aut) {
  title=tit;
  publisher_name=pub;
  published_date=dat;
  author_name.addAll(aut);
  content=cont;
}	/*bookdetail method ends here*/



	/*getTitle method gets the  book title
	* and returns
	*/
       String getTitle(){
           return title;
       }

       /*getPublisher method gets the  book publisher_name
        * and returns
        */
       String getPublisher(){
           return publisher_name;
       }
        /*getdate method gets the  book published_date
        * and returns 
        */

       String getdate(){
           return published_date;
       }
       /*getAuthor method gets the  book Authours name
        * and returns
        */

       String getAuthor(){
           String str="";
           for(int j=0;j<author_name.size();j++) {
               str=str.concat(author_name.get(j));
	       str= str.concat(" ");
           }
           return str;
       }
        /*getcontent method gets the content of book
        * and returns 
        */

      String content(){
          return content;
      }

}
