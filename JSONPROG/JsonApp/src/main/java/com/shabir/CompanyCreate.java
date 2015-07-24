/**
 *@author:Shabir Ahmad
 *@Date:21-07-2015
 */
package com.shabir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * this is simple code for jsonTest
 * in this code we read from json file
 * and print at standard output
 */
public class CompanyCreate {
    String companyName;
    String companyAddress;
    String companySite;
    String companyUrl;
    String companyDirector;

    /**
     * this is an argument constractor
     * it takes jason file path as argument
     * @param path
     */
        public void CompanyCreate(String path) {
        CompanyCreate companyCreate = new CompanyCreate();

        companyCreate.Create(path);
    }

    /**
     * this method takes JASON file path as argument
     * then reads objects from json file
     * then creates 'n' companies
     * @param path
     */
    public void Create(String path) {

        CompanyCreate[] companyCreates = new CompanyCreate[5];
        try {

            FileReader reader = new FileReader(path);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            //get an array from json object
            JSONArray companysArray = (JSONArray) jsonObject.get("ncompanys");

            //take the elements of the json array
            Iterator i = companysArray.iterator();

            int j=0;
            // take each value from the json array separately
            while(i.hasNext()) {

                JSONObject innerObject = (JSONObject) i.next();

                companyCreates[j] = new CompanyCreate();
                System.out.println((j+1) +" company details:");

                companyCreates[j].companyName = (String) innerObject.get("Name");
                System.out.println(companyCreates[j].companyName);

                companyCreates[j].companyAddress = (String) innerObject.get("Address");
                System.out.println(companyCreates[j].companyAddress);

                companyCreates[j].companyDirector = (String) innerObject.get("Director");
                System.out.println(companyCreates[j].companyDirector);

                companyCreates[j].companySite = (String) innerObject.get("Site");
                System.out.println(companyCreates[j].companySite);

                companyCreates[j].companyUrl = (String) innerObject.get("URL");
                System.out.println(companyCreates[j].companyUrl);

                j++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
