<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:directive.include file="fragments/header.jsp"/>
<main id="main" class="main">
    <div class="d-flex justify-content-center flex-wrap flex-md-nowrap align-items-center py-4">
        <div class="d-block mb-4 mb-md-0">
            <c:choose>
                <c:when test="${userForm['new']}">
                    <h2>Add User</h2>
                </c:when>
                <c:otherwise>
                    <h2>Update User</h2>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="container">
        <div class="row align-items-center">
            <div class="col">
                <div class="mb-4 pt-4">
                    <form:form method="post" modelAttribute="userForm" action="/nurse/save">
                        <form:hidden path="userId"/>
                        <form:hidden path="role"/>
                        <c:choose>
                            <c:when test="${userForm['new']}">
                                <div class="row">
                                    <div class="card mb-4 col-md-12">
                                        <h5 class="card-header">Login information</h5>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-6 mb-3">
                                                    <spring:bind path="username">
                                                        <label for="username"
                                                               class="form-label fw-bold">Username</label>
                                                        <form:input path="username" type="text" id="username"
                                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                                    placeholder="Enter user name" required=""
                                                                    aria-describedby="validationUserNameFeedback"/>
                                                        <form:errors path="username" id="validationUserNameFeedback"
                                                                     class="invalid-feedback"/>
                                                    </spring:bind>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <spring:bind path="password">
                                                        <label for="password"
                                                               class="form-label fw-bold">Password</label>
                                                        <form:input path="password" type="password" id="password"
                                                                    class="form-control ${status.error ? 'is-invalid' : ''}"
                                                                    placeholder="Enter Password" required=""
                                                                    aria-describedby="validationPasswordFeedback"/>
                                                        <form:errors path="password" id="validationPasswordFeedback"
                                                                     class="invalid-feedback"/>
                                                    </spring:bind>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="row">
                                    <div class="card mb-4 col-md-6">
                                        <h5 class="card-header">Login information</h5>
                                        <div class="card-body">
                                            <label for="username" class="form-label fw-bold">Username</label>
                                            <form:input path="username" type="text" id="username" disabled="true"
                                                        class="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Enter user name" required=""
                                                        aria-describedby="validationUserNameFeedback"/>

                                            <form:hidden path="username"/>
                                            <form:hidden path="password"/>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>


                        <div class="row">
                            <div class="card mb-4 col-md-12">
                                <h5 class="card-header">General information</h5>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="firstName">
                                                <label for="first_name" class="form-label fw-bold">First
                                                    Name</label>
                                                <form:input path="firstName" type="text" id="first_name"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            placeholder="Enter your first name" required=""
                                                            aria-describedby="validationFirstNameFeedback"/>
                                                <form:errors path="firstName" id="validationFirstNameFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="lastName">
                                                <label for="last_name" class="form-label fw-bold">Last Name</label>
                                                <form:input path="lastName" type="text" id="last_name"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            placeholder="Also your last name" required=""
                                                            aria-describedby="validationLastNameFeedback"/>
                                                <form:errors path="lastName" id="validationLastNameFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>

                                    <div class="row align-items-center">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="role">
                                                <label for="role" class="form-label fw-bold">Role</label>
                                                <form:select path="role" id="role" disabled="true"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Role"
                                                             aria-describedby="validationRoleFeedback">
                                                    <form:option value="" label="Role"/>
                                                    <form:options items="${roles}"/>
                                                </form:select>
                                                <form:errors path="role" id="validationRoleFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>

                                    <div class="${userForm.role eq 'DOCTOR' ? 'show' : 'hide'} row align-items-center" id="doctor_speciality">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="speciality">
                                                <label for="gender" class="form-label fw-bold">Doctor Speciality</label>
                                                <form:select path="speciality" id="doctorSpeciality"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Speciality"
                                                             aria-describedby="validationSpecialityFeedback">
                                                    <form:option value="" label="Speciality"/>
                                                    <form:options items="${doctorSpecialities}"/>
                                                </form:select>
                                                <form:errors path="speciality" id="validationSpecialityFeedback" class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>

                                    <div class="${userForm.role eq 'NURSE' ? 'show' : 'hide'} row align-items-center" id="nurse_type">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="nurseType">
                                                <label for="gender" class="form-label fw-bold">Nurse Type</label>
                                                <form:select path="nurseType" id="nurseType"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Nurse Type"
                                                             aria-describedby="validationNurseTypeFeedback">
                                                    <form:option value="" label="Nurse Type"/>
                                                    <form:options items="${nurseTypes}"/>
                                                </form:select>
                                                <form:errors path="nurseType" id="validationNurseTypeFeedback" class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>




                                    <div class="row align-items-center">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="dateOfBirth">
                                                <label for="dob" class="form-label fw-bold">Date of Birth</label>
                                                <div class="input-group">
                                                    <span class="input-group-text"><i class="fa-regular fa-calendar-days"></i> </span>
                                                    <form:input path="dateOfBirth" type="text" id="dob"
                                                                class="form-control datepicker-input ${status.error ? 'is-invalid' : ''}"
                                                                required="" placeholder="mm/dd/yyyy"
                                                                aria-describedby="validationDOBFeedback"/>
                                                    <form:errors path="dateOfBirth" id="validationDOBFeedback"
                                                                 cssClass="invalid-feedback-force-display"/>
                                                </div>
                                            </spring:bind>
                                        </div>
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="gender">
                                                <label for="gender" class="form-label fw-bold">Gender</label>
                                                <form:select path="gender" id="gender"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Gender"
                                                             aria-describedby="validationGenderFeedback">
                                                    <form:option value="" label="Gender"/>
                                                    <form:option value="Female" label="Female"/>
                                                    <form:option value="Male" label="Male"/>
                                                </form:select>
                                                <form:errors path="gender" id="validationGenderFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>

                                    <div class="${userForm.role eq 'PATIENT' ? 'show' : 'hide'} row align-items-center" id="blood_group">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="bloodGroup">
                                                <label for="bloodGroup" class="form-label fw-bold">Blood
                                                    Group</label>
                                                <form:select path="bloodGroup" id="bloodGroup"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Blood Group"
                                                             aria-describedby="validationBloodGroupFeedback">
                                                    <form:option value="" label="Blood Group"/>
                                                    <form:options items="${bloodGroups}"/>
                                                </form:select>
                                                <form:errors path="bloodGroup" id="validationBloodGroupFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>

                                    <div class="row align-items-center">
                                        <div class="col-md-6">
                                            <spring:bind path="email">
                                                <label for="email" class="form-label fw-bold">Email</label>
                                                <form:input path="email" type="email" id="email"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="name@centennialcollege.com"
                                                            aria-describedby="validationEmailFeedback"/>
                                                <form:errors path="email" id="validationEmailFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                        <div class="col-md-6">
                                            <spring:bind path="phoneNumber">
                                                <label for="phone" class="form-label fw-bold">Phone</label>
                                                <form:input path="phoneNumber" type="text" id="phone"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="+12345678910"
                                                            aria-describedby="validationPhoneFeedback"/>
                                                <form:errors path="phoneNumber" id="validationPhoneFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="card mb-4 col-md-12">
                                <h5 class="card-header">Location</h5>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-8 mb-3">
                                            <spring:bind path="address">
                                                <label for="address" class="form-label fw-bold">Address</label>
                                                <form:input path="address" type="text" id="address"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="Enter your home address"
                                                            aria-describedby="validationAddresseFeedback"/>
                                                <form:errors path="address" id="validationAddresseFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                        <div class="col-sm-4 mb-3">
                                            <spring:bind path="addressNo">
                                                <label for="addressNo" class="form-label fw-bold">Number</label>
                                                <form:input path="addressNo" type="text" id="addressNo"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="No."
                                                            aria-describedby="validationAddressNoFeedback"/>
                                                <form:errors path="addressNo" id="validationAddressNoFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-sm-4 mb-3">
                                            <spring:bind path="city">
                                                <label for="city" class="form-label fw-bold">City</label>
                                                <form:input path="city" type="text" id="city"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="City"
                                                            aria-describedby="validationCityFeedback"/>
                                                <form:errors path="city" id="validationCityFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                        <div class="col-sm-4 mb-3">
                                            <spring:bind path="province">
                                                <label for="gender" class="form-label fw-bold">Province</label>
                                                <form:select path="province" id="province"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Province"
                                                             aria-describedby="validationProvinceFeedback">
                                                    <form:option value="" label="Province"/>
                                                    <form:options items="${provinces}"/>
                                                </form:select>
                                                <form:errors path="province" id="validationProvinceFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>

                                        <div class="col-sm-4">
                                            <spring:bind path="postalCode">
                                                <label for="postalcode" class="form-label fw-bold">Postal
                                                    Code</label>
                                                <form:input path="postalCode" type="text" id="postalcode"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="Postal Code"
                                                            aria-describedby="validationPostalcodeFeedback"/>
                                                <form:errors path="postalCode" id="validationPostalcodeFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 mb-3">
                                            <spring:bind path="country">
                                                <label for="country" class="form-label fw-bold">Country</label>
                                                <form:select path="country" id="country"
                                                             class="form-select mb-0 ${status.error ? 'is-invalid' : ''}"
                                                             aria-label="Select Country"
                                                             aria-describedby="validationCountryFeedback">
                                                    <form:option value="" label="Country"/>
                                                    <form:options items="${countries}"/>
                                                </form:select>

                                                <form:errors path="country" id="validationCountryFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="${userForm.role eq 'PATIENT' ? 'show' : 'hide'} row" id="emergency_contact">
                            <div class="card mb-4 col-md-12">
                                <h5 class="card-header">Emergency Contact</h5>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="emergencyFirstName">
                                                <label for="emergency_first_name">First Name</label>
                                                <form:input path="emergencyFirstName" type="text"
                                                            id="emergency_first_name"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            placeholder="Enter your emergency first name"
                                                            required=""
                                                            aria-describedby="validationEFirstNameFeedback"/>
                                                <form:errors path="emergencyFirstName"
                                                             id="validationEFirstNameFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="emergencyLastName">
                                                <label for="emergency_last_name">Last Name</label>
                                                <form:input path="emergencyLastName" type="text"
                                                            id="emergency_last_name"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            placeholder="Also your emergency last name" required=""
                                                            aria-describedby="validationELastNameFeedback"/>
                                                <form:errors path="emergencyLastName"
                                                             id="validationELastNameFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="emergencyEmail">
                                                <label for="emergencyEmail">Email</label>
                                                <form:input path="emergencyEmail" type="email" id="emergencyEmail"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="name@centennialcollege.com"
                                                            aria-describedby="validationEEmailFeedback"/>
                                                <form:errors path="emergencyEmail" id="validationEEmailFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                        <div class="col-md-6 mb-3">
                                            <spring:bind path="emergencyPhone">
                                                <label for="emergencyPhone">Phone</label>
                                                <form:input path="emergencyPhone" type="text" id="emergencyPhone"
                                                            class="form-control ${status.error ? 'is-invalid' : ''}"
                                                            required="" placeholder="+12345678910"
                                                            aria-describedby="validationEPhoneFeedback"/>
                                                <form:errors path="emergencyPhone" id="validationEPhoneFeedback"
                                                             class="invalid-feedback"/>
                                            </spring:bind>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="mt-3 float-end">
                            <button class="btn btn-sm btn-gray-800 d-inline-flex align-items-center"
                                    type="submit">Update
                            </button>
                            <a href="/nurse/home" class="fw-bold mx-2">Cancel</a>
                        </div>
                    </form:form>
                </div>
            </div>

        </div>

    </div>
</main>
<!-- End #main -->

<%@ include file="fragments/footer.jsp" %>

<script>
    $(document).ready(function () {
        $("#role").change(function() {
            if(this.value == 'PATIENT'){
                $("#blood_group").addClass('show').removeClass('hide');
                $( "#emergency_contact" ).addClass('show').removeClass('hide');

                $( "#doctor_speciality" ).addClass('hide').removeClass('show');
                $( "#nurse_type" ).addClass('hide').removeClass('show');
            } else if(this.value == 'DOCTOR'){
                $( "#doctor_speciality" ).addClass('show').removeClass('hide');

                $( "#emergency_contact" ).addClass('hide').removeClass('show');
                $( "#blood_group" ).addClass('hide').removeClass('show');
                $( "#nurse_type" ).addClass('hide').removeClass('show');
            } else if(this.value == 'NURSE') {
                $( "#nurse_type" ).addClass('show').removeClass('hide');

                $( "#emergency_contact" ).addClass('hide').removeClass('show');
                $( "#blood_group" ).addClass('hide').removeClass('show');
                $( "#doctor_speciality" ).addClass('hide').removeClass('show');
            } else if(this.value == 'LAB_ASSISTANT') {
                $( "#emergency_contact" ).addClass('hide').removeClass('show');
                $( "#blood_group" ).addClass('hide').removeClass('show');
                $( "#doctor_speciality" ).addClass('hide').removeClass('show');
                $( "#nurse_type" ).addClass('hide').removeClass('show');
            } else if(this.value == 'RECEPTIONIST') {
                $( "#emergency_contact" ).addClass('hide').removeClass('show');
                $( "#blood_group" ).addClass('hide').removeClass('show');
                $( "#doctor_speciality" ).addClass('hide').removeClass('show');
                $( "#nurse_type" ).addClass('hide').removeClass('show');
            }

        });

        $(function () {
            $('input#dob').datepicker({
                endDate: "today"
            });
        });
    })
</script>

</body>
</html>