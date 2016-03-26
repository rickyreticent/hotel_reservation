/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _controller;

import _db._DB;
import _model.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trisha
 */
public class AddRoom extends HttpServlet {

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
        _DB db = new _DB();
        Room r = new Room();

        try {
            String rmType = db.searchRoomName(request.getParameter("radRoom"));
            String rmNum = request.getParameter("txtRoomNum").trim();
            String smoke = request.getParameter("radSmoke");
            String specs = request.getParameter("txtSpecs");
            String rmSpecs = smoke + "\n" + specs;
            String add = request.getParameter("btnAdd");

            if(rmNum.isEmpty()){
                inputError(request, response, "A room number must be entered");
            }
            if (add != null && rmType != null) {
                int num = Integer.parseInt(rmNum);
                r.setRoomID(num);
                r.getRt().setRoomName(rmType);
                r.setRoomSpec(rmSpecs);
                db.addRoom(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("admin/adminViewRooms.jsp");
        rd.forward(request, response);

    }

    private void inputError(HttpServletRequest req, HttpServletResponse res, String msg) {
        try {
            try (PrintWriter out = res.getWriter()) {
                res.setContentType("text/html");
                out.println("<html><head>"
                        + " <title>Hotel</title></head><body>");
                out.println("<div id='warning'>" + msg + "</div>");
                ServletContext sc = getServletConfig().getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/admin/adminAddRoom.jsp");
                rd.include(req, res);
                out.println("</body></html>");
            }
        } catch (ServletException | IOException e1) {
            e1.printStackTrace();
        } finally {

        }
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
