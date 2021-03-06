/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import databaseJeff.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeff_2
 */
public class Login extends HttpServlet {

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
        RequestDispatcher rd;
        String usnm = request.getParameter("user_name").trim();
        String psw = request.getParameter("password").trim();
        String submit = request.getParameter("submit");
        int cID;
        String error = null;
        boolean isValid;

        try {
            Database db = Database.getDatabase();
            if (!usnm.isEmpty() && !psw.isEmpty()) {

                if (submit.equals("Login")) {
                    isValid = db.validateUser(usnm, psw);
                    cID = db.getUserID(usnm, psw);
                    if (isValid) {

//                    if (cID == -1) {
//                        rd = request.getRequestDispatcher("userRegister.jsp");
//                        rd.forward(request, response);                   
                        if (cID == 9999) {
                            rd = request.getRequestDispatcher("adminViewRooms.jsp");
                            rd.forward(request, response);
                        } else {
                            HttpSession session = request.getSession();
                            session.setAttribute("cID", cID);
                            session.setAttribute("username", usnm);
                            rd = request.getRequestDispatcher("userViewR.jsp");
                            rd.forward(request, response);
                        }
                    }
                    error = "Invalid username or password";

                }
            } else {
                error = "Please enter empty fields.";
            }
            request.setAttribute("error", error);
            rd = request.getRequestDispatcher("userLogin.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
        }

//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println(psw);
//            out.println(usnm);
//            out.println(cID);
//            out.println("</body>");
//            out.println("</html>");
//        }
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
