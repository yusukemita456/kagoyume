/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author user2
 */
public class UserDataDAO {
    
    
   public static UserDataDAO getInstance(){
       return new UserDataDAO();
       
   }
   
   
   public void insert(UserDataDTO ud ) throws SQLException{
       
       
       
       
   }
   
   
   
//ログイン処理 
 public  UserDataDTO Search(UserDataDTO udb) throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
          
          con = DBManager.getConnection();
          st = con.prepareStatement("select * from userlogin  where  userID = ? ");
          st.setInt(1,udb.getUserID());
          

          rs = st.executeQuery();
          UserDataDTO resultUd = new UserDataDTO();
          if(!rs.next()){
              return null;
          }else{
              resultUd.setUserID(rs.getInt("userID"));
          resultUd.setPassword(rs.getString("password"));
          }
          
          return resultUd;
          
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }      
       }
    }   
    
}
