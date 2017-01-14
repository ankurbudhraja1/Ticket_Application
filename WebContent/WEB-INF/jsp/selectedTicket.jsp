<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<head>

<script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>
<script type="text/javascript" src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.fint.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <!--  <meta charset="utf-8">   -->
    <title>Analytics Platform</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="resources/css/custom.css" rel="stylesheet">
    
 <!-- -------links for filters---------- -->
 
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
 <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script></head>
  
  <!-- -------links for checkbox---------------- -->
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.2.0/css/select.dataTables.min.css">
      
      
 <!-- ---------------------bootstrap---------- -->
<link href="bootstrap.min.css" rel="stylesheet">
 <link href="custom.css" rel="stylesheet">


</head>
<body>


<header class="header">
<div class="row">
<div class="col-md-6"><div class="logo"><img src="resources/img/GTO-logo.png"/></div></div>
<div class="col-md-6"><div class="icons">
        <nav class="main-nav navbar-right" role="navigation">
            <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button><!--//nav-toggle-->
            </div><!--//navbar-header-->
            <div id="navbar-collapse" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                   
                    <li class="nav-item dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false" href="#">Code <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">InsightLive</a></li>
                            <li><a href="#">InsightLive Pega</a></li>
                            <li><a href="#">Beacon</a></li>
                            
                            
                        </ul>
                    </li><!--//dropdown-->

                    <li class="nav-item dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false" href="#">DevOps <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Tempo</a></li>
                           
                        </ul>
                    </li><!--//dropdown-->
                      
						
                     <li class="nav-item"><a href="#">Sales</a></li>
                     <li class="nav-item"><a href="#">Training</a></li>
                     
                    <li class="nav-item dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false" href="#">R&D <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">AI</a></li>
                            <li><a href="#" ></a></li>
                            
                        </ul>
                    </li><!--//dropdown-->
                     

                    
                </ul><!--//nav-->
            </div><!--//navabr-collapse-->
        </nav><!--//main-nav-->

</div></div>

</div>



</header>


<script>

$(document).ready(function() {
    $('#example2').DataTable( {
    
    	scrollY:        500,
        scrollX:        true,
        scrollCollapse: true,
        paging:         false,
        fixedColumns:   true,
        
        
       
        
        initComplete: function () {
            this.api().columns().every( function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                    .appendTo( $(column.footer()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );
 
                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );
 
                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        }
    } );
} ); 


</script>

<form method="get" action="home2.html">

<div class="table-content">
  <h1 class="table-heading">Ticket List</h1>
<table id="example2" class="stripe row-border order-column nowrap display" cellspacing="0" width="100%">
       <thead>
            <tr class="table-data-heading">
                 <th>Ticket_Number</th>
                <th>Priority</th>
                <th>App_Name</th>
                <th>Line_of_Business</th>
                <th>Primary_Application</th>
                <th>Ticket_Description</th>
                <th>Assignee</th>
                <th>Edit</th>
                <th>assigne</th>

            </tr>
        </thead>
        <tfoot><tr class="table-data-heading">
                 <th>Ticket_Number</th>
                <th>Priority</th>
                <th>App_Name</th>
                <th>Line_of_Business</th>
                <th>Primary_Application</th>
                <th>Ticket_Description</th>
                <th>Assignee</th>
                  <th>Edit</th>
                  <th>assigne</th>

            </tr></tfoot>
       
        
        
        <tbody>
        	<c:forEach var="mylist" items="${ticket.data}">
<tr>

<td align="center"><a href="home2.html?getticket=${mylist.ticket_number}">${mylist.ticket_number}</a></td>
<td>${mylist.priority}</td>
<td>${mylist.app_name}</td>
<td>${mylist.line_of_business}</td>
<td>${mylist.primary_application}</td>
<td>${mylist.ticket_description}</td>
<td>${mylist.assignee}</td>
<td><select id="select-class" name="resource"><c:forEach var="list" items="${ticket.names}"><option value="${list},${mylist.ticket_number}">${list}</option></c:forEach></select></td>
 <td><button class="hidey">Edit</button></td>	
							
</tr>

							</c:forEach>
        </tbody>
        
       
</table>

<br>


Submit here<input type="submit" class="btn btn-info pull-right">


</div>


<script>
$(document).ready(function(){
	    $(".showy").hide();
        $(".hidey").click(function(){
        $(".showy").show();
        
        
       console.log($("#select-class").find("option:selected").text());
       $(".hidey").hide();
       
        });
        
    });
    


</script>



</script>
<script>  $("#sheru").hide();
</script>
<!-- ------------------------------------footer-------------------- -->


</body>
</html>