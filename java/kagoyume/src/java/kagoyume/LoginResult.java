/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kagoyume;

/**
 *
 * @author user2
 */
import base.UserData;
import base.UserDataDTO;
import base.UserDataDAO;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author user2
 */

@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        
        try {

            int userID = Integer.parseInt(request.getParameter("userID"));
            String pass = request.getParameter("pass");
            String btn = request.getParameter("btn");
            
            UserDataDTO searchData = new UserDataDTO();         

            searchData.setUserID(userID);
            searchData.setPassword(pass);
            
             UserDataDTO resultData = UserDataDAO .getInstance().Search(searchData);
             
             boolean login = (resultData != null && userID == (resultData.getUserID()) && pass.equals(resultData.getPassword()));
             UserData ud = new UserData();
             
             
            if(btn.equals("ログイン")){
                
                if(login){
                 session.setAttribute("resultData", resultData);
                 request.getRequestDispatcher("/loginresult.jsp").forward(request,response);
                 
             }else{
                 request.setAttribute("error", "名前とパスワードが間違えています。");
                 request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else if(btn.equals("ログアウト")){
                session.removeAttribute("resultData");
                request.getRequestDispatcher("/top.jsp");

            }else if(btn.equals("購入履歴")){
             
                
                
            }
             
             
        }catch(Exception e){
             request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
