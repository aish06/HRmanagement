<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.models.Employee"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
.welcome1
{
 position: absolute;
  top: 4vw;
  right: 2vw; 
}

.welcome
{
    position: absolute;
    top: 3vw;
    right: 7vw;
}

/* .welcome
{
    position: absolute;
    top: 3vw;
    right: 7vw;
} */

/* .welcome1
{
 position: absolute;
  top: 4vw;
  right: 2vw; 
} */

.footer {
  width: 100%;
  text-align: center;
  padding: 10px;

 background-image: linear-gradient(white, blue);
   		color:#290F92;
  position: absolute;
  bottom: 0px;
}


.header h1{
text-align:center;
}
	.header{
	 background-image: linear-gradient(blue, white);
   		color:#290F92;
     	padding: 10px;
  		
     }

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

	
			<% Employee e=(Employee)request.getAttribute("empData"); %>
	
<div class="container">

		<form action="updatedEmployee?code=<%=e.getCode()%>&user=<%=request.getAttribute("user") %>" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Code</label> <input
                type="text" value="<%=e.getCode()%>" class="form-control"
                 name="employeeCode"
					readonly />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Name</label> <input type="text" value="<%=e.getName()%>" class="form-control" placeholder="Enter Employee Name"
					name="name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Email address</label> <input pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
				 value="<%=e.getEmail()%>" class="form-control" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Location</label> <input
					type="text" value="<%=e.getLocation()%>" class="form-control" placeholder="Enter email"
					name="location">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Date of Birth</label> <input
					type="text" value="<%=e.getDob()%>" class="form-control"
					placeholder="Enter employee date of Birth"
					name="dob">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	
	<div class="footer">
    	<h1>
			 <small> Copyright &copy;Nagarro Software Pvt. Limited</small>
		</h1>
    </div>

</body>
</html>