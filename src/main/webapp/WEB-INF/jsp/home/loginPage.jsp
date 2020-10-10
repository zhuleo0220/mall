<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<h1>loginPage</h1>
<a class="navbar-brand" href="/home/registerPage">register</a>


<h1>${msg}</h1>


<form action="login" method="post">
    <table class="addTable">


        <tr>
            <td>name</td>
            <td>
                <input name="name" value="">
            </td>
        </tr>
        <tr>
            <td>password</td>
            <td>
                <input name="password" value="password">
            </td>
        </tr>

        <button type="submit">提交</button>

    </table>

</form>