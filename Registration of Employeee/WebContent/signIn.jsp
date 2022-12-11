<%@page import="org.eclipse.jdt.internal.compiler.ast.TryStatement"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="CSS/signIn1.css">
    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
<%

%>
    <div class="container">
        <div class="content">
        	<div class="bg"></div>
            <div class="img">
            	<img alt="Ingenious" src="images/icon.png" style="margin-top:75px">
                <!--  <a href="signUp.jsp" id="reg">Sign Up</a>-->
            </div>
            <form action="signInDb.jsp" method="post">
                <h1>Login Here</h1>
                <a href="#" id="log">Sign In</a>
                <label for="user" id="user">Username</label>
                <input type="email" name="email" id="" required placeholder="Enter email">
                <label for="pass" id="pass">Password</label>
                <input type="password" name="pass" required id="pas" placeholder="Enter password">
                <span  onclick="myFunction()">
                    <i id="hide1" class="fas fa-eye"></i>
                    <i id="hide2" class="fas fa-eye-slash"></i>
                </span>
                <a onclick="password()" id="forgot">Forgot Password ?</a>
                <input type="submit" value="Login">
            </form>
        </div>
        <div class="back">
            <a href="index.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
        </div>
    </div>
   
    <script>
        function myFunction(){
            var x = document.getElementById("pas");
            var y = document.getElementById("hide1");
            var z = document.getElementById("hide2");

            if(x.type == 'password'){
                x.type="text";
                y.style.display="block";
                z.style.display="none";
            }
            else{
                x.type="password";
                y.style.display="none";
                z.style.display="block";
            }
        }
        
        document.querySelector("#forgot").addEventListener("click", function(){
          alert("Your password is your registered contact number");
        })
    </script>
</body>
</html>