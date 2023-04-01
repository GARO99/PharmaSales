<%-- 
    Document   : products
    Created on : 1/04/2023, 12:41:35 a. m.
    Author     : PERSONAL
--%>

<%@page import="Models.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../share/header.jsp" %>
<%@ include file="../share/sidebar.jsp" %>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0">Productos</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="home">Home</a></li>
                        <li class="breadcrumb-item active">Mantenimiento</li>
                        <li class="breadcrumb-item active">Productos</li>
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
                            <h3 class="card-title">Producto</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form method="post">
                            <div class="card-body">
                                <div class="form-row">
                                    <div class="col-md-12 mb-3">
                                        <label for="validationServer01">Codigo</label>
                                        <input name="code" type="text" class="form-control" required <%= request.getAttribute("disabled")%> >
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-9 mb-3">
                                        <label for="validationServer01">Nombre</label>
                                        <input name="name" type="text" class="form-control" required <%= request.getAttribute("disabled")%> >
                                    </div>
                                    <div class="col-md-3 mb-3">
                                        <label for="validationServer02">Iva</label>
                                        <input name="iva" type="text" class="form-control" required <%= request.getAttribute("disabled")%> >
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-4 mb-3">
                                        <label for="validationServer03">Precio</label>
                                        <input name="price" type="text" class="form-control" required <%= request.getAttribute("disabled")%> >
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label for="validationServer03">Fecha inicio</label>
                                        <input name="beginDate" type="date" class="form-control" required <%= request.getAttribute("disabled")%> >
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label for="validationServer03">Fecha fin</label>
                                        <input name="endDate" type="date" class="form-control" required <%= request.getAttribute("disabled")%> >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="form-check">
                                        <input name="stockeable" class="form-check-input" type="checkbox" <%= request.getAttribute("disabled")%> >
                                        <label class="form-check-label" for="invalidCheck3">
                                            Stockeable
                                        </label>
                                    </div>
                                </div>
                                <button name="<%= request.getAttribute("act")%>" value="products" class="btn btn-primary" type="submit" <%= request.getAttribute("disabled")%> ><%= request.getAttribute("msg")%></button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="card">
                        <div class="card-body">
                            <form method="post">
                                <button class="btn btn-primary" name="change" value="add" type="submit">Agregar</button>
                                <button class="btn btn-secondary">Activos</button>
                                <button class="btn btn-secondary">Inactivos</button>
                            </form>
                            <table id="productsMaintenanceDatatable" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Iva</th>
                                        <th>Precio</th>
                                        <th>Inicio</th>
                                        <th>Fin</th>
                                        <th>Stock</th>
                                        <th>  </th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
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
<script>
    $(function () {
        $('#productsMaintenanceDatatable').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": true,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
            "language": {
                "url": "https://cdn.datatables.net/plug-ins/1.13.4/i18n/es-ES.json"
            }
        });
    });
</script>
