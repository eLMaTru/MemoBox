<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemoBox</title>
</head>
<body>
<h1>Hibernate</h1>

<div>
    <form action="UserController" method="post">
        <table>
        <tr>
        <td><label>Name:</label></td>
        <td><input type="text" name="name" placeholder="Name"/></td>
        </tr>
        <tr>
        <td><label>Last Name:</label></td>
        <td><input type="text" name="lastName" placeholder="Last Name"/></td>
        </tr>
        <tr>
        <td><label>Age:</label></td>
        <td><input type="number" name="age" placeholder="Age"/></td>
        </tr>
        <tr>
           <td><button type="submit">Save</button></td>
        </tr>
        </table>
    </form>
</div>
<br/>

<h4> Hibernate </h4>
<div>
    <table>
        <tr>
          <th>Name</th><th>Last Name</th><th>Age</th><th>Update</th><th>Delete</th>
        </tr>
        <C:forEach items="${uList}" var="user">
          <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td><a href="UserUpdateController?id=${user.id}">Up</a></td>
            <td><a href="UserDeleteController?id=${user.id}">De</a></td>
          </tr>
        </C:forEach>
    
    </table>    

</div>
<br/>

<h4>Hibernate + Criteria</h4>

<div>
    <table>
        <tr>
          <th>Name</th><th>Last Name</th><th>Age</th><th>Update</th><th>Delete</th>
        </tr>
        <C:forEach items="${criList}" var="user">
          <tr>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td><a href="UserUpdateController?id=${user.id}">Up</a></td>
            <td><a href="UserDeleteController?id=${user.id}">De</a></td>
          </tr>
        </C:forEach>
    
    </table>    

</div>
 


</body>
</html>