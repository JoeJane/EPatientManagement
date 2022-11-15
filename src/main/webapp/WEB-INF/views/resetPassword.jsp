<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Reset Password</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/volt.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="/resources/images/logo.png" alt="">
            <span class="d-none d-lg-block">E-Patient</span>
        </a>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
            <li class="nav-item dropdown">
                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="fa-solid fa-house"></i>
                </a><!-- End Notification Icon -->
            </li><!-- End Notification Nav -->

            <li class="nav-item dropdown pe-3">
                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="/resources/images/profile-img.jpg" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="fa-regular fa-user"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                            <i class="fa-regular fa-circle-question"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <i class="fa-solid fa-arrow-right-from-bracket"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>
                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->
        </ul>
    </nav><!-- End Icons Navigation -->
</header><!-- End Header -->

<main id="main" class="main">
    <div class="container">
        <div class="row justify-content-center form-bg-image">
            <p class="text-center">
                <a href="./sign-in.html" class="d-flex align-items-center justify-content-center">
                    <i class="fa-solid fa-arrow-left-long"></i>&nbsp; Back to log in</a>
            </p>

            <div class="col-12 d-flex align-items-center justify-content-center">
                <div class="bg-white shadow border-0 rounded p-4 p-lg-5 w-100 fmxw-500">
                    <h1 class="h3 mb-4">Reset password</h1>
                    <form action="#">
                        <div class="mb-4"><label for="email">Username</label>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="example@company.com" id="email" required="" disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group mb-4">
                            <label for="password">Password</label>
                            <div class="input-group">
                                <span class="input-group-text" id="basic-addon1">
                                    <i class="fa-solid fa-lock"></i>
                                </span>
                                <input type="password" placeholder="Password" class="form-control" id="password" required=""></div>
                        </div>
                        <div class="form-group mb-4">
                            <label for="confirm_password">Confirm Password</label>
                            <div class="input-group">
                                <span class="input-group-text" id="basic-addon2">
                                    <i class="fa-solid fa-lock"></i>
                                </span>
                                <input type="password" placeholder="Confirm Password" class="form-control" id="confirm_password" required=""></div>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-gray-800">Reset password</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main><!-- End #main -->

<script src="/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>