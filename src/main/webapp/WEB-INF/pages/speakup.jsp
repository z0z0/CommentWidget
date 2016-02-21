<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h3>Speak Your Mind</h3>

<c:url var="addAction" value="/speakup/add" ></c:url>

<form:form action="${addAction}" commandName="comment">
    <table>
        <c:if test="${!empty comment.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="text">
                    <spring:message text="Text"/>
                </form:label>
            </td>
            <td>
                <form:textarea path="text" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty comment.name}">
                    <input type="submit"
                           value="<spring:message text="Add Person\"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>






<c:if test="${!empty listComments}">
    <table class="tg">
        <tr>
            <th width="120">Name</th>
            <th width="120">Comment</th>
            <th width="120">Posted</th>
        </tr>
        <c:forEach items="${listComments}" var="comment">
            <tr>
                <td>${comment.name}</td>
                <td>${comment.text}</td>
                <td>${comment.posted}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>