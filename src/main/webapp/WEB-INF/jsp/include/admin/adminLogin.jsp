<%@ page import="com.macro.mall.tiny.mbg.model.User" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <a class="navbar-brand" href="/login">login</a>
<c:if test="${sessionScope.SPRING_SECURITY_CONTEXT!=null}">
    你好，${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}
</c:if>
    <a class="navbar-brand" href="/logout">logout</a>



