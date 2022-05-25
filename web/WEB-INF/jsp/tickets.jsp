<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ include file="index.html" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty requestScope.tickets}">
        <h1>Купленные билеты:</h1>
        <ul>
            <c:forEach var="ticket" items="${requestScope.tickets}">
                <li>${fn:toLowerCase(ticket.seatNo)}</li>
            </c:forEach>
        </ul>
    </c:if>



<%-- NOT USER ANYMORE. REPLACED BY JSTL --%>
<%--        <%--%>
<%--            Long flightId = Long.valueOf(request.getParameter("flightId"));--%>
<%--            List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);--%>
<%--            for (TicketDto ticket : tickets) {--%>
<%--                out.write(String.format("<li>%s</li>", ticket.getSeatNo()));--%>
<%--            }--%>
<%--        %>--%>
</body>
</html>

<%--&lt;%&ndash;should not be used&ndash;%&gt;--%>
<%--<%!--%>
<%--    public void jspInit() {--%>
<%--        System.out.println("hello world");--%>
<%--    }--%>
<%--%>--%>
