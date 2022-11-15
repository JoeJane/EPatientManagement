<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/style.css" rel="stylesheet">
    <style>
        .hide {
            display: none;
        }
        .show {
            display: block;
        }
    </style>
</head>

<body class="text-center">

<main class="form-signin ${error != null ? 'has-error' : ''}">
    <form method="post" data-form-type="login" id="login_form">
        <img class="mb-4" src="/resources/images/logo.png" alt="" width="72"
             height="57">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
        <div class="alert alert-success ${message != null ? 'show' : 'hide'}" role="alert">
            ${message}
        </div>

        <div class="form-floating">
            <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com"
                   data-form-type="email" >
            <label for="email">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                   data-form-type="password" >
            <label for="password">Password</label>
        </div>
        <div class="alert alert-danger ${error != null ? 'show' : 'hide'}" role="alert">
            ${error}
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit" data-dashlane-label="true"
                data-form-type="action,login">Sign in
        </button>
        
    </form>
</main>
</body>
</html>
