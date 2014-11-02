<%@ include file="header.jsp" %>
<body style="background: url(img/background.jpg);">
<center>
<div class="container">
  <table border="1">
   <h2>Users</h2>
   <div style="display: inline-flex;height: 40px;">
           <form  method="GET">
                        <input type="search" name="login" value=""
                               placeholder="Find by Login" style="height: 35px;">
           </form>
           <br><br>
           <form method="GET">
                        <input type="search" name="phone" value=""
                               placeholder="Find by Phone" style="height: 35px;">
           </form>

    </div>

   <div>
            <form action="add.html" method="POST">
                <button id="buttons" type="submit"><img src="img/add.png">
                      </form>
                      <br><br>
   </div>

   <tr>
        <th>Login</th>
        <th>Full Name</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Options</th>
   </tr>

    <c:forEach var="user" items="${list}">
         <tr>
             <td>${user.getLogin()}</td>
             <td>${user.getFirstName()} ${user.getLastName()}</td>
             <td>${user.getPhone()}</td>
             <td>${user.getEmail()}</td>
             <td>
                 <form method="POST" action="deleted.html">
                      <button id="buttons" type="submit"
                      name="login" value="${user.getLogin()}"><img src="img/remove.png">
                 </form>

                 <form method="POST" action="edit.html">
                      <button id="buttons" type="submit"
                       name="login" value="${user.getLogin()}"><img src="img/edit.png">
                       </form>
             </td>
         </tr>

    </c:forEach>
           <tr>
      </tr>
  </table>
</div>
</center>

<%@ include file="footer.jsp" %>
</body>