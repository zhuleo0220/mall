<%--
  Created by IntelliJ IDEA.
  User: zhuruiqing
  Date: 2020/9/11
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../include/admin/adminNavigator.jsp"%>

<div>

    <form action="update" method="post">

        name: <input name="name" value="${pb.name}"> <br>
        <input name="id" value="${pb.id}" type="hidden">
        <button type="submit">提交</button>

    </form>

</div>