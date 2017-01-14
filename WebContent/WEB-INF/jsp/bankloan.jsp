<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<%@ page import="java.util.Hashtable"%>
<%@ page  import="org.jfree.chart.axis.*" %>
<%@ page  import="org.jfree.chart.labels.*" %>
<%@ page  import="org.jfree.chart.plot.*" %>
<%@ page  import="org.jfree.chart.renderer.category.*" %>
<%@ page  import="org.jfree.chart.urls.*" %>
<%@ page  import="org.jfree.data.category.*" %>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.HashMap"%>


<%@ page import="org.json.JSONArray"%>
<%@ page import="org.json.JSONException"%>
<%@ page import="org.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
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
    
    
    <script>

$(document).ready(function(){
	var map = {};
	$("select[name='field1'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});

$(document).ready(function(){
	var map = {};
	$("select[name='field2'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});
	
$(document).ready(function(){
	var map = {};
	$("select[name='field3'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});
	
$(document).ready(function(){
	var map = {};
	$("select[name='field4'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});
	
$(document).ready(function(){
	var map = {};
	$("select[name='field5'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});

$(document).ready(function(){
var map = {};
$("select[name='field6'] > option").each(function () {
    if (map[this.value]) {
        $(this).remove()
    }
    map[this.value] = true;
})
});

$(document).ready(function(){
	var map = {};
	$("select[name='field7'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});

$(document).ready(function(){
	var map = {};
	$("select[name='field8'] > option").each(function () {
	    if (map[this.value]) {
	        $(this).remove()
	    }
	    map[this.value] = true;
	})
	});

</script>

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
                        <a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false" href="#">R&amp;D <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">AI</a></li>
                            <li><a href="#"></a></li>
                            
                        </ul>
                    </li><!--//dropdown-->
                     

                    
                </ul><!--//nav-->
            </div><!--//navabr-collapse-->
        </nav><!--//main-nav-->

</div></div>

</div>
</header>


<div class="filter-data">

<div class="container">
<div class="row">
<h1 class="filter-heading">Filter Data</h1>
 
    <div class="well well-lg dropdown-box">

  <div class="col-md-4"> <h4 class="col-title">Loan Type</h4><div class="styled-select slate"><select name="field1">
 
 <c:forEach var="mylist" items="${data}">
								<option value="${mylist.field}">${mylist.field}</option>
							</c:forEach>
							</select></div></div>

  <div class="col-md-4"> <h4 class="col-title">Age</h4><div class="styled-select slate"><select name="field2">
 
 <c:forEach var="mylist" items="${data}">
								<option value="${mylist.age}">${mylist.age}</option>
							</c:forEach>
						
						</select></div></div>
						
  <div class="col-md-4"> <h4 class="col-title">Job</h4><div class="styled-select slate"><select name="field3">
            
							<c:forEach var="mylist" items="${data}">
								<option value="${mylist.job}">${mylist.job}</option>
							</c:forEach>
						</select></div></div>
  <div class="col-md-4"> <h4 class="col-title">Married</h4><div class="styled-select slate"><select name="field4">
							<c:forEach var="mylist" items="${data}">
								<option value="${mylist.marital}">${mylist.marital}</option>
							</c:forEach>
						</select></div></div>
<div class="col-md-4"><h4 class="col-title">Education</h4><div class="styled-select slate"><select name="field5">
							<c:forEach var="mylist" items="${data}">
								<option value="${mylist.education}">${mylist.education}</option>
							</c:forEach>
						</select></div></div>
<div class="col-md-4"><h4 class="col-title"> Defaulter</h4><div class="styled-select slate"> <select name="field6">
            
							<c:forEach var="mylist" items="${data}">
								<option value="${mylist.defaulter}">${mylist.defaulter}</option>
							</c:forEach>
						</select></div></div>
						
												


<div class="col-md-4"><h4 class="col-title"> Average deposit</h4><div class="styled-select slate"> <select name="field7">
            
							<c:forEach var="mylist" items="${data}">
								<option value="${mylist.average_deposit}">${mylist.average_deposit}</option>
							</c:forEach>
						</select></div></div>
						
						<div class="col-md-4"><h4 class="col-title"> House</h4><div class="styled-select slate"> <select name="field8">
            
							<c:forEach var="mylist" items="${data}">
								<option value="${mylist.house}">${mylist.house}</option>
							</c:forEach>
						</select></div></div>

						
						
						<div class="col-md-12"><button type="button" class="btn btn-info pull-right">Search</button></div>
  
  <div class="clearfix"></div>
  
  
</div>
</div>
</div>
</div>
<!---------------------------------Score Board------------------------------------- -->
<div class="container summary">
	<div class="row">
	
	<div class="graph-label group">
	
	         					 
					<div class="graph-block1">
					<div class="col-md-6">
					<h2 class="loan-title">Loan Result : </h2>
					<div class="loan-content">
					<p>  </p></div>
				</div>
			</div>
			 
			</div></div>
	
	</div>

</div>








    <!-- ----------------------------footer----------------------------------- -->
  <footer class="footer">
<div class="footer-content">
<div class="bottom-bar">

<div class="span6"><div class="bottom-text"><b><a href="http://www.virtusapolaris.com/">VirtusaPolaris</a></b>| Accelerating Business Outcomes  <br>
        <small> All Rights Reserved.</small>

</div>
</div>
</footer>  
    
    
   </body>
   </html> 
    
    
    