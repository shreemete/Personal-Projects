<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/signUp.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <title>Ingenious</title>
<link rel="icon" type="image/x-icon" href="images/icon.png">
</head>
<body>
    <div class="container">
        <div class="content">
            <form action="signIn.jsp">
                <a href="#" id="reg">Register</a>
                	
                <div class="hover">
                    
                    <input type="text" name="emp_name" class="form__input" placeholder=" "/>
                    <p>Employe Name</p>
                </div>
                <div class="hover">
                    <input type="email" name="emp_email" class="form__input" placeholder=" " />
                    <p>Employe Email</p>
            
                </div>
                <div class="hover">
                    <input type="text" name="emp_contact" class="form__input" placeholder=" "/>
                    <p>Employe Contact</p>
            
                </div>
                <div class="hover">
                    <input type="date" name="emp_join_date" class="form__input" placeholder=" "/>
                    <p>Date of Joining</p>
            
                </div>
                <div class="hover">
                    <input type="text" name="emp_designation" class="form__input" placeholder=" "/>
                    <p>Designation</p>
            
                </div>
                <div class="hover">
                    <input type="text" name="emp_blood" class="form__input" placeholder=" "/>
                    <p>Blood Group</p>
            
                </div>
                <div class="hover">
                    <input type="password" id="pass" name="emp_blood" class="form__input" placeholder=" "/>
                    <p>Password</p>
                    <span  onclick="myFunction()">
                        <i id="hide1" class="fas fa-eye"></i>
                        <i id="hide2" class="fas fa-eye-slash"></i>
                    </span>
                </div>
                <div class="btn green">
                    <input type="submit" value="Sign Up" />
                </div>
                
            </form>
            <div class="img">
                <a href="signIn.jsp" id="log">Login</a>
            </div>
        </div>
        <div class="back">
            <a href="back.jsp">
                <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                <span>Back</span>
            </a>
        </div>
    </div>
    <script>
        function myFunction(){
            var x = document.getElementById("pass");
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
    </script>
</body>
</html>