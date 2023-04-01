/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.CustomersDAO;
import DAO.ProductsDAO;
import Models.Customers;
import Utils.Constants.NavConstans;
import java.io.IOException;
import java.sql.Date;
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
    ProductsDAO pdao = new ProductsDAO();

    String disabled = "disabled";
    String act = "";
    String msg = "­­ ";

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
        request.setAttribute("disabled", disabled);
        request.setAttribute("act", act);
        request.setAttribute("msg", msg);
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
        String add = request.getParameter("add");
        String update = request.getParameter("update");
        String change = request.getParameter("change");

        if (add != null) {
            switch (add) {
                case "products":
                    String code = request.getParameter("code");
                    String name = request.getParameter("name");
                    String iva = request.getParameter("iva");
                    String price = request.getParameter("price");
                    String beginDate = request.getParameter("beginDate");
                    String endDate = request.getParameter("endDate");
                    String stockeable = request.getParameter("stockeable");
                    
                    pdao.addProducts(code, name, Float.parseFloat(iva), Float.parseFloat(price), Date.valueOf(beginDate) , Date.valueOf(endDate), Boolean.valueOf(stockeable));
                    
                    break;
                case "customers":

                    break;
                case "employees":

                    break;
                default:
                    throw new AssertionError();
            }
        }

        if (update != null) {
            switch (update) {
                case "products":

                    break;
                case "customers":

                    break;
                case "employees":

                    break;
                default:
                    request.getRequestDispatcher("maintenanceview/").forward(request, response);
                    throw new AssertionError();
            }
        }

        if (change != null) {
            switch (change) {
                case "add":
                    disabled = "";
                    act = "add";
                    msg = "Agregar";
                    request.setAttribute("disabled", disabled);
                    request.setAttribute("act", act);
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("maintenanceview/").forward(request, response);
                    break;
                case "update":
                    disabled = "";
                    act = "update";
                    msg = "Modificar";
                    request.setAttribute("disabled", disabled);
                    request.setAttribute("act", act);
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("maintenanceview/").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("maintenanceview/").forward(request, response);
                    throw new AssertionError();
            }
        }

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
