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
    <h1 style="margin-top: 5%">Sandwich Condiments</h1>
    <form action="/spiceList" method="post" style="text-align: left; margin-top: 5%;">
        <div class="row">
            <div class="col-sm-6" style="margin-left: 28%; width: 42.3%">
                <ul class="list-group">
                    <li class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" value="Lettuce" name="spice" aria-label="...">
                        Lettuce
                    </li>
                    <li class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" value="Tomato" name="spice" aria-label="...">
                        Tomato
                    </li>
                    <li class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" value="Mustard" name="spice" aria-label="...">
                        Mustard
                    </li>
                    <li class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" value="Sprouts" name="spice" aria-label="...">
                        Sprouts
                    </li>
                </ul>
            </div>

        </div>
        <hr>
        <div style="text-align: center">
            <button type="submit" class="btn btn-secondary btn-block mb-4" style="width: 100px">SAVE</button>
        </div>
    </form>
    <h3>Your Sandwich Has: </h3>
    <c:forEach var="spice" items="${spice}">
    <h4 style="display:inline;color: blue">${spice}, </h4>
    </c:forEach>


</body>
</html>