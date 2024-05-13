/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.jakartaee.bcel.classfile.FieldOrMethod;

/**
 *
 * @author MY PC
 */
@WebServlet(name="regis", urlPatterns={"/regis"})
public class Login extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doPost(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option_ChuaXuLy = request.getParameter("option");
        String ten_ChuaXuLy = request.getParameter("Name");
        String diaChi_ChuaXuLy = request.getParameter("Locate");
        String[] order_ChuaXuLy = request.getParameterValues("Order");
        String select_ChuaXuLy = request.getParameter("Select");
        PrintWriter out = response.getWriter();
        String ms="";
           if (ten_ChuaXuLy.equals("")){
               ms+="<h1 style=\"color:red\">Không được để trống Tên</h1>";}
        else{
       
            if(diaChi_ChuaXuLy.equals("")){
                ms+="<h1 style=\"color:red\">Không được để trống Địa Chỉ</h1>";
           }
           else{
               try {
               if (option_ChuaXuLy.equals("no")){
                ms+="<h1 style=\"color:red\">Chúng tôi không thể chấp nhận yêu cầu bạn</h1>";
                
               }
               else{
                    ms+= ten_ChuaXuLy+" ("+diaChi_ChuaXuLy+") -";
                    for (String Food:order_ChuaXuLy){
                        if (Food.equals("chicken")){
                                ms+="Ăn gà rán ";
    //
                            }
                        if (Food.equals("sugarcane")){
    //
                            if (ms.endsWith(" ")) ms+=",";
                            ms+="Uống nước mía ";

                        }
                        if (Food.equals("fruit")){

                            if (ms.endsWith(" ")) ms+=",";
                            ms+="Ăn hoa quả ";
    //
                            }
                        if (Food.equals("melon")){

                            if (ms.endsWith(" ")) ms+=",";                        
                            ms+="Ăn dưa hấu ";

                        }                    
                    }
                    ms+= " - "+select_ChuaXuLy;
                }
                } catch (Exception e) {
                    e.printStackTrace();}
           }            
        }
        
        out.append(ms);
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
