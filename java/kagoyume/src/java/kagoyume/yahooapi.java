/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;




/**
 *
 * @author user2
 */
public class yahooapi {
    
    private static String APP_ID = "dj0zaiZpPUpWdVNPS1VzREFncCZzPWNvbnN1bWVyc2VjcmV0Jng9NGM-"; //APPID
    private static String BASE_URI = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch"; //Yahoo!! shopping url
    
    public static yahooapi getInstance (){
    return new yahooapi();
}    
    
    
    public static ArrayList<itembeans> DataBindingParse(String searchProduct) throws UnsupportedEncodingException{
        
        SearchResultData srd = new SearchResultData();
        srd.setSearchProduct(searchProduct);
        ArrayList<itembeans> arry = new ArrayList<itembeans>();
        String encodProduct = URLEncoder.encode(searchProduct,"UTF-8");
        try{
            
            
            String Json = connect(encodProduct);//jsonから情報を取得
            
            ObjectMapper m = new ObjectMapper();
            JsonNode rootNode = m.readTree(Json);
            JsonNode resultSet= rootNode.get("ResultSet");
            JsonNode resultSetNext= resultSet.get("0");
            int totalResultsReturned = resultSet.get("totalResultsReturned").asInt();//検索数をjsonから取得
            srd.setResultNum(totalResultsReturned);//検索数をbeansに格納
            JsonNode Result = resultSetNext.get("Result");
            
            
            
            for(int i = 0;i < srd.getResultNum();i++){
                
             itembeans ibs = new itembeans();  
             JsonNode  productInfo = Result.get(String.valueOf(i));

             ibs.setName(productInfo.get("Name").asText()); 
             ibs.setDescription(productInfo.get("Description").asText());
             ibs.setHeadline(productInfo.get("Headline").asText());
             ibs.setCode(productInfo.get("Code").asText());
             ibs.setImage(productInfo.get("Image").get("Medium").asText());
             ibs.setPrice(productInfo.get("Price").get("_value").asInt());
             arry.add(ibs);
             
            }
            
            
            
        }catch(Exception e){
            
        }
        return arry;
                
    }
    
    public static String connect(String searchProduct) {
       
        URL url;
        
        try{
            url = new URL (BASE_URI + "?appid=" + APP_ID + "&query=" + searchProduct);
            
            HttpURLConnection urlcon = (HttpURLConnection)url.openConnection();
            urlcon.setRequestMethod("GET");
//            urlcon.setInstanceFollowRedirects(false);
            
            urlcon.connect();
            
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            
            StringBuffer responseBuffer = new StringBuffer();
            while(true){
                String line = reader.readLine();
                if(line == null){
                    break;
                }responseBuffer.append(line);
            }
            reader.close();
            urlcon.disconnect();
             return responseBuffer.toString();
            
           
            
        }catch(Exception e){
            
            
            
        }
        return null;
    }
    
}
