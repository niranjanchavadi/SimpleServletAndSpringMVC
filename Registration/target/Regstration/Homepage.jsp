<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> Registration Form</title>
    <script>
        function validate()
        {
            var  last_name= document.form.last_name.value;
            var  first_name= document.form.first_name.value;
            var email = document.form.email.value;
            var username = document.form.username.value;
            var password = document.form.password.value;
            var conpassword= document.form.conpassword.value;
            var contact = document.form.contact.value;

            if (first_name==null || first_name=="")
            {
                alert("First Name can't be blank");
                return false;
            }

            else if (last_name==null || last_name=="")
            {
                alert("Last Name can't be blank");
                return false;
            }
            else  if (contact==null || contact=="")
            {
                alert("phone number can't be blank");
                return false;
            }
            else if (email==null || email=="")
            {
                alert("Email can't be blank");
                return false;
            }
            else if (username==null || username=="")
            {
                alert("Username can't be blank");
                return false;
            }
            else if(password.length<6)
            {
                alert("Password must be at least 8 characters long.");
                return false;
            }
            else if (password!=conpassword)
            {
                alert("Confirm Password should match with the Password");
                return false;
            }
        }
    </script>
</head>
<body>
<h1>Register Form</h1>
<form name="form" action="login" method="post" onsubmit="return validate()">
    <table align="center">
    <table style="with: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="first_name" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="last_name" /></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" /></td>
        </tr>
        <tr>
            <td>Contact No</td>
            <td><input type="text" name="contact" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="text" name="conpassword" /></td>
        </tr>
    </table>
        <input type="submit" value="Submit" /></table></form>
</body>
</html>