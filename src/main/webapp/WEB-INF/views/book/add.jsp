<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add book</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="../header.jsp"/>

<sec:authorize access="hasRole('ADMIN')">
    <h3>Add book</h3>

    <form:form method="post" modelAttribute="book">

        <div>Title: <form:input path="title"/><form:errors path="title" cssClass="error"/></div>
        <div>Description: <form:input path="description"/><form:errors path="description" cssClass="error"/></div>
        <div>Rating: <form:input path="rating" type="number" min="1" max="10"/><form:errors path="rating" cssClass="error"/></div>
        <div>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><form:errors
                path="publisher" cssClass="error"/></div>
        <div>Authors: <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id"
                                   multiple="true"/><form:errors path="authors" cssClass="error"/></div>
        <div>Pages: <form:input path="pages" type="number" min="1" placeholder="Podaj liczbę stron"/><form:errors path="pages" cssClass="error"/></div>
        <div>Category: <form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id"/><form:errors
                path="category" cssClass="error"/></div>
        <input type="submit" value="Add book">
    </form:form>
</sec:authorize>
<sec:authorize access="not hasRole('ADMIN')">
    <p>You are not authorized. Please contact your administrator..</p>
</sec:authorize>
</body>
</html>
