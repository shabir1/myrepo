/*
*read values from file and create 'n' Students
*/
package com.shabir;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Student {

    String title;
    String publisher_name;
    String published_date;
    String authors;
    String content;

   /* this function creates n student objects 
    *these n objects reads from file
   */
    void StudentCreate(){
        ArrayList<Student> students=new ArrayList<Student>();		//creates ArrayList of objects
        try{
	    CSVReader reader=new CSVReader(new FileReader("test.csv")); //creates CSVReader object
	    String[] nextLine;
	    while((nextLine=reader.readNext()) !=null){			//checks condition when file goes empty it goes out of while loop
	       Student std=new Student();
	       std.title=nextLine[0];
	       std.publisher_name=nextLine[1];
	       std.published_date=nextLine[2];
	       std.authors=nextLine[3];
	       std.content=nextLine[4];
	       students.add(std);
            }
            reader.close();
        }catch(Exception exp){
             System.out.println(exp);
         }
        for(int i=0;i<students.size();i++){
            Student std2=new Student();
            std2=students.get(i);
            std2.printbook();
        }
    }

	//prints n student objects
        void printbook(){
	  System.out.println("Title:            "+title);
	  System.out.println("publisherName:    "+publisher_name);
	  System.out.println("publisher_date:   "+published_date);
	  System.out.println("Authors name:     "+authors);
	  System.out.println("content of book:"+content);
	} 
}
