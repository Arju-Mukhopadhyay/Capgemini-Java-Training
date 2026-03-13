<%-- Page Section  --%>

<%@ page import= "java.util.*"%>

<%-- Variable Declaration Section  --%>

<%! int age; %>

<%! String name; %>

<%! double stipend; %>


<%--  Scriplet Section--%>

<%

age = 21;
name = "Tarun";
stipend = 20000.00D;

%>

<%--  Expression Section--%>


Age:  <%=age%>   <br/>
Name:  <%=name%>  <br/>
Stipend:  <%=stipend%>