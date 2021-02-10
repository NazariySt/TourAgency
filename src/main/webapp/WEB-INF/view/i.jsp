<%--
  Created by IntelliJ IDEA.
  User: Docker
  Date: 10.02.2021
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Hello</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/registration">Registration</a></li>
        <li class="breadcrumb-item"><a href="/login">Login</a></li>
    </ol>
</nav>
<div class="container">
    </sec:authorize>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <li class="breadcrumb-item"><a href="/country">Countries</a></li>
                <li class="breadcrumb-item"><a href="/hotel">Hotels</a></li>
                <li class="breadcrumb-item"><a href="/user">Users</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <li class="breadcrumb-item"><a href="/profile">Profile</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div style="margin-left: 80%">
                    <form action="logout" method="post">
                        <button class="btn btn-primary">logout</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </sec:authorize>
        </ol>
    </nav>
    <br>
    <div style="text-align: center">
        <h3 style="text-align: center">Show hotels by country</h3>
        <form action="/showCountryHotels" method="get">
            <select name="countryId" class="form-control">
                <option value="1">choose country</option>
                <c:forEach var="country" items="${countries}">
                    <option value="${country.id}">${country.name}</option>
                </c:forEach>
            </select>
            <br>
            <button class="btn btn-primary">submit</button>
        </form>
    </div>

    <div style="text-align: center">
        <h3 style="text-align: center">Book room in a hotel</h3>
        <form action="/booking" method="get">
            <select name="hotelId" class="form-control">
                <option value="1">choose hotel</option>
                <c:forEach var="hotel" items="${hotels}">
                    <option value="${hotel.id}">${hotel.country.name} ${hotel.name}</option>
                </c:forEach>
            </select>
            <br>
            <label class="h4" for="dateFrom">date from</label>
            <input id="dateFrom" name="dateFrom" type="date">
            <label class="h4" for="dateTo">date to</label>
            <input id="dateTo" name="dateTo" type="date">
            <br>
            <br>
            <button class="btn btn-primary">submit</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
