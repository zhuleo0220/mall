<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--
<html>
    <%
    String path = request.getRequestURI();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<base href="<%=basePath%>">
    -->
<head>

    <script>
        //自定义的函数
        function checkEmpty(id,name) {
            var value=$("#"+id).val();
            if(value.length==0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        function checkNumber(id,name) {
            var value=$("#"+id).val();
            if(value.length==0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            if(isNaN(value)){
                alert(name+"必须是数字");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        function checkInt(id,name){
            var value=$("#"+id).val();
            if(value.length==0){
                alert(name+"不能为空");
                $("#"+id)[0].focus();
                return false;
            }
            if(parseInt(value)!=value){
                alert(name+"必须是整数");
                $("#"+id)[0].focus();
                return false;
            }
            return true;
        }
        $(function(){
            $("a").click(function(){
                var deleteLink=$(this).attr("deleteLink");
                console.log(deleteLink);
                if("true"==deleteLink){
                    var confimDelete=confirm("确认要删除");
                    //如果用户点击确定按钮，则 confirm() 返回 true。如果点击取消按钮，则 confirm() 返回 false。
                    if(confimDelete)
                        return true;//链接被传递
                    return false;
                }
            });
        });
        function getSubPost(para, obj, callback) {
            const IP = Base.prefixUrl + para;
            axios.post(IP, obj, { headers: { Authorization: `Bearer ${Base.token}` } }).then((res) => {
                callback(res.data);
            }).catch((error) => {
                if (error.response.status != '504') {
                    callback({ message: `请求接口报错！错误码：${error.response.status}` });
                } else {
                    callback({ message: '请求超时，请重试。' });
                }
            });
        }

    </script>


</head>
<%

    response.addHeader("Authorization","Bearer"+ session.getAttribute("token"));
%>
<body>