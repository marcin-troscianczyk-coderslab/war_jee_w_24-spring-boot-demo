<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
  <sec:authorize access="isAuthenticated()">
    <p>Jesteś zalogowany jako <sec:authentication property="principal.username"/></p>
    <a href="#">Wyloguj</a>
  </sec:authorize>
  <sec:authorize access="not isAuthenticated()">
    <a href="<c:url value='/login'/>">Zaloguj</a>
  </sec:authorize>
</div>