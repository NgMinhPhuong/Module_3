<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/login1.css">
    <title>Document</title>
</head>
<body>
    <div class="login">
        <div class="left">
            <h1 style="color: #0866ff;">facebook <br>
                <img src="https://png.pngtree.com/element_our/md/20180506/md_5aeedeff67ded.jpg" alt="">
            </h1>
        </div>
        <div class="right">
            <form  action="/login" method="post">
                <input type="hidden" name="action" value="login">
                <input type="text" name="username" placeholder="Email hoặc SĐT"><br>
                <input type="password" name="password" placeholder="Mật khẩu"><br>
                <input type="submit" name="" id="" value="Đăng nhập"><br>
                <a class="forget" href="">Quên mật khẩu?</a><br><br>
                <a class="create" href="">Tạo tài khoản mới</a>
                <img src="resources/img/login1/close-eye.png" alt=""/>
            </form>
        </div>
    </div>

    <div class="register">
        <div class="register1">
            <div>Tài khoản</div>
            <div>Mật khẩu</div>
            <div>Tên hiển thị</div>
            <div>Ảnh đại diện</div>
        </div>
        <div class="register2">
            <input name="username_regi">
            <input name="password_regi">
            <input name="name_regi">
            <input name="image_regi" placeholder="Chèn địa chỉ ảnh">
            <button>Tạo tài khoản</button>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/login1.js"></script>
</body>


</html>