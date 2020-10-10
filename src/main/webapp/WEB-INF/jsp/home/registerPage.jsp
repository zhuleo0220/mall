<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>


<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<h1>${msg}</h1>


<form action="register" method="post">
    <table class="addTable">


        <tr>
            <td>name</td>
            <td>
                <input name="name" value="adminNew">
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td>
                <input name="password" value="password">
            </td>
        </tr>
        <tr>
            <td>role</td>
            <td>
                <input type='radio' name="role" value="admin" checked="checked">admin
                <input type='radio' name="role" value="employee" checked="checked">employee
            </td>
        </tr>

        <button type="submit">提交</button>

    </table>

</form>