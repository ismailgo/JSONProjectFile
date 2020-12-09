/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonproject;

import Connection.connexionDB;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class MainJson {

    public static void main(String[] args) {

        //inline will store the JSON data streamed in string format
        String inline = "";
        connexionDB cn;
        String Sql;
        Statement stat;
        int rs;
        try {
            try {
                File myObj = new File(".\\focus_api.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();

                    inline = inline + data;

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println(inline);
            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser parse = new JSONParser();
            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject) parse.parse(inline);
            //Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
            JSONArray jsonarr_1 = (JSONArray) jobj.get("data");
            //Get data for Results array
            for (int i = 0; i < jsonarr_1.size(); i++) {
				//Store the JSON objects in an array
                //Get the index of the JSON object and print the values as per the index
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
				//Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
				/*JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("id");
                 System.out.println("Elements under results array");
                 System.out.println("\nPlace id: " +jsonobj_1.get("employee_age"));
                 System.out.println("Types: " +jsonobj_1.get("employee_name"));
                 //Get data for the Address Components array
                 System.out.println("Elements under address_components array");
                 System.out.println("The long names, short names and types are:");
                 */
                String id = (String) jsonobj_1.get("id");
                System.out.println("id : " + id);
                String employee_age = (String) jsonobj_1.get("employee_age");
                System.out.println("employee_age : " + employee_age);
                String employee_name = (String) jsonobj_1.get("employee_name");
                String employee_salary = (String) jsonobj_1.get("employee_salary");
                System.out.println("employee_name : " + employee_name);
                System.out.println("employee_salary : " + employee_salary);
                System.out.println("\n");
                                    // cn=new connexionDB();

                /*
                 Sql ="begin ATMI_INTERF_IMPORT_GPS("+id+",'"+name+"',"+age+","+salaire+"); commit;end;";
    
                 stat = cn.Obtenirconnexion().createStatement();
      
                 rs=stat.executeUpdate(Sql);*/
                                     //cn.EXP_DATA(id, name, age, salaire);
                /*for(int j=0;j<jsonarr_2.size();j++)
                 {
                 //Same just store the JSON objects in an array
                 //Get the index of the JSON objects and print the values as per the index
                 JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
                 //Store the data as String objects
                 String str_data1 = (String) jsonobj_2.get("id");
                 System.out.println(str_data1);
                 String str_data2 = (String) jsonobj_2.get("employee_name");
                 System.out.println(str_data2);
                 System.out.println(jsonobj_2.get("employee_age"));
                 System.out.println("\n");
                 }*/
            }
			//Disconnect the HttpURLConnection stream
            //conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
