<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="CSS/index1.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>

    <header>
      <div class="logo">  
        Acheivers Academy
       
      </div>
      <section>
        <div class="title">
          Employee Registration
        </div>
        <div class="btn btn1">
          <a href="registration.jsp">Register</a>
          <!-- <a href="#">New Registration</a> -->
        </div>
        <div class="btn btn2">
          <a href="signIn.jsp">Login</a>
          <!-- <a href="#">Employee Details</a> -->
        </div>
        <div class="box"></div>
      </section>
      <div class="center">
        <button id="show-login">Admin Login</button>
    </div>
    <div class="popup">
        <div class="close-btn">&times;</div>
        <form action="Admin/admin.jsp" method="post">
        <div class="form">
            <h2>Log in</h2>
            <div class="form-element">
                <label for="email">Email</label>
                <input type="text" name="email" id="email" placeholder="Enter email">
            </div>
            <div class="form-element">
                <label for="password">Password</label>
                <input type="text" name="pass" id="password" placeholder="Enter password">
            </div>
            <!-- <div class="form-element">
                <input type="checkbox" name="" id="remember-me">
                <label for="remember-me">Remember me</label>
            </div> -->
            <div class="form-element">
                <input type="submit" value="Sign In">
            </div>
            <div class="form-element">
                <a onclick="password()" id="pass">Forgot password ?</a>
            </div>

        </div>
      </form>
    </div>
     
    </header>
    <script>
    	document.querySelector("#show-login").addEventListener("click",function(){
            document.querySelector(".popup").classList.add("active");
        });
        document.querySelector(".popup .close-btn").addEventListener("click",function(){
            document.querySelector(".popup").classList.remove("active");
        });

        document.querySelector("#pass").addEventListener("click", function(){
          alert("Your password is admin");
        })
        
  </script>
</body>
</html>