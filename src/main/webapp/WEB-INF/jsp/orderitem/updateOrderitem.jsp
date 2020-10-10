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
        <table class="addTable">
            <tr><td>name</td><td><input name="name" value="${pb.name}"></td></tr>
            <tr><td>cid:</td><td><input name="cid" value="${pb.cid}"></td></tr>
            <tr><td>subtitle</td><td><input name="subtitle" value="${pb.subtitle}"></td></tr>
            <tr><td>originalprice</td><td><input name="originalprice" value="${pb.originalprice}"></td></tr>
            <tr><td>promoteprice</td><td><input name="promoteprice" value="${pb.promoteprice}"></td></tr>
            <tr><td>stock</td><td><input name="stock" value="${pb.stock}"></td></tr>
            <tr><td>createdate</td><td><input name="createdate" value="${pb.createdate}"></td></tr>

            <tr class="submitTR">
                <td colspan="2" align="center">
                    <input type="hidden" name="id" value="${pb.id}">
                    <button type="submit" class="btn btn-success">提 交</button>
                </td>
            </tr>
        </table>

    </form>

</div>