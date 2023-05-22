<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2023
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>

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

<link rel="stylesheet" href="mailbox.css">
</head>
<body>
<div class="container">
    <div class=" text-center mt-5 ">
        <h1>Settings</h1>
    </div>
    <div class="row ">
        <div class="col-lg-7 mx-auto">
            <div class="card mt-2 mx-auto p-4 bg-light">
                <div class="card-body bg-light">
                    <div class="container">
                        <div class="controls">
                            <div class="row">
                                <form:form id="contact-form" role="form" action="/mailbox" method="post"
                                           modelAttribute="mailBox">

                                <div class="form-group">
                                    <label>Languages</label>
                                    <form:select path="language" name="language" class="form-control"
                                                 required="required">
                                        <form:options items="${language}"/>
                                    </form:select>
                                </div>

                                <div class="form-group">
                                    <label>Page Size</label>
                                    <form:select path="pageSize" name="pageSize" class="form-control"
                                                 required="required">
                                        <form:options items="${pageSize}"/>
                                    </form:select>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="form_lastname">Spams Filter: </label>
                                        <form:checkbox path="spamsFilter" id="form_lastname"/> Enable
                                        spams
                                        filter
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="form_message"> Signature: </label>
                                        <textarea id="form_message" name="message" class="form-control"
                                                  placeholder="Write your message here." rows="4"
                                                  required="required"
                                                  data-error="Please, leave us a message."></textarea>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-success btn-send  pt-2 btn-block "> Update
                                    </button>
                                    <button type="submit" class="btn btn-success btn-send  pt-2 btn-block "> Cancel
                                    </button>
                                </div>
                            </div>
                        </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>