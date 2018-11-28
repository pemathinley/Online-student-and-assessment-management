/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class registerationS extends HttpServlet {

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
        
         
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("username");  
String b=request.getParameter("pass");  
String c=request.getParameter("repass");  
String d=request.getParameter("dob");  
String e=request.getParameter("gender");  
String f=request.getParameter("parentN");  
String g=request.getParameter("email"); 
String h=request.getParameter("contact");
String j=request.getParameter("city");
String k=request.getParameter("state");


try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register?useSSL=true&verifyServerCertificate=false&allowMultiQueries=true","root","pema1998");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into userreg values(?,?,?,?,?,?,?,?,?,?)");  
 
PreparedStatement ps1=con.prepareStatement(  
"insert into login values(?,?)"); 
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c); 
ps.setString(4,d); 
ps.setString(5,e); 
ps.setString(6,g); 
ps.setString(7,h);
ps.setString(8,j);
ps.setString(9,k);
ps.setString(10,f);


ps1.setString(1,a);
ps1.setString(2,b);     


int i=ps.executeUpdate();  

int p=ps1.executeUpdate();
if(i>0)  
{
RequestDispatcher rd=request.getRequestDispatcher("login.html");  
        rd.forward(request,response);  
      
}         
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
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


