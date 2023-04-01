/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.CustomersDAO;
import DAO.OrderDAO;
import DAO.ProductsDAO;
import Models.Customers;
import Models.Order;
import Models.Order_Details;
import Models.Products;
import Utils.Constants.NavConstans;
import Utils.Constants.NewSalesAcctionConstans;
import ViewModels.OrderDetailView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Andres Romero Ordoñez
 */
public class SalesController extends HttpServlet {
    Customers customers = null;
    CustomersDAO customersDao = new CustomersDAO();
    Products products = null;
    ProductsDAO productsDAO = new ProductsDAO();
    OrderDAO orderDAO =  new OrderDAO();
    List<OrderDetailView> orderDetailViewList = new ArrayList<>();
    float total = 0;
    float subTotal = 0;
    
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
        String action = request.getParameter("action");
        switch (action) {
            case NavConstans.NEW_SALES:
                request.setAttribute("customers", this.customers);
                request.setAttribute("product", this.products);
                request.setAttribute("orderList", this.orderDetailViewList);
                request.setAttribute("total", this.total);
                request.setAttribute("subTotal", this.subTotal);
                request.getRequestDispatcher("salesview/new.jsp").forward(request, response);
                break;
            case NavConstans.RECORDS_SALES:
                request.getRequestDispatcher("salesview/records.jsp").forward(request, response);
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
        String search = request.getParameter("formAction");
        switch (search) {
            case NewSalesAcctionConstans.SEARCH_CUSTOMERS:
                String idType = request.getParameter("idType");
                String idNumber = request.getParameter("idNumber");
                customers  = customersDao.getCustomer(idNumber, idType);
                break;
            case NewSalesAcctionConstans.SEARCH_PRODUCT:
                String productCode = request.getParameter("productCode");
                products = productsDAO.getProduct(productCode);
                break;
            case NewSalesAcctionConstans.ADD_PRODUCT:
                int Quantity = Integer.parseInt(request.getParameter("quantity"));
                float subTotal = products.getPRICE() * Quantity;
                float taxIva = subTotal * (products.getIVA_PERCENT()/100);
                float total = subTotal + taxIva; 
                OrderDetailView order = new OrderDetailView(products.getPRODUCT_CODE(), products.getPRODUCT_NAME(),
                        products.getPRICE(), products.getIVA_PERCENT(), Quantity, subTotal, total);
                orderDetailViewList.add(order);
                this.total = 0;
                this.subTotal = 0;
                for (OrderDetailView orderDetail : orderDetailViewList) {
                    this.total += orderDetail.getTOTAL();
                    this.subTotal += orderDetail.getSUB_TOTAL();
                }
                products = null;
                break;
            case NewSalesAcctionConstans.ADD_ORDER:
                orderDAO.SaveOrder(new Order(0, "1217652135", customers.getIDENTIFICATION_NUMBER_CUSTOMER(), new Date(), this.subTotal, this.total));
                for (OrderDetailView orderDetail : orderDetailViewList) {
                    orderDAO.SaveDatailOrder(new Order_Details(0, orderDetail.getQUANTITY(),orderDetail.getSUB_TOTAL(), orderDAO.IdOrder(),orderDetail.getFK_PRODUCT_CODE()));
                }
                this.customers =  null;
                this.products =  null;
                this.orderDetailViewList = new ArrayList<>();
                this.total = 0;
                this.subTotal = 0;
                break;
            case NewSalesAcctionConstans.CANCEL_ORDER:
                this.customers =  null;
                this.products =  null;
                this.orderDetailViewList = new ArrayList<>();
                this.total = 0;
                this.subTotal = 0;
                break;
        }
        request.setAttribute("customers", this.customers);
        request.setAttribute("product", this.products);
        request.setAttribute("orderList", this.orderDetailViewList);
        request.setAttribute("total", this.total);
        request.setAttribute("subTotal", this.subTotal);
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
