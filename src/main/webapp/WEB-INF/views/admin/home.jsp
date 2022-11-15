<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Home</title>

    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">

    <link href="/resources/css/style.css" rel="stylesheet">
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
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center py-4">
        <div class="d-block mb-4 mb-md-0">
            <h2 class="h4">Users List</h2>
            <p class="mb-0">Your web analytics dashboard template.</p></div>
        <div class="btn-toolbar mb-2 mb-md-0">
            <a href="#" class="btn btn-sm btn-gray-800 d-inline-flex align-items-center">
                <i class="fa-solid fa-plus"></i>&nbsp;&nbsp;New User</a>
        </div>
    </div>

    <div class="table-settings mb-4">

        <div class="row justify-content-between align-items-center">
            <div class="col-9 col-lg-8 d-md-flex">
                <div class="input-group me-2 me-lg-3 fmxw-300">
                    <span class="input-group-text">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </span>
                    <input type="text" class="form-control" placeholder="Search users">
                </div>
                <select class="form-select fmxw-200 d-none d-md-inline" aria-label="Message select example 2">
                    <option selected="selected">All</option>
                    <option value="1">Active</option>
                    <option value="2">Inactive</option>
                    <option value="3">Pending</option>
                    <option value="3">Cancelled</option>
                </select>
            </div>
            <div class="col-3 col-lg-4 d-flex justify-content-end">
                <div class="btn-group">
                    <div class="dropdown me-1">
                        <button class="btn btn-link text-dark dropdown-toggle dropdown-toggle-split m-0 p-1" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa-solid fa-gear fa-xl"></i>
                            <span class="visually-hidden">Toggle Dropdown</span>
                        </button>
                        <div class="dropdown-menu dropdown-menu-end pb-0">
                            <span class="small ps-3 fw-bold text-dark">Show</span>
                            <a class="dropdown-item d-flex align-items-center fw-bold" href="#">10 <svg class="icon icon-xxs ms-auto" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"></path></svg>
                            </a>
                            <a class="dropdown-item fw-bold" href="#">20</a>
                            <a class="dropdown-item fw-bold rounded-bottom" href="#">30</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="card card-body shadow border-0 table-wrapper table-responsive">
        <div class="d-flex mb-3">
            <select class="form-select fmxw-200" aria-label="Message select example">
                <option selected="selected">Bulk Action</option>
                <option value="1">Send Email</option>
                <option value="2">Change Group</option>
                <option value="3">Delete User</option>
            </select>
            <button class="btn btn-sm px-3 btn-secondary ms-3">Apply</button>
        </div>
        <table class="table user-table table-hover align-items-center">
            <thead>
            <tr>
                <th class="border-bottom">
                    <div class="form-check dashboard-check">
                        <input class="form-check-input" type="checkbox" value="" id="userCheck55">
                        <label class="form-check-label" for="userCheck55"></label>
                    </div>
                </th>
                <th class="border-bottom">Name</th>
                <th class="border-bottom">Date Created</th>
                <th class="border-bottom">Verified</th>
                <th class="border-bottom">Status</th>
                <th class="border-bottom">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <div class="form-check dashboard-check">
                        <input class="form-check-input" type="checkbox" value="" id="userCheck1">
                        <label class="form-check-label" for="userCheck1"></label>
                    </div>
                </td>

                <td>
                    <a href="#" class="d-flex align-items-center">
                        <div class="avatar d-flex align-items-center justify-content-center fw-bold rounded bg-secondary me-3">
                            <span>RF</span>
                        </div>
                        <div class="d-block"><span class="fw-bold">Roy Fendley</span>
                            <div class="small text-gray">info@example.com</div>
                        </div>
                    </a>
                </td>
                <td><span class="fw-normal">10 Feb 2020</span></td>
                <td><span class="fw-normal d-flex align-items-center"><i class="fa-solid fa-circle-check text-success"></i>&nbsp; Email</span></td>
                <td><span class="fw-normal text-success">Active</span></td>
                <td>
                    <div class="btn-group">
                        <button class="btn btn-link text-dark dropdown-toggle dropdown-toggle-split m-0 p-0" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa-solid fa-ellipsis fa-lg"></i> <span class="visually-hidden">Toggle Dropdown</span>
                        </button>
                        <div class="dropdown-menu dashboard-dropdown dropdown-menu-start mt-2 py-1">
                            <a class="dropdown-item d-flex align-items-center" href="#"><i class="fa-solid fa-unlock"></i> Reset Pass </a>
                            <a class="dropdown-item d-flex align-items-center" href="#"><i class="fa-solid fa-eye"></i> View Details </a>
                            <a class="dropdown-item d-flex align-items-center" href="#"><i class="fa-solid fa-user-xmark text-danger"></i> Suspend</a>
                        </div>
                    </div>
                    &nbsp;<i class="fa-solid fa-circle-xmark text-danger"></i>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="form-check dashboard-check">
                        <input class="form-check-input" type="checkbox" value="" id="userCheck2">
                        <label class="form-check-label" for="userCheck2"></label>
                    </div>
                </td>
                <td>
                    <a href="#" class="d-flex align-items-center">
                        <div class="avatar d-flex align-items-center justify-content-center fw-bold rounded bg-secondary me-3">
                            <span>SA</span>
                        </div>
                        <div class="d-block"><span class="fw-bold">Scott Anderson</span>
                            <div class="small text-gray">info@example.com</div>
                        </div>
                    </a>
                </td>
                <td><span class="fw-normal">10 Feb 2020</span></td>
                <td><span class="fw-normal d-flex align-items-center"><i class="fa-solid fa-circle-check text-success"></i>&nbsp;  Email</span></td>
                <td><span class="fw-normal text-success">Active</span></td>
                <td>
                    <div class="btn-group">
                        <button class="btn btn-link text-dark dropdown-toggle dropdown-toggle-split m-0 p-0" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa-solid fa-ellipsis fa-lg"></i> <span class="visually-hidden">Toggle Dropdown</span>
                        </button>
                        <div class="dropdown-menu dashboard-dropdown dropdown-menu-start mt-2 py-1">
                            <a class="dropdown-item d-flex align-items-center" href="#"><i class="fa-solid fa-unlock"></i> Reset Pass </a>
                            <a class="dropdown-item d-flex align-items-center" href="#"><i class="fa-solid fa-eye"></i> View Details </a>
                            <a class="dropdown-item d-flex align-items-center" href="#"><i class="fa-solid fa-user-xmark text-danger"></i> Suspend</a>
                        </div>
                    </div>
                    &nbsp;<i class="fa-solid fa-circle-xmark text-danger"></i>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="card-footer px-3 border-0 d-flex flex-column flex-lg-row align-items-center justify-content-between">
            <nav aria-label="Page navigation example">
                <ul class="pagination mb-0">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
            <div class="fw-normal small mt-4 mt-lg-0">Showing <b>5</b> out of <b>25</b> entries</div>
        </div>
    </div>


    <%--<section class="section profile">
        <div class="row">
            <div class="col-xl-12">

                <div class="card">
                    <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                        <img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                        <h2>Kevin Anderson</h2>
                        <h3>Web Designer</h3>
                        <div class="social-links mt-2">
                            <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                            <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </section>--%>


</main><!-- End #main -->

<script src="/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>