<%--
  Created by IntelliJ IDEA.
  User: ldl
  Date: 2025/4/2
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ldl.entity.Person" %>
<%@ page import="com.ldl.Service.impl.PersonServiceImpl" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="jakarta.annotation.Resource" %>
<!DOCTYPE html>
<html>
<head>
    <title>人员信息列表</title>
</head>
<body>
<h1>人员信息列表</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <%
        PersonServiceImpl impl = new PersonServiceImpl();
        System.out.println("!!!!!!!");
        List<Person> persons = impl.findAll();
        if (persons != null) {
            for (Person person : persons) {
                System.out.println(person.getId());
                System.exit(0);
    %>
    <tr>
        <td><%= person.getId() %></td>
        <td><%= person.getName() %></td>
        <td><%= person.getAge() %></td>
        <td>
            <a href="PersonServlet?action=edit&id=<%= person.getId() %>">编辑</a>
            <a href="PersonServlet?action=delete&id=<%= person.getId() %>" onclick="return confirm('确定要删除吗？')">删除</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>