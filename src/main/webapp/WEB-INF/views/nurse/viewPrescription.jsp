<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="fragments/header.jsp"/>

<main id="main" class="main">
    <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center py-4">
        <div class="d-block mb-4 mb-md-0">
            <h3>Patient Prescription : ${patient.firstName} ${patient.lastName}</h3>
        </div>
    </div>

    <div class="container">
        <div class="row align-items-center">
            <div class="col">
                <div class="mb-4 pt-4">

                    <div class="row">
                        <div class="card mb-4 col-md-12">
                            <h5 class="card-header">Diagnosis Details</h5>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="name" class="form-label fw-bold mb-0">Diagnosis</label>
                                        <form:input path="diagnoses.name" type="text" id="name" class="form-control-plaintext"/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="description" class="form-label fw-bold mb-0">Diagnosis
                                            Description</label>
                                        <form:input path="diagnoses.description" type="text" id="name"
                                                    class="form-control-plaintext"/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label class="form-label fw-bold mb-0">Issue Date</label>

                                        <label class="form-control-plaintext">
                                            <fmt:parseDate value="${diagnoses.createdAt}" pattern="yyyy-MM-dd" var="createdat" type="date"/>
                                            <fmt:formatDate pattern="MM/dd/yyy" value="${createdat}"/>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="card mb-4 col-md-12">
                            <h5 class="card-header">Prescription Details</h5>
                            <div class="card-body">
                                <c:forEach var="ps" items="${prescriptionList}" varStatus="loop">
                                    <div class="row">
                                        <div class="col-sm-12 mb-3">
                                            <label class="form-label fw-bold mb-0">Prescribed Date: </label>
                                            <label class="badge bg-success bg-secondary form-label fw-bold mb-0 date-badge">
                                            <fmt:parseDate value="${ps.createdAt}" pattern="yyyy-MM-dd" var="createdat" type="date"/>
                                            <fmt:formatDate pattern="MM/dd/yyy" value="${createdat}"/>
                                            </label>
                                        </div>
                                        <div class="col-sm-12 mb-3">
                                            <label class="form-label fw-bold mb-0">Prescription</label>
                                            <input id="name" name="name" type="text" class="form-control-plaintext" value="${ps.prescriptions}">
                                        </div>
                                    </div>
                                    <c:if test="${!loop.last}">
                                        <hr class="hr" />
                                    </c:if>

                                </c:forEach>

                            </div>
                        </div>
                    </div>

                    <div class="float-end">
                        <a href="/nurse/patient/view/${patient.userId}" class="fw-bold mx-2">Back</a>
                    </div>
                </div>
            </div>

        </div>

    </div>
</main><!-- End #main -->

<%@ include file="fragments/footer.jsp" %>

</body>
</html>