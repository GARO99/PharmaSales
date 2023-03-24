<%-- 
    Document   : index
    Created on : Mar 23, 2023, 4:08:25 PM
    Author     : Gustavo Andres Romero Ordoñez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../share/header.jsp" %>
<%@ include file="../share/sidebar.jsp" %>
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
                        <form>
                          <div class="card-body">
                            <div class="form-group">
                                <label>Minimal</label>
                                <select class="form-control select2bs4" style="width: 100%;">
                                  <option>TI</option>
                                  <option selected="selected">CC</option>
                                  <option>CE</option>
                                </select>
                            </div>
                            <div class="form-group">
                              <label for="idNumberCustomer">Numero de identificación</label>
                              <input type="number" class="form-control" id="idNumberCustomer" placeholder="Cedula del cliente">
                            </div>
                          </div>
                          <!-- /.card-body -->

                          <div class="card-footer">
                            <button type="submit" class="btn btn-primary">Buscar</button>
                          </div>
                        </form>
                    </div>
                    <div class="card card-primary">
                        <div class="card-header">
                          <h3 class="card-title">Añadir Productos</h3>
                        </div>
                        <!-- /.card-header -->
                        <!-- form start -->
                        <form>
                          <div class="card-body">
                            <div class="form-group">
                                <label for="idProduct">Id producto</label>
                                <div class="input-group">
                                    <input type="number" class="form-control" id="idProduct" placeholder="Id del producto">
                                    <div class="input-group-append">
                                        <button class="input-group-text"><i class="fas fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Precio unitario:</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Stock disponible:</label>
                                    </div>
                                </div>                            
                            </div>

                            <div class="form-group">
                              <label for="quantity">Cantidad</label>
                              <input type="number" class="form-control" id="quantity" placeholder="Cantidad">
                            </div>
                          </div>
                          <!-- /.card-body -->

                          <div class="card-footer">
                            <button type="submit" class="btn btn-primary">Agregar prodcuto</button>
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
                                    <p class="card-text"><b>Tipo de identificación</b>: {}</p>
                                    <p class="card-text"><b>Numero de identificación</b>: {}</p>
                                </div>
                                <div class="col-md-6">
                                    <p class="card-text"><b>Nombre Completo</b>: {}</p>
                                    <p class="card-text"><b>Telefono</b>: {}</p>
                                    <p class="card-text"><b>Direccion</b>: {}</p>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-header -->
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
                              <tr >
                                <td colspan="9" class="text-center">No hay datos disponibles</td>
                              </tr>
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
                                        <button class="btn btn-success">Generar venta</button>
                                    </div>
                                    <div class="col-md-6">
                                        <button class="btn btn-danger">Cancelar</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="card-text"><b>SubTotal</b>: $ {}</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="card-text"><b>Total</b>: $ {}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
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