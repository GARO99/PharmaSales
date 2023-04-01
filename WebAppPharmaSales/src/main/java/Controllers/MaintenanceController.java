/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.CustomersDAO;
import Models.Customers;
import Utils.Constants.NavConstans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PERSONAL
 */
public class MaintenanceController extends HttpServlet {
    
    Customers cu = new Customers();
    CustomersDAO cdao = new CustomersDAO();
    
    private NavConstans NavEnum;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request HttpServlet request
     * @param response HttpServlet response
     * @throws ServletException if a HttpServlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cu", null);
        String action = request.getParameter("action");
        switch (action) {
            case NavConstans.PRODUCTS_MAINTENANCE:
                request.getRequestDispatcher("maintenanceview/products.jsp").forward(request, response);
                break;
            case NavConstans.CUSTOMERS_MAINTENANCE:
                request.getRequestDispatcher("maintenanceview/customers.jsp").forward(request, response);
                break;
            case NavConstans.EMPLOYEES_MAINTENANCE:
                request.getRequestDispatcher("maintenanceview/employees.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request HttpServlet request
     * @param response HttpServlet response
     * @throws ServletException if a HttpServlet-specific error occurs
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
     * @param request HttpServlet request
     * @param response HttpServlet response
     * @throws ServletException if a HttpServlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String search = request.getParameter("searchCustomer");
        if (search.equalsIgnoreCase("search")) {
            String idType = request.getParameter("idType");
            String idNumber = request.getParameter("idNumber");
            cu = cdao.getCustomer(idNumber, idType);
            if (cu.getIDENTIFICATION_NUMBER_CUSTOMER() != null) {
                request.setAttribute("cu", cu);
            } else {
                response.sendError(0, "User not found");
            }
        }else {
            response.sendError(0, "User not found");
        }
        request.getRequestDispatcher("salesview/new.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the HttpServlet.
     *
     * @return a String containing HttpServlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}