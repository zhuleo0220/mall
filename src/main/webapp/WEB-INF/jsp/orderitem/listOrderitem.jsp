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
            <!--<td>数量</td>-->
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
        <a href="?start=1&oid=${oid}">[首  页]</a>
        <a href="?start=${page.pageNum-1}&oid=${oid}">[上一页]</a>
        <a href="?start=${page.pageNum+1}&oid=${oid}">[下一页]</a>
        <a href="?start=${page.pages}&oid=${oid}">[末  页]</a>
         </div>
    <br>


    <div>
        <h1>用户信息</h1><br>
        <a>userId: ${user.id}</a>
        <a>userName: ${user.name}</a>
        <a>userPassword: ${user.password}</a>
    </div>

    <div>
        <h1>订单信息</h1><br>
        <a>orderId: ${order.id}</a>
        <a>orderUid: ${order.uid}</a>
        <a>orderCode: ${order.ordercode}</a>
        <a>orderAdress: ${order.address}</a>
        <a>orderPost: ${order.post}</a>
        <a>orderReceiver: ${order.receiver}</a>
        <a>orderMobile: ${order.mobile}</a>
        <a>orderMessage: ${order.usermessage}</a><br>
        <a>orderCreateDate: ${order.createdate}</a>
    </div>


    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增产品</div>
        <div class="panel-body">

            <form action="add" method="post">
                <table class="addTable">



                    <tr>
                    <td>pid</td>
                    <td>
                    <input name="pid" value="4">
                    </td>
                    </tr>
                    <tr>
                    <td>oid</td>
                    <td>
                    <input name="oid" value="${oid}">
                    </td>
                    </tr>
                    <tr>
                    <td>uid</td>
                    <td>
                    <input name="uid" value="7">
                    </td>
                    </tr>
                    <tr>
                    <td>number</td>
                    <td>
                    <input name="number" value="5">
                    </td>
                    </tr>

               <button type="submit">提交</button>

                </table>

            </form>
        </div>
    </div>
</div>



<%@include file="../include/admin/adminFooter.jsp"%>