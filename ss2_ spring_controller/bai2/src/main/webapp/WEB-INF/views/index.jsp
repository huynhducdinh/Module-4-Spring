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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
<!-- Google Fonts -->
<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
      rel="stylesheet"/>
<!-- MDB -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
      rel="stylesheet"/>
<link rel="stylesheet" href="index.css">


</head>
<body>

<div style="width: 500px; height: auto; margin: 50px auto; text-align: center ; border: 1px solid gray; border-radius: 5px">
    <h1 style="margin-top: 5%">Calculator Controller</h1>
    <form action="/calculator" method="post" style="text-align: left; margin-top: 5%;">
        <div class="row">
            <div class="col-sm-6" style="margin-left: 5%; width: 42.3%;">
                <div class="wrapper" style="display: flex">
                    <input required type="number" name="numberOne" />

                </div>
            </div>
            <div class="col-sm-6" style="margin-left: 5%; width: 42.3%;">
                <div class="wrapper" style="display: flex">

                    <input required type="number" name="numberTwo"  />
                </div>

            </div>
        </div>
        <hr>
        <div style="text-align: center">
            <button type="submit" name="action" value="addition" class="btn btn-primary btn-block mb-4" style="width: 100px">Add(+)</button>
            <button type="submit" name="action" value="subtraction" class="btn btn-primary btn-block mb-4" style="width: 100px">Sub(-)</button>
            <button type="submit" name="action" value="multiplication" class="btn btn-primary btn-block mb-4" style="width: 100px">Mul(*)</button>
            <button type="submit" name="action" value="division" class="btn btn-primary btn-block mb-4" style="width: 100px">Div(/)</button>
        </div>
    </form>
    <h3> Result: ${result}</h3>
</div>
</body>
</html>