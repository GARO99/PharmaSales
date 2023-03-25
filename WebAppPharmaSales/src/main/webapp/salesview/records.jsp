<%-- 
    Document   : records
    Created on : Mar 24, 2023, 2:48:51 AM
    Author     : Gustavo Andres Romero Ordoñez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../share/header.jsp" %>
<%@ include file="../share/sidebar.jsp" %>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Registro de ventas</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="home">Home</a></li>
              <li class="breadcrumb-item active">Ventas</li>
              <li class="breadcrumb-item active">Registro</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">
            <div class="card">
              <div class="card-body">
                <table id="recordSalesDatatable" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>#</th>
                    <th>Numero factura</th>
                    <th>Fecha</th>
                    <th>Empleado</th>
                    <th>Cliente</th>
                    <th>SubTotal</th>
                    <th>Total</th>
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
    </section>
</div>
<%@ include file="../share/footer.jsp.jsp" %>
<script>
$(function () {
    $('#recordSalesDatatable').DataTable({
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