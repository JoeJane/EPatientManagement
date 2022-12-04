<jsp:directive.include file = "fragments/header.jsp" />

<main id="main" class="main">
    <div class="alert position-fixed start-50 alert-success alert-dismissible fade user-msg ${message != null ? 'show' : 'hide'}" role="alert">
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center py-4">
        <div class="d-block mb-4 mb-md-0">
            <h2 class="h4">Users List</h2>
            </div>

    </div>

    <div class="table-settings mb-4">
        <form:form action="search" method="post" modelAttribute="searchterm">
        <div class="row justify-content-between align-items-center">
            <div class="col-9 col-lg-8 d-md-flex">
                    <div class="input-group me-2 me-lg-3 fmxw-300">
                        <span class="input-group-text">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </span>
                        <form:input type="text" path="value" class="form-control" placeholder="Search users" />
                    </div>
                    <form:select class="form-select fmxw-200 d-none d-md-inline" path="status" aria-label="Message select example 2">
                        <form:option value="" label="All"/>
                        <form:option value="1" label="Active"/>
                        <form:option value="2" label="Inactive"/>
                    </form:select>
                    <button type="submit" class="btn btn-sm px-3 btn-secondary ms-3">Search</button>
            </div>
        </div>
        </form:form>
    </div>


    <div class="card card-body shadow border-0 table-wrapper table-responsive">

        <table class="table user-table table-hover align-items-center">
            <thead>
            <tr>
                <th class="border-bottom">Name</th>
                <th class="border-bottom">User Name</th>
                <th class="border-bottom">Role</th>
                <th class="border-bottom">Gender</th>
                <th class="border-bottom">Age</th>
                <th class="border-bottom">Date Created</th>
                <th class="border-bottom">Status</th>
                <th class="border-bottom">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <a href="#" class="d-flex align-items-center">
                            <div class="avatar d-flex align-items-center justify-content-center fw-bold rounded bg-secondary me-3">
                                <span>${user.icon}</span>
                            </div>
                            <div class="d-block"><span class="fw-bold">${user.firstName} ${user.lastName}</span>
                                <div class="small text-gray">${user.email}</div>
                            </div>
                        </a>
                    </td>
                    <td><span class="fw-normal">${user.username}</span></td>
                    <td><span class="fw-normal">${user.role.value}</span></td>
                    <td><span class="fw-normal">${user.gender}</span></td>
                    <td><span class="fw-normal">${user.age}</span></td>
                    <td><span class="fw-normal">
                    <fmt:parseDate value="${user.createdAt}" pattern="yyyy-MM-dd" var="createdAt" type="date"/>
                    <fmt:formatDate pattern="MM/dd/yyy" value="${createdAt}"/></span></td>
                    <td>
                        <c:choose>
                            <c:when test="${user.deleted}">
                                <span class="fw-normal text-danger">Inactive</span>
                            </c:when>
                            <c:otherwise>
                                <span class="fw-normal text-success">Active</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <div class="btn-group">
                            <button class="btn btn-link text-dark dropdown-toggle dropdown-toggle-split m-0 p-0"
                                    data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa-solid fa-ellipsis fa-lg"></i> <span
                                    class="visually-hidden">Toggle Dropdown</span>
                            </button>
                            <div class="dropdown-menu dashboard-dropdown dropdown-menu-start mt-2 py-1">
                                <a class="dropdown-item d-flex align-items-center" href="/nurse/patient/view/${user.userId}"><i class="fa-solid fa-eye"></i> View Details </a>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>

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



</main><!-- End #main -->

<script src="/resources/js/bootstrap.bundle.min.js"></script>
<script src="/resources/js/jquery-3.6.1.min.js"></script>


</body>
</html>