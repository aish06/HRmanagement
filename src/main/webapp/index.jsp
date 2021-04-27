<html>
<style>
	.header{
	    background-image: linear-gradient(blue, white);
     	padding: 10px;
  		text-align: center;
/*   		background: #EE82EE;
 */  		
 		color: white;
 		color:#290F92;
     }
     .myForm{
       
      border: 1px solid red;
  border-radius: 16px;
	width: 400px;
	font-size: 20px;
	margin: auto;
	margin-top: 100px;
	text-indent: 1em;
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
        
  font-size: 30px;
</style>

<body>
	<div class="header">
		<h1>
			HR Manager
		</h1>
	</div>
    
    <div class="myForm">
   		<form action="Login" method="post">
        	<label for="userId">User Id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input type="text" id="userId" name="userId"><br><br>
            <label for="password">&nbsp;&nbsp&nbsp;&nbsp;Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <input type="password" id="password" name="password"><br><br>
            <button type="submit">Login</button>
            
        </form>
    </div>
    
    
    <div class="footer">
    	<h1>
			 <small> Copyright &copy;Nagarro Software Pvt. Limited</small>
		</h1>
    </div>
    	
</body>
</html>
