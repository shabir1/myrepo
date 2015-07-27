/**
 *@author: Shabir Ahmad Bhat
 *
 */
package com.cvs.con;

import com.opencsv.bean.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

import org.apache.commons.cli.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 *Create 'n' Book objects and
 *Write those n objects into File in "Comma Separated Values(CSV)" format.
 */
public class Book {
    String bookTitle;
    String bookPublisherName;
    String bookPublishedDate;
    ArrayList<String> bookAuthourNames = new ArrayList<String>();
    String bookContent;

    /**
     * this method takes input book details as argument
     *then sets the input data
     */
    public void setData(String bookTitle , String bookPublisherName,
                        String bookPublishedDate , 
                        ArrayList<String> bookAuthourNames, String bookContent) {

	    this.bookTitle = bookTitle;
	    this.bookPublisherName = bookPublisherName;
        this.bookPublishedDate = bookPublishedDate;
	    this.bookAuthourNames.addAll(bookAuthourNames);
        this.bookContent = bookContent;
    }

    /**
     *from this method we get data
     */
    public String[] getData() {
        String[] strings = new String[5];
        String tempString = "";

        for(int k=0;k<bookAuthourNames.size();k++) {
            tempString = tempString.concat(bookAuthourNames.get(k) + " ");
        }
        strings[0] = bookTitle;
        strings[1] = bookPublisherName;
        strings[2] = bookPublishedDate;
        strings[3] = tempString;
        strings[4] = bookContent;

        return strings;
    }

          /**
           * Create 'n' Book objects and
           * Write those n objects into File in "Comma Separated Values(CSV)" format.
           */
    public static void main(String args[]) {
	    Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
	    int nObjects=0;
        String arguementString="";

        try {
            Options option = new Options();
	        option.addOption("k",false,"does not required");
            option.addOption("y",false,"does not required");
            CommandLineParser parser = new DefaultParser();
	        CommandLine cmd = parser.parse(option,args);

            if((cmd.hasOption("k"))||(cmd.hasOption("y"))) {

	            //if option is y or k help message is printed
		        System.out.println("the proram contains class book on which"
                                    +"we can genrate n books whose description"
                                    +" is given by user in standard input and "
			                        +"the output is also send to standard output");

                arguementString = cmd.getArgs()[0];

                if(arguementString.isEmpty()){

                    // when there are no command line arguments
                    System.out.println("u have not entered any thing");
		            System.exit(0);
                }

            }
            arguementString = cmd.getArgs()[0];

            //parsing string into integer
            nObjects= Integer.parseInt(arguementString);
       	}
        catch(Exception e) {

             //exception caught
	         e.printStackTrace();
        }

        if(arguementString.isEmpty()) {
            System.out.println("u have not entered any thing");
        }

        Book book[] = new Book[nObjects]; //n Objects is supplied in arguments

        for(int l = 0; l < nObjects; l++) {
          
           //i create a object of Book class
            book[l] = new Book();
        }


	    int i,j;	// itterating variables
	    String bookTitle1;
	    String bookPublisherName1;
        String bookPublishedDate1;
        String bookContent1;

        for(i = 0; i < nObjects; i++) {

            //take inputs from user
	        System.out.println("Enter the detail of Book no "+ (i+1));
            System.out.println("Enter Book Title"+ (i+1));
	        bookTitle1 =scanner.nextLine();
            System.out.println("Enter Book Publisher Name"+ (i+1));
            bookPublisherName1 = scanner.nextLine();
	        System.out.println("Enter Book Published Date"+ (i+1));
	        bookPublishedDate1 = scanner.nextLine();
	        System.out.println("Enter no. of Authors of book"+(i+1));
	        int nAuthors;
	        nAuthors = scanner1.nextInt();
            ArrayList<String> bookAuthor1 = new ArrayList<String>();

            for(j = 0; j < nAuthors; j++) {

		        System.out.println("enter the author name"+ (j+1));
		        bookAuthor1.add(scanner.nextLine());
	        }
	        System.out.println("enter the content of book"+ i+1);
            bookContent1 = scanner.nextLine();
	        book[i].setData(bookTitle1, bookPublisherName1, bookPublishedDate1,
                             bookAuthor1, bookContent1);

	    }
        try {

              // object writer of class Writer used to write on file data2
             CSVWriter writer = new CSVWriter(new FileWriter("data2.csv"));

             for (i = 0; i < nObjects; i++) {

	              String[] arrayString = book[i].getData();
                  writer.writeNext(arrayString);  //writes records into data2.csv file
             }
             writer.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

        Student student = new Student();//object of class Student is created
        student.createStudentObject();  //calling function studentData of Student class
	}

}

