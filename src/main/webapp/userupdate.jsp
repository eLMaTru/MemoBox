<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MemoBox</title>
</head>
<body>

<div>
    <form action="UserUpdateController?id=${id}" method="post">
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
           <td><button type="submit">Update</button></td>
        </tr>
        </table>
    </form>
</div>
<br/>

</body>
</html>