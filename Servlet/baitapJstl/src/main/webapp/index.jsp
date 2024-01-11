<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table {
            border-collapse: collapse;
        }
        th, td {
            border-bottom: 1px solid black;
        }
    </style>
</head>

<body>
<h1 style="text-align: center">Danh sách khách hàng</h1>
<table style="text-align: center;"width="90%">
    <tr>
        <th>
            Tên
        </th>
        <th>
            Ngày sinh
        </th>
        <th>
            Địa chỉ
        </th>
        <th>
            Ảnh
        </th>
    </tr>
    <tr>
        <td>
            Mai Văn Hoàn
        </td>
        <td>
            1983-08-20
        </td>
        <td>
            Hà Nội
        </td>
        <Td>
            <img height="50px" width="50px" src="https://i1-dulich.vnecdn.net/2021/07/16/1-1626437591.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=BWzFqMmUWVFC1OfpPSUqMA">
        </Td>
    </tr>
    <tr>
        <td>
            Nguyễn Văn Nam
        </td>
        <td>
            1983-08-21
        </td>
        <td>
            Bắc Giang
        </td>
        <Td>
            <img width="50px" height="50px" src="https://i1-dulich.vnecdn.net/2021/07/16/5-1-1626444925.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=mmscdWDLSOMShH-tYwJ4Ig">
        </Td>
    </tr>

    </tr>
</table>
</body>
</html>