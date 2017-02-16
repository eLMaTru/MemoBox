<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemoBox</title>
</head>
<body>
<h1>MYSQL</h1>

<div>
     <form action="PeopleUpdateController?id=${id}" method="post">
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
          <input type="submit" value="Update"/>
     </form>
</div>

</body>
</html>