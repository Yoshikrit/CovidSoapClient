/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsoapclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import services.Coviddatabase;

/**
 *
 * @author acer
 */
public class CovidSoapClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        jsonGet();
        List <Coviddatabase> covidList = findAllCovid();
        printAllCovid(covidList);
    }
    
    public static void jsonGet()throws Exception {
        URL obj = new URL("https://covid19.ddc.moph.go.th/api/Cases/today-cases-all");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            String json = response.toString();
            //System.out.println(json);
            
            JsonReader jsonr = Json.createReader(new StringReader(json));
            JsonArray jsona = jsonr.readArray();
            jsonr.close();
            
            System.out.println(jsona);
            
            JsonObject firstname = jsona.getJsonObject(0);
            
            int year = firstname.getInt("year");
            System.out.println(year);
            
            int weeknum = firstname.getInt("weeknum");
            System.out.println(weeknum);
            
            int new_case = firstname.getInt("new_case");
            System.out.println(new_case);
            
            int total_case = firstname.getInt("total_case");
            System.out.println(total_case);
            
            int new_case_excludeabroad = firstname.getInt("new_case_excludeabroad");
            System.out.println(new_case_excludeabroad);
            
            int total_case_excludeabroad = firstname.getInt("total_case_excludeabroad");
            System.out.println(total_case_excludeabroad);
            
            int new_recovered = firstname.getInt("new_recovered");
            System.out.println(new_recovered);
            
            int total_recovered = firstname.getInt("total_recovered");
            System.out.println(total_recovered);
            
            int new_death = firstname.getInt("new_death");
            System.out.println(new_death);
            
            int total_death = firstname.getInt("total_death");
            System.out.println(total_death);
            
            int case_foreign  = firstname.getInt("case_foreign");
            System.out.println(case_foreign);
            
            int case_prison = firstname.getInt("case_prison");
            System.out.println(case_prison);
            
            int case_walkin = firstname.getInt("case_walkin");
            System.out.println(case_walkin);
            
            int case_new_prev = firstname.getInt("case_new_prev");
            System.out.println(case_new_prev);
            
            int case_new_diff = firstname.getInt("case_new_diff");
            System.out.println(case_new_diff);
            
            int death_new_prev = firstname.getInt("death_new_prev");
            System.out.println(death_new_prev);
            
            int death_new_diff = firstname.getInt("death_new_diff");
            System.out.println(death_new_diff);
            
            String update_date = firstname.getString("update_date");
            System.out.println(update_date);
            
            
            addDatabase(year,weeknum,new_case,total_case,new_case_excludeabroad,total_case_excludeabroad,new_recovered,total_recovered,new_death,total_death,case_foreign,case_prison,case_walkin,case_new_prev,case_new_diff,death_new_prev,death_new_diff,update_date);
            System.out.println("lol");
        } else {
            System.out.println("GET request did not work.");
        }
    }
    
    public static void addDatabase(int year,int weeknum,int new_case,int total_case,int new_case_excludeabroad,int total_case_excludeabroad,int new_recovered,int total_recovered,int new_death,int total_death,int case_foreign,int case_prison,int case_walkin,int case_new_prev,int case_new_diff,int death_new_prev,int death_new_diff, String update_date){
        Coviddatabase c = new Coviddatabase(year,weeknum,new_case,total_case,new_case_excludeabroad,total_case_excludeabroad,new_recovered,total_recovered,new_death,total_death,case_foreign,case_prison,case_walkin,case_new_prev,case_new_diff,death_new_prev,death_new_diff, update_date);
        System.out.println("hi");
        insertCovid(c);
    }
    
    public static void printAllCovid(List <Coviddatabase> colist){
        for(Coviddatabase c : colist){
            System.out.println("year : " + c.getCovidyear());
            System.out.println("weeknum : " + c.getWeeknum());
            System.out.println("new case : " + c.getNewCase());
            System.out.println("total case : " + c.getTotalCase());
            System.out.println("new case exclude abroad : " + c.getNewCaseExcludeabroad());
            System.out.println("total case exclude abroad : " + c.getTotalCaseExcludeabroad());
            System.out.println("new recovered : " + c.getNewRecovered());
            System.out.println("total recovered : " + c.getTotalRecovered());
            System.out.println("new death : " + c.getNewDeath());
            System.out.println("total death : " + c.getTotalDeath());
            System.out.println("case foreign : " + c.getCaseForeign());
            System.out.println("case prison : " + c.getCasePrison());
            System.out.println("case walkin : " + c.getCaseWalkin());
            System.out.println("case new prev : " + c.getCaseNewPrev());
            System.out.println("case new diff : " + c.getCaseNewDiff());
            System.out.println("death new prev : " + c.getDeathNewPrev());
            System.out.println("death new diff : " + c.getDeathNewDiff());
            System.out.println("update date : " + c.getUpdateDate());
            System.out.println();
        }
    }

    private static java.util.List<services.Coviddatabase> findAllCovid() {
        services.CovidWebService_Service service = new services.CovidWebService_Service();
        services.CovidWebService port = service.getCovidWebServicePort();
        return port.findAllCovid();
    }

    private static void insertCovid(services.Coviddatabase co) {
        services.CovidWebService_Service service = new services.CovidWebService_Service();
        services.CovidWebService port = service.getCovidWebServicePort();
        port.insertCovid(co);
    }
    
}
