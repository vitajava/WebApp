<%@ include file="header.jsp" %>
<body style="background: url(img/background.jpg);">
<center>
<div class="container">
      <form action="edited.html" method="GET">
          <center>
              <div>
                  <h2>Edit User Login ${login}</h2>
              </div>
              <table>
                  <tbody>

                  <tr>
                      <td>Login</td>
                      <c>
                      <td><input type="text" required
                            name="login"
                            value="${login}"></td>
                  </tr>
                  <tr>
                      <td>Password</td>
                      <td><input required size="30" maxlength="45" type="text" name="password" value=""/></td>
                  </tr>
                  <tr>
                     <td>First Name</td>
                     <td><input size="30" maxlength="45" type="text" name="firstname" value=""/></td>
                  </tr>
                  <tr>
                     <td>Last Name</td>
                     <td><input size="30" maxlength="45" type="text" name="lastname" value=""/></td>
                  </tr>
                  </tr>
                  <tr>
                     <td>Sex</td>
                     <td>
                     <input type="radio" name="sex" value="male"> Male<br>
                     <input type="radio" name="sex" value="female"> Female<br>
                     </td>
                  </tr>
                  <tr>
                     <td>Phone</td>
                     <td><input type="tel" pattern="[0-9]{5,45}$" size="30" maxlength="45"
                        name="phone" value=""/></td>
                  </tr>
                  <tr>
                    <td>Email</td>
                    <td><input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                         size="30" maxlength="45"
                         name="email" value=""/></td>
                  </tr>
                  <tr>
                     <td>Address</td>
                     <td><input type="text" pattern="[A-z]{1,45}$" size="30" maxlength="45"
                     name="email" value=""/></td>
                  </tr>

                  </tbody>
              </table>
              <br><br>
              <button id="buttons" type="submit"><img src="img/save.png">
          </center>
      </form>

</div>
</center>

<%@ include file="footer.jsp" %>
</body>