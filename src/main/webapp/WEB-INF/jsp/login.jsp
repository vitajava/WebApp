<%@ include file="header.jsp" %>
<body style="background: url(img/background.jpg);">
<center>
<div class="container">

<h2>Hello, please log in:</h2>
<br><br>
<form action="j_security_check" method=post>
    <p><strong>Please Enter Your User Name: </strong>
    <input type="text" name="j_username" size="25">
    <p><p><strong>Please Enter Your Password: </strong>
    <input type="password" size="15" name="j_password">
    <p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

</div>
</center>

<%@ include file="footer.jsp" %>
</body>