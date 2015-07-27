/**
 *@authour: Shabir Ahmad Bhat
 *@Date: 15/07/2015
 */
package com.cvs.con;

import com.opencsv.bean.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import java.io.Serializable;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * read objects from file and create 'n' Students,
 * then Serialize those objects into file,
 * Deserialize
 */
public class Student implements Serializable {
    String  bookTitle;
    String  publisherName;
    String  publishedDate;
    String  bookAuthor;
    String  bookContent;
    
    // array list used to create objects  of Student
    ArrayList<Student> students=new ArrayList<Student>();

    /**
     * method used to read objects from file then create 'n' students
     * Serialize those objects into file
     * Deserialize
     */
   public void createStudentObject() {

        try {

            CSVReader reader = new CSVReader(new FileReader("data2.csv"));
            String[] nextLine;
            while(( nextLine =reader.readNext())!=null) {
                Student student = new Student();
                student.bookTitle=nextLine[0];
                student.publisherName=nextLine[1];
                student.publishedDate=nextLine[2];
                student.bookAuthor=nextLine[3];
                student.bookContent=nextLine[4];
                students.add(student);
            }
            reader.close();
        }
        catch(Exception e) {
             System.out.println(e);
        }
        try {

            // used to write objects in file
            FileOutputStream fileOut = new FileOutputStream("abc.txt");

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(students);                //serialize object 
            objectOut.close();
            fileOut.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        try {

            // used to retrive object data from file
            FileInputStream filein = new FileInputStream("abc.txt");

            ObjectInputStream objectin = new ObjectInputStream(filein);

            System.out.println(objectin.readObject().toString());     //deserialize object
            objectin.close();
            filein.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    //converts object data to string
    public String toString() {

       return "book detail: [" +"title:"+ bookTitle +","+"publisher Name: "+
               publisherName +","+"published date: "+  publishedDate +","  +
               "book authors: " + bookAuthor +","+"contents of book:" +
               bookContent +"]";
    }
}
