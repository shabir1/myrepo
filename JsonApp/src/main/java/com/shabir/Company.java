/**
 * @author: Shabir Ahmad
 * @Date: 21-07-2015
 */
package com.shabir;

import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
     * then writes in a json file
     */
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        Company[] companys = new Company[5];

        JSONObject jsonObject = new JSONObject();
        JSONArray companysArray = new JSONArray();
        for(int i = 0; i < 5; i++) {

            JSONObject jsonObject2 = new JSONObject();

            //takes n inputs from user
            companys[i] = new Company();
            System.out.println("enter " +i +"company name");
            companys[i].companyName=scanner.nextLine();

            System.out.println("enter " +i +"company Address");
            companys[i].companyAddress = scanner.nextLine();

            System.out.println("enter " +i +"company Director");
            companys[i].companyDirector = scanner.nextLine();

            System.out.println("enter " +i +"company URL");
            companys[i].companyUrl = scanner.nextLine();

            System.out.println("enter " +i +"company site");
            companys[i].companySite = scanner.nextLine();


            jsonObject2.put("Name", companys[i].companyName);
            jsonObject2.put("Address", companys[i].companyAddress);
            jsonObject2.put("Director", companys[i].companyDirector);
            jsonObject2.put("Site", companys[i].companySite);
            jsonObject2.put("URL", companys[i].companyUrl);


            companysArray.add(jsonObject2);

        }

        jsonObject.put("ncompanys",companysArray);

        try {

            //creates filewriter object used for to write json object on file
            FileWriter jsonFileWriter = new FileWriter("companyJsonTestFile.json");

            ObjectMapper mapper = new ObjectMapper();
            jsonFileWriter.write(jsonObject.toJSONString());
            jsonFileWriter.flush();
            jsonFileWriter.close();

            System.out.println(jsonObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //create object of companycreate class that class reads json object
         CompanyCreate companycreate = new CompanyCreate();
        companycreate.CompanyCreate1("companyJsonTestFile.json");


    }




}
