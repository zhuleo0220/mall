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
            <td>uid</td>
            <td>ordercode</td>
            <td>address</td>
            <td>post</td>
            <td>receiver</td>
            <td>mobile</td>
            <td>usermessage</td>
            <td>createdate</td>
            <td>编辑</td>
            <td>删除</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.uid}</td>
                <td>${c.ordercode}</td>
                <td>${c.address}</td>
                <td>${c.post}</td>
                <td>${c.receiver}</td>
                <td>${c.mobile}</td>
                <td>${c.usermessage}</td>
                <td>${c.createdate}</td>
                <td><a href="edit?id=${c.id}">编辑</a></td>
                <td><a href="delete?id=${c.id}">删除</a></td>
                <td><a href="/orderitem/listAll?oid=${c.id}">详情</a></td>
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
                    <td>ordercode</td>
                    <td>
                    <input name="ordercode" value="KDI938372">
                    </td>
                    </tr>
                    <tr>
                    <td>address</td>
                    <td>
                    <input name="address" value="address">
                    </td>
                    </tr>
                    <tr>
                    <td>post</td>
                    <td>
                    <input name="post" value="200125">
                    </td>
                    </tr>
                    <tr>
                    <td>receiver</td>
                    <td>
                    <input name="receiver" value="收件人">
                    </td>
                    </tr>
                    <tr>
                    <td>mobile</td>
                    <td>
                    <input name="mobile" value="18992876374">
                    </td>
                    </tr>
                    <tr>
                    <td>usermessage</td>
                    <td>
                    <input name="usermessage" value="用户备注信息">
                    </td>
                    </tr>
                    <tr>
                        <td>uid</td>
                        <td>
                            <input name="uid" value="1">
                        </td>
                    </tr>
               <button type="submit">提交</button>

                </table>

            </form>
        </div>
    </div>
</div>



<%@include file="../include/admin/adminFooter.jsp"%>