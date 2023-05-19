<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2023
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create</title>

</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"/>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"/>
<!-- MDB -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
      rel="stylesheet"/>

<style>
    #add {
        width: 40vw;
        margin: 0 auto;
        text-align: center;
    }

    input {
        width: 200vw;
    }

    .text_left {
        text-align: left;
    }

    label {
        left: 10%;
    }
</style>
</head>
<body>

<div class="container" style="margin-top: 5%;width: 50%">
    <div class="card">
        <div class="form">
        </div>
        <div class="right-side">
            <div class="top-div">
                <h1 style="text-align: center;margin-top: 5%">Chuyển Đổi Tiền Tệ </h1>
                <div id="add">
                    <form action="/" method="" class="text_left ">
                        <div class=" mb-4">
                            <label class="form-label" style="color:black;"> Nhập giá tiền (USD)</label>
                            <input required type="number" id="form6Example7" value="" name="usd" class="form-control"/>
                        </div>
                        <div class=" mb-4">
                            <label class="form-label" style="color:black;"> Tỉ giá tiền </label>
                            <select name="vnd" class="form-control" style="border: 1px solid #CCCCCC">
                                <option value="23606">USD (23,606 VND)</option>
                                <option value="29190">GBP (29,190 VND)</option>
                                <option value="25365">EUR (25,365 VND)</option>
                                <option value="170279">JPY (170.27900 VND)</option>
                                <option value="17558">KRW (17.55850 VND)</option>
                            </select>
                            <%--                            <input required type="number" id="form6Example8" name="vnd" value="" class="form-control"/>--%>
                        </div>
                        <button type="submit" class="btn btn-primary  mb-4" style="width: 50%;margin-left: 25%">Result
                        </button>
                    </form>
                </div>
                <h2 style="text-align: center">Result : ${result} vnd</h2>
            </div>
        </div>
    </div>
</div>
</body>
</html>