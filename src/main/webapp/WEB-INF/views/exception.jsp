<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Spring MVC 5 Demo</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <base href="<%=basePath%>"/>
</head>
<body>
<div class="container">
    <a href="<%=basePath%>">Back to home</a><br/><br/><br/>

    <ul>
        <li><a href="exception/internalTriggerNonJSONException">internalTriggerNonJSONException</a></li>
        <li><a href="exception/internalTriggerNumberFormatException">internalTriggerNumberFormatException</a></li>
        <li><a href="exception/triggerStudentNotFoundException">triggerStudentNotFoundException</a></li>
        <li><a href="exception/triggerArrayIndexOutOfBoundsException">triggerArrayIndexOutOfBoundsException</a></li>
        <li><a href="exception/triggerSimpleMappingExceptionResolverDefaultErrorView">triggerSimpleMappingExceptionResolverDefaultErrorView</a></li>
        <li><a href="exception/SUPPOSE_NOT_FOUND_PAGE">Suppose no handler page, this is 404</a></li>
    </ul>
</div>
</body>
</html>
