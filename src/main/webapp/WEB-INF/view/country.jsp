<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>Country</title>
</head>>

<body>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Home Page</a></li>
        <li class="breadcrumb-item"><a href="/createCountry">Create country</a></li>
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

<div class="container">
    <p class="h4">Countries</p>
    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <th scope="col">Id</th>
            </sec:authorize>
            <th scope="col">Name</th>
            <sec:authorize access="hasRole('ROLE_MANAGER')">
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
            </sec:authorize>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="country" items="${country}">
            <tr>
                <th scope="row">${country.id}</th>
                <td>${country.name}</td>
                <td><a href="/updateCountry/${country.id}">update</a></td>
                <td><a href="/deleteCountry/${country.id}">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

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

</body>
</html>














</html>>