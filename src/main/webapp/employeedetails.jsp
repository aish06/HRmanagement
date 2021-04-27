<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.models.Employee"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<style>
.welcome
{
    position: absolute;
    top: 3vw;
    right: 7vw;
}

.button
{
  position:relative;
  top:10px;
  float:right;
}
.welcome1
{
 position: absolute;
  top: 4vw;
  right: 2vw; 
}
.header h1{
text-align:center;
}
	.header{
     	padding: 10px;
  		 background-image: linear-gradient(blue, white);
   		color:#290F92;
     }
    
.footer {
  width: 100%;
  text-align: center;
  padding: 10px;
    		 background-image: linear-gradient(white, blue);
   		color:#290F92;
  position: absolute;
  bottom: 0px;
}
        
  font-size: 30px;
</style>

<body>

<%
	if(request.getAttribute("user")==null)
	{
		System.out.println("<script>alert('Login fail.')</script>");
		response.sendRedirect("/");
	}
	
%>


	<div class="header">
		<h1>
			HR Manager			
		</h1>
		<div class="welcome">
			<p class="Logout">Welcome <%=request.getAttribute("user") %></p>
		</div>
		<div class="welcome1">
		     <a href="Logout">
           <button>Logout</button>
    		 </a>
		</div>
	</div>
	
    
     <div class="button">
     <a href="newEmployee?user=<%=request.getAttribute("user") %>">
           <button>Upload Employee Details</button>
     </a>
     
     <a href="exportPdf">
        <button>Download Employee Details</button>
     </a>
      </div>
   	
    	<div class="container">
		<div class="row">


			<div class="col-md-12">
				<h4>Employee Listings</h4>
				<div class="table-responsive">


					<table id="mytable" class="table table-bordered table-striped" border="1" style="width:75%">

						<thead>

							<th>Employee Code</th>
							<th>Employee Name</th>
							<th>Location</th>
							<th>Email</th>
							<th>Date of Birth</th>
							<th>Action</th>
							<th>Action</th>
						</thead>

						<tbody>
						<%	
						List<Employee> employees =(List<Employee>) request.getAttribute("empList");
						if(employees!=null) {
							for(Employee emp : employees) {
								%>
							<tr>
								<td><%=emp.getCode()%></td>
								<td><%=emp.getName()%></td>
								<td><%=emp.getLocation()%></td>
								<td><%=emp.getEmail()%></td>
								<td><%=emp.getDob()%></td>
								<td> <a href="updateEmployee?code=<%=emp.getCode()%>&user=<%=request.getAttribute("user") %>" class="btn btn-primary">Edit</a>
								<td> <a href="deleteEmployee?code=<%=emp.getCode()%>&user=<%=request.getAttribute("user") %>" class="btn btn-primary">Delete</a>														
							</tr>
							<%
							}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
    
    <div class="footer">
    	<h1>
			 <small> Copyright &copy;Nagarro Software Pvt. Limited</small>
		</h1>
    </div>
    	
</body>
</html>
