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
<h1>MYSQL</h1>


<div>
     <form action="PeopleController" method="post">
          <table>
             <tr>
               <td><label>Name: </label></td>
               <td><input type="text" name="name" placeholder="Name"/></td>
             </tr>
             <tr>
              <td><label>Last Name: </label></td>
              <td><input type="text" name="lastName" placeholder="Last Name"/></td>
             </tr>
             <tr>
              <td><label>Age: </label></td>
              <td><input type="number" name="age" placeholder="Age"/></td>
             </tr>
          </table>
          <input type="submit" value="Save"/>
     </form>
</div>
<br/>
<!--  <a href="http://localhost:8080/MemoBox/PeopleController"> <button type="submit">Show</button></a> -->
    
<div>
<table>
      <tr>
       <th>Name</th><th>Last Name</th><th>Age</th>
        </tr>  
    <C:forEach items="${pList}" var="people">
        
        <tr>
          <td>${people.name} </td>
          <td>${people.lastName} </td>
          <td>${people.age}</td>
          <td><a href="http://localhost:8080/MemoBox/PeopleUpdateController?id=${people.id}">Update</a></td>
           <td><a href="http://localhost:8080/MemoBox/PeopleDeleteController?id=${people.id}">Delete</a></td>
        </tr>     
    </C:forEach>  
</table>
</div>
</body>
</html>