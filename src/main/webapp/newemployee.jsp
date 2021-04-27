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
	<style>
.welcome
{
    position: absolute;
    top: 3vw;
    right: 7vw;
}

.footer {
	    background-image: linear-gradient(white, blue);
   		color:#290F92;

  width: 100%;
  text-align: center;
  padding: 10px;
/*     		background: #EE82EE;
 */
  
  position: absolute;
  bottom: 0px;
}
.welcome1
{
 position: absolute;
  top: 3vw;
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

</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
		
<div class="container">

		<form action="addEmployee?user=<%=request.getAttribute("user") %>" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Code</label> <input
                type="text" class="form-control" placeholder="Enter Employee Code"
                 name="code">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Name</label> <input
					type="text" class="form-control" placeholder="Enter Employee Name"
					name="name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Email address</label> <input pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" class="form-control" placeholder="Enter Employee email"
					name="email">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Location</label> <input
					type="text" class="form-control" placeholder="Enter Employee Location"
					name="location">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Date of Birth</label> <input
					type="text" class="form-control"
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