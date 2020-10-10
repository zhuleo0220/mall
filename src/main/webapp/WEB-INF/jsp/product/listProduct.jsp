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
            <td>subtitle</td>
            <td>originalprice</td>
            <td>promoteprice</td>
            <td>stock</td>
            <td>cid</td>
            <td>createdate</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.subtitle}</td>
                <td>${c.originalprice}</td>
                <td>${c.promoteprice}</td>
                <td>${c.stock}</td>
                <td>${c.cid}</td>
                <td>${c.createdate}</td>
                <td><a href="edit?id=${c.id}">编辑</a></td>
                <td><a href="delete?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=1&cid=${cid}">[首  页]</a>
        <a href="?start=${page.pageNum-1}&cid=${cid}">[上一页]</a>
        <a href="?start=${page.pageNum+1}&cid=${cid}">[下一页]</a>
        <a href="?start=${page.pages}&cid=${cid}">[末  页]</a>
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
                    <td>subtitle</td>
                    <td>
                    <input name="subtitle" value="subtitle">
                    </td>
                    </tr>
                    <tr>
                    <td>originalprice</td>
                    <td>
                    <input name="originalprice" value="8347">
                    </td>
                    </tr>
                    <tr>
                    <td>promoteprice</td>
                    <td>
                    <input name="promoteprice" value="234.00">
                    </td>
                    </tr>
                    <tr>
                    <td>stock</td>
                    <td>
                    <input name="stock" value="100">
                    </td>
                    </tr>
                    <tr>
                    <td>cid</td>
                    <td>
                    <input name="cid" value="1">
                    </td>
                    </tr>
               <button type="submit">提交</button>

                </table>

            </form>
        </div>
    </div>
</div>



<%@include file="../include/admin/adminFooter.jsp"%>