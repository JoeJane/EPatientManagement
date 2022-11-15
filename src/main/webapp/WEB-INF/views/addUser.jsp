<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Add User</title>

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
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center py-4">
        <div class="d-block mb-4 mb-md-0">
            <h2 class="h4">Add User</h2>
        </div>
    </div>

    <div class="container pt-3">
        <div class="row align-items-center">
            <div class="col">
                <div class="card card-body border-0 shadow mb-4"><h2 class="h5 mb-4">General information</h2>
                    <form>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="first_name">Username</label>
                                <input class="form-control" id="username" type="text" placeholder="Enter user name" required="">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="last_name">Password</label>
                                <input class="form-control" id="password" type="password" placeholder="Password" required="">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="first_name">First Name</label>
                                <input class="form-control" id="first_name" type="text" placeholder="Enter your first name" required="">
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="last_name">Last Name</label>
                                <input class="form-control" id="last_name" type="text" placeholder="Also your last name" required="">
                            </div>
                        </div>
                        <div class="row align-items-center">
                            <div class="col-md-6 mb-3">
                                <label for="gender">Role</label>
                                <select class="form-select mb-0" id="role" aria-label="Select Role">
                                    <option selected="selected">Role</option>
                                    <option value="DOCTOR">Doctor</option>
                                    <option value="PATIENT">Patient</option>
                                    <option value="RECEPTIONIST">Receptionist</option>
                                    <option value="LAB_ASSISTANT">Lab Assistant</option>
                                    <option value="NURSE">Nurse</option>
                                </select>
                            </div>
                        </div>

                        <div class="row align-items-center">
                            <div class="col-md-6 mb-3"><label for="birthday">Date of Birth</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="fa-regular fa-calendar-days"></i> </span>
                                    <input data-datepicker="" class="form-control datepicker-input" id="birthday" type="text" placeholder="dd/mm/yyyy" required="">
                                </div>
                            </div>
                            <div class="col-md-6 mb-3"><label for="gender">Gender</label> <select
                                    class="form-select mb-0" id="gender" aria-label="Gender select example">
                                <option selected="selected">Gender</option>
                                <option value="1">Female</option>
                                <option value="2">Male</option>
                            </select></div>
                        </div>
                        <div class="row align-items-center">
                            <div class="col-md-6 mb-3"><label for="gender">Blood Group</label>
                                <select class="form-select mb-0" id="blood_group" aria-label="Blood Group">
                                    <option selected="selected">Blood Group</option>
                                    <option value="A+">A+</option>
                                    <option value="A+">A+</option>
                                    <option value="B+">B+</option>
                                    <option value="B-">B-</option>
                                    <option value="AB+">AB+</option>
                                    <option value="AB-">AB-</option>
                                    <option value="O+">O+</option>
                                    <option value="O-">O-</option>
                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input class="form-control" id="email" type="email" placeholder="name@company.com" required="">
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="phone">Phone</label>
                                    <input class="form-control" id="phone" type="number" placeholder="+12-345 678 910" required="">
                                </div>
                            </div>
                        </div>
                        <h2 class="h5 my-4">Location</h2>
                        <div class="row">
                            <div class="col-sm-9 mb-3">
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <input class="form-control" id="address" type="text" placeholder="Enter your home address" required="">
                                </div>
                            </div>
                            <div class="col-sm-3 mb-3">
                                <div class="form-group">
                                    <label for="number">Number</label>
                                    <input class="form-control" id="number" type="number" placeholder="No." required="">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 mb-3">
                                <div class="form-group">
                                    <label for="city">City</label>
                                    <input class="form-control" id="city" type="text" placeholder="City" required="">
                                </div>
                            </div>
                            <div class="col-sm-4 mb-3">
                                <div class="form-group">
                                    <label for="gender">Province</label>
                                    <select class="form-select mb-0" id="province" aria-label="Province">
                                        <option selected="selected">Province</option>
                                        <option value="AB">Alberta</option>
                                        <option value="BC">British Columbia</option>
                                        <option value="MB">Manitoba</option>
                                        <option value="NB">New Brunswick</option>
                                        <option value="NL">Newfoundland</option>
                                        <option value="NT">Northwest Territories</option>
                                        <option value="NS">Nova Scotia</option>
                                        <option value="NU">Nunavut</option>
                                        <option value="ON">Ontario</option>
                                        <option value="PE">Prince Edward Island</option>
                                        <option value="QC">Quebec</option>
                                        <option value="SK">Saskatchewan</option>
                                        <option value="ON">Yukon</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <label for="postalcode">Postal Code</label>
                                    <input class="form-control" id="postalcode" type="tel" placeholder="Postal Code" required="">
                                </div>
                            </div>
                        </div>


                        <h2 class="h5 my-4">Emergency Contact</h2>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="emergency_first_name">First Name</label>
                                    <input class="form-control" id="emergency_first_name" type="text" placeholder="Enter your first name" required="">
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="emergency_last_name">Last Name</label>
                                    <input class="form-control" id="emergency_last_name" type="text" placeholder="Enter your last name" required="">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="emergency_email">Email</label>
                                    <input class="form-control" id="emergency_email" type="email" placeholder="name@company.com" required="">
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <div class="form-group">
                                    <label for="emergency_phone">Phone</label>
                                    <input class="form-control" id="emergency_phone" type="number" placeholder="+12-345 678 910" required="">
                                </div>
                            </div>
                        </div>

                        <div class="mt-3 float-end">
                            <button class="btn btn-gray-800 mt-2 animate-up-2" type="submit">Add</button>
                            <button class="btn btn-gray-800 mt-2 animate-up-2" type="button">Cancel</button>
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