<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="./css/style.css" />
        <title>SignUp | Employee App</title>
    </head>
    <body>
        <div id="content">
            <h1>Signup</h1>
            <hr />
            <br />
            <form action="./Signup" method="post">
                First Name : <input type="text" name="firstname" /><br /><br />
                Last Name : <input type="text" name="lastname" /><br /><br />
                Date of Birth : <input type="date" name="dob" /><br /><br />
                Contact Number : <input type="text" name="contact" /><br /><br />
                Job Role : <input type="text" name="role" /><br /><br />
                Monthly salary : <input type="number" name="salary" /><br /><br />
                Yearly Bonus : <input type="number" name="bonus" /><br /><br />
                <input type="submit" value="Register" />
            </form>
            <br /><br /><br />
            <a href="./login.jsp">Employee Login</a><br />
            <a href="./index.jsp">Home</a>
        </div>
    </body>
</html>
