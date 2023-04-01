<%-- 
    Document   : index
    Created on : Mar 23, 2023, 4:08:25 PM
    Author     : Gustavo Andres Romero Ordoñez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../share/header.jsp" %>
<%@ include file="../share/sidebar.jsp" %>
<%@ page import="Utils.Constants.NewSalesAcctionConstans" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>

<%
    Locale locale = new Locale("es", "CO");
    NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
%>

<c:set var="currency" value="<%= currency %>"/>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">Nueva venta</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="home">Home</a></li>
                        <li class="breadcrumb-item active">Ventas</li>
                        <li class="breadcrumb-item active">Nueva</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">
            <div class="row"> 
                <div class="col-md-5">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Info. Cliente</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form action="" method="post">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Tipo de Identificación</label>
                                    <select name="idType" class="form-control select2bs4" style="width: 100%;">
                                        <option value="1">N/A</option>
                                        <option value="2">TI</option>
                                        <option value="3">CC</option>
                                        <option value="4">CE</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="idNumberCustomer">Numero de identificación</label>
                                    <input name="idNumber" type="number" value="${customers.getIDENTIFICATION_NUMBER_CUSTOMER()}" class="form-control" id="idNumberCustomer" placeholder="Cedula del cliente">
                                </div>
                            </div>
                            <!-- /.card-body -->

                            <div class="card-footer">
                                <button type="submit" name="formAction" value="<%= NewSalesAcctionConstans.SEARCH_CUSTOMERS %>" class="btn btn-primary">Buscar</button>
                            </div>
                        </form>
                    </div>
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">Añadir Productos</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form action=""  method="post">
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="idProduct">Id producto</label>
                                    <div class="input-group">
                                        <input name="productCode" type="text" value="${product.getPRODUCT_CODE()}" class="form-control" id="idProduct" placeholder="Codigo Producto">
                                        <div class="input-group-append">
                                            <button type="submit" name="formAction" value="<%= NewSalesAcctionConstans.SEARCH_PRODUCT %>" class="input-group-text"><i class="fas fa-search"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Nombre:</label>
                                            <span>${product.getPRODUCT_NAME()}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Precio unitario:</label>
                                            <c:if test="${product.getPRICE()!= null}">
                                                <span>${currency.format(product.getPRICE())}</span>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>IVA%:</label>
                                            <span>${product.getIVA_PERCENT()}</span>
                                        </div>
                                    </div>    
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Stock disponible:</label>
                                            <span>${product.getSTOCKABLE()? "Si":"No"}</span>
                                        </div>
                                    </div>                            
                                </div>
                                <div class="form-group">
                                    <label for="quantity">Cantidad</label>
                                    <input name="quantity" type="number" class="form-control" id="quantity" placeholder="Cantidad">
                                </div>
                            </div>
                            <!-- /.card-body -->

                            <div class="card-footer">
                                <button name="formAction" type="submit" value="<%= NewSalesAcctionConstans.ADD_PRODUCT %>" class="btn btn-primary">Agregar prodcuto</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="card">
                        <div class="card-header">
                            <h3 class="text-center"><b>VENTA</b></h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <h3 class="card-title"><b>Cliente</b></h3>
                                    <p class="card-text"><b>Tipo de identificación</b>: ${customers.getIDENTIFICATION_TYPE()} </p>
                                    <p class="card-text"><b>Numero de identificación</b>: ${customers.getIDENTIFICATION_NUMBER_CUSTOMER()}</p>
                                </div>
                                <div>
                                    <p class="card-text"><b>Nombre completo</b>: ${customers.getFIRSTNAME()} ${customers.getLASTNAME()}</p>
                                    <p class="card-text"><b>Telefono</b>: ${customers.getPHONE()}</p>
                                    <p class="card-text"><b>Direccion</b>: ${customers.getADDRESS()}</p>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <form action=""  method="post">
                            <div class="card-body p-0">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Codigo</th>
                                            <th>Descripcion</th>
                                            <th>Precio</th>
                                            <th>IVA%</th>
                                            <th>Cantidad</th>
                                            <th>SubTotal</th>
                                            <th>Total</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${orderList.size() > 0}">
                                                <c:forEach var="order" items="${orderList}" varStatus="status">
                                                    <tr>
                                                        <td class="text-center">${status.index + 1}</td>
                                                        <td class="text-center">${order.getFK_PRODUCT_CODE()}</td>
                                                        <td class="text-center">${order.getPRODUCT_NAME()}</td>
                                                        <td class="text-center">${currency.format(order.getPRICE())}</td>
                                                        <td class="text-center">${order.getIVA()}</td>
                                                        <td class="text-center">${order.getQUANTITY()}</td>
                                                        <td class="text-center">${currency.format(order.getSUB_TOTAL())}</td>
                                                        <td class="text-center">${currency.format(order.getTOTAL())}</td>
                                                        <td class="text-center">
                                                            <button name="tableAction" value="${status.index}" type="submit" class="btn btn-warning m-1"><i class="fas fa-edit"></i></button>
                                                            <button name="tableAction" value="${status.index}" type="submit" class="btn btn-danger m-1"><i class="fas fa-trash-alt"></i></button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td colspan="9" class="text-center">No hay datos disponibles</td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>                                                            
                                    </tbody>
                                </table>
                            </div>
                        <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                            <div class="card-footer">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <button name="formAction" value="<%= NewSalesAcctionConstans.ADD_ORDER %>" type="submit" class="btn btn-success">Generar venta</button>
                                            </div>
                                            <div class="col-md-6">
                                                <button name="formAction" value="<%= NewSalesAcctionConstans.CANCEL_ORDER %>" type="submit" class="btn btn-danger">Cancelar</button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <p class="card-text"><b>SubTotal</b>: ${currency.format(subTotal)}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <p class="card-text"><b>Total</b>: ${currency.format(total)}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    </section>
</div>
<%@ include file="../share/footer.jsp.jsp" %>
<script>
    $(function () {
        //Initialize Select2 Elements
        $('.select2bs4').select2({
            theme: 'bootstrap4'
        })
    });
</script>