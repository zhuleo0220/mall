<%--
  Created by IntelliJ IDEA.
  User: zhuruiqing
  Date: 2020/9/11
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<%@include file="../include/admin/adminFooter.jsp"%>

<%
    out.print(session.getAttribute("token"));
%>
<script>
    document.write(sessionStorage.getItem("token"))
</script>
