<%@ page import="dmdev.http_servlets.service.TicketService" %>
<%@ page import="dmdev.http_servlets.dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://mycompany.com" %>--%>
<%--<%@ include file="index.html" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Купленные билеты:</h1>
    <ul>
        <%
            Long flightId = Long.valueOf(request.getParameter("flightId"));
            List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
            for (TicketDto ticket : tickets) {
                out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
            }
        %>
    </ul>
</body>
</html>

<%--should not be used--%>
<%!
    public void jspInit() {
        System.out.println("hello world");
    }
%>
