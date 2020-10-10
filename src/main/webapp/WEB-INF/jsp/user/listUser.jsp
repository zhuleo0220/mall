<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>password</td>
            <td>role</td>

            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.password}</td>
                <td>${c.role}</td>
                <td><a href="edit?id=${c.id}">编辑</a></td>
                <td><a href="delete?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=1">[首  页]</a>
        <a href="?start=${page.pageNum-1}">[上一页]</a>
        <a href="?start=${page.pageNum+1}">[下一页]</a>
        <a href="?start=${page.pages}">[末  页]</a>
         </div>
    <br>

    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增产品</div>
        <div class="panel-body">

            <form action="add" method="post">
                <table class="addTable">


                    <tr>
                    <td>name</td>
                    <td>
                    <input name="name" value="product">
                    </td>
                    </tr>
                    <tr>
                    <td>password</td>
                    <td>
                    <input name="password" value="password">
                    </td>
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
        </div>
    </div>
</div>



<%@include file="../include/admin/adminFooter.jsp"%>