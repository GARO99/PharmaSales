<%-- 
    Document   : Customers
    Created on : 1/04/2023, 12:42:49 a. m.
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
                    <h1 class="m-0">Clientes</h1>
                </div><!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="home">Home</a></li>
                        <li class="breadcrumb-item active">Mantenimiento</li>
                        <li class="breadcrumb-item active">Clientes</li>
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
                            <h3 class="card-title">Agregar cliente</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form>
                            <div class="card-body">
                                <div class="form-row">
                                    <div class="col-md-2 mb-3">
                                        <label for="validationServer04">Tipo</label>
                                        <select class="custom-select" id="validationServer04" required>
                                            <option selected value="">N/A</option>
                                            <option>TI</option>
                                            <option>CC</option>
                                            <option>CE</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="validationServer03">Numero de identificacion</label>
                                        <input type="text" class="form-control" id="validationServer03" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-6 mb-3">
                                        <label for="validationServer01">Nombre</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="validationServer02">Apellido</label>
                                        <input type="text" class="form-control" required>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-6 mb-3">
                                        <label for="validationServer03">Celular</label>
                                        <input type="text" class="form-control" id="validationServer03" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="validationServer03">Direccion</label>
                                        <input type="text" class="form-control" id="validationServer03" required>
                                    </div>
                                </div>
                                <button name="" value="" class="btn btn-primary" type="submit">Submit form</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="card">
                        <div class="card-body">
                            <table id="customersMaintenanceDatatable" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th>#ID</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Celular</th>
                                        <th>Direccion</th>
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
    $('#customersMaintenanceDatatable').DataTable({
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

