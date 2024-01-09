<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="login/styles.css">
    <title>Document</title>
</head>
<style>

</style>
<body>
    <div class="login">
        <div class="left">
            <h1 style="color: #0866ff;">facebook <br>
                <img src="https://png.pngtree.com/element_our/md/20180506/md_5aeedeff67ded.jpg" alt="">
            </h1>
        </div>
        <div class="right">
            <form action="/43" method="post">
                <input type="text" name="username" placeholder="Email hoặc SĐT"><br>
                <input type="password" name="password" placeholder="Mật khẩu"><br>
                <input type="submit" name="" id="" value="Đăng nhập"><br>
                <a class="forget" href="">Quên mật khẩu?<a><br><br>
                <a class="create" href="">Tạo tài khoản mới</a>
                <img src="login/img/close-eye.png" alt="">
            </form>
        </div>
    </div>
</body>
<script src="login/js/showpassword.js"></script>
</html>