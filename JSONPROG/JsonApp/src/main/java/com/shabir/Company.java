/**
 * @author: Shabir Ahmad
 * @Date: 21-07-2015
 */
package com.shabir;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.FileReader;
import java.io.FileWriter;

import java.lang.String;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *  Create 5 company Objects and Write  into JSON file
 */
public class Company {
    String companyName;
    String companyAddress;
    String companySite;
    String companyUrl;
    String companyDirector;

    /**
     * this method creates 'n' company objects
     * then put company detail in json object
     * then writes in a jsonobject file
     */
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        Company[] companys = new Company[5];


        JSONObject jsonObject = new JSONObject();
        JSONArray companysArray = new JSONArray();

        try {
            for (int i = 0; i < 5; i++) {

                JSONObject jsonObject2 = new JSONObject();

                //takes n inputs from user
                companys[i] = new Company();
                System.out.println("enter " + (i+1) + ": company name");
                companys[i].companyName = scanner.nextLine();

                System.out.println("enter " + (i+1) + ": company Address");
                companys[i].companyAddress = scanner.nextLine();

                System.out.println("enter " + (i+1) + ": company Director");
                companys[i].companyDirector = scanner.nextLine();

                System.out.println("enter " + (i+1) + ": company URL");
                companys[i].companyUrl = scanner.nextLine();

                System.out.println("enter " + (i+1) + ": company site");
                companys[i].companySite = scanner.nextLine();


                jsonObject2.put("Name", companys[i].companyName);
                jsonObject2.put("Address", companys[i].companyAddress);
                jsonObject2.put("Director", companys[i].companyDirector);
                jsonObject2.put("Site", companys[i].companySite);
                jsonObject2.put("URL", companys[i].companyUrl);


                companysArray.put(jsonObject2);


            }

            jsonObject.put("ncompanys", companysArray);

        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        try {

            //creates filewriter object used for to write json object on file
            FileWriter jsonFileWriter = new FileWriter("companyJsonTestFile.json");


            jsonFileWriter.write(jsonObject.toString(2));
            jsonFileWriter.flush();
            jsonFileWriter.close();

            System.out.println("JSONObject file: ");
            System.out.println(jsonObject.toString(2));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //create object of companycreate class that class reads json object
         CompanyCreate companycreate = new CompanyCreate();
         companycreate.CompanyCreate("companyJsonTestFile.json");


    }

}
