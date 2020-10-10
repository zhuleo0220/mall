<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div class="navitagorDiv">
    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">

        <a class="navbar-brand" href="/home/">后台</a>
        <a class="navbar-brand" href="/category/listAll">分类管理</a>
        <a class="navbar-brand" href="/product/listAll">商品管理</a>
        <a class="navbar-brand" href="/user/listAll">用户管理</a>
        <a class="navbar-brand" href="/order/listAll">订单管理</a>
        <a class="navbar-brand" href="/orderitem/listAll">订单物品管理</a>
        </nav>
    <input type="button" name="back" value="上一页" onclick="JavaScript:history.back(-2);"/>
</div>
<%@include file="adminLogin.jsp"%>