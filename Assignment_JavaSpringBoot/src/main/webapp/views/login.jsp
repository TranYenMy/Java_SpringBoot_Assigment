<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form action="/login" method="post">
    Username: <input type="text" name="uname"> <br>
    <br>
    PassWord: <input type="password" name="pw"> <br>
    <br>

<input type="checkbox" name="remember"> <label>Nho Mat khau  </label>
    <button type="submit">Login</button>
</form>