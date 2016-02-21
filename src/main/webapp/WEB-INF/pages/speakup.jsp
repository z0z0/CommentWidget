<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>These are YOUR comments</h3>
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