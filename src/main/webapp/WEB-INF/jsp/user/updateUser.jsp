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
            <tr><td>password:</td><td><input name="password" value="${pb.password}"></td></tr>
            <tr>
                <td>role</td>
                <td>
                    <input type='radio' name="role" value="admin" checked="checked">admin
                    <input type='radio' name="role" value="employee" checked="checked">employee
                </td>
            </tr>
            <tr class="submitTR">
                <td colspan="2" align="center">
                    <input type="hidden" name="id" value="${pb.id}">
                    <button type="submit" class="btn btn-success">提 交</button>
                </td>
            </tr>
        </table>

    </form>

</div>