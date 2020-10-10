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
            <tr>
                <td>ordercode</td>
                <td>
                    <input name="ordercode" value="${pb.ordercode}">
                </td>
            </tr>
            <tr>
                <td>address</td>
                <td>
                    <input name="address" value="${pb.address}">
                </td>
            </tr>
            <tr>
                <td>post</td>
                <td>
                    <input name="post" value="${pb.post}">
                </td>
            </tr>
            <tr>
                <td>receiver</td>
                <td>
                    <input name="receiver" value="${pb.receiver}">
                </td>
            </tr>
            <tr>
                <td>mobile</td>
                <td>
                    <input name="mobile" value="${pb.mobile}">
                </td>
            </tr>
            <tr>
                <td>usermessage</td>
                <td>
                    <input name="usermessage" value="${pb.usermessage}">
                </td>
            </tr>
            <tr>
                <td>uid</td>
                <td>
                    <input name="uid" value="${pb.uid}">
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