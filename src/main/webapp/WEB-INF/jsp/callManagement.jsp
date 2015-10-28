<html>
    <head>
        <title>Add Call | Repairbranch</title>
        <%@ include file="commonHeadIncludes.jsp" %>

<script>
$(document).ready(function(){

$("#addCallDiv").find("#saveAnchor").click(function() {
    var createCallInfoDTO = {
        assignedAgentId:    $("#addCallDiv").find("#assignedTechnician").val(),
        customerName:       $("#addCallDiv").find("#customerName").val(),
        address: {
            firstLine:      $("#addCallDiv").find("#addressFirstLine").val(),
            secondLine:     $("#addCallDiv").find("#addressSecondLine").val(),
            landmark:       $("#addCallDiv").find("#addressLandmark").val(),
            city:           $("#addCallDiv").find("#city").val(),
            state:          $("#addCallDiv").find("#state").val(),
            pincode:        $("#addCallDiv").find("#pincode").val(),
            phoneNumber:    $("#addCallDiv").find("#phoneNumber").val()
        },
        productName:        $("#addCallDiv").find("#productName").val(),
        productDefect:      $("#addCallDiv").find("#productDefect").val()
    };

    $.ajax({
        url: "/callManagement/createCall",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(createCallInfoDTO),
        success: function(result) {
            $("#addCallDiv").find("#assignedTechnician")[0].selectedIndex = 0;
            alert("Success! Please reload page to view latest details.");
        },
        error: function(xhr){
            alert("An error occured: " + xhr.status + " " + xhr.statusText);
        }
    });
});

});
</script>

    </head>
    <body>
        <%@ include file="commonHeader.jsp" %>
        <div id="page-content-wrapper">
            <div id="page-title">
                <h3>
                    Call Management
                </h3>
            </div>
            <!-- #page-title -->
            <div id="page-content">
                <div class="row">
                    <div class="example-box">
                        <div class="example-code">
                            <div class="tabs tabs-navigation">
                                <ul>
                                    <li>
                                        <div class="col-md-12">
                                            <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'" class="tile-button btn clearfix bg-white" title="">
                                                <div class="tile-header pad10A font-size-13 popover-title" style="background:#0664CA;">
                                                    Add
                                                </div>
                                                <div class="tile-content-wrapper">
                                                    <i class="glyph-icon icon-group"></i>
                                                    <div class="tile-content" style="color:transparent;">
                                                        567
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                    <div class="white_content" id="light">
                                        <h3>Add call</h3>
                                        <form class="form-horizontal" role="form" id="addCallDiv">
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="customerName"
                                                        placeholder="Customer Name">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="phoneNumber"
                                                        placeholder="Customer Phone No.">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="addressFirstLine"
                                                        placeholder="Address: First line">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="addressSecondLine"
                                                        placeholder="Address: Second line">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="addressLandmark"
                                                        placeholder="Address: Landmark">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <select class="form-control" id="city">
                                                        <option selected disabled>City</option>
                                                        <c:forEach items="${indianCityValues}" var="city">
                                                            <option value="${city}">${city}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="pincode"
                                                        placeholder="Address: Pincode">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <select class="form-control" id="state">
                                                        <option selected disabled>State</option>
                                                        <c:forEach items="${indianStateValues}" var="state">
                                                            <option value="${state}">${state}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="productName"
                                                        placeholder="Product: Name">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="productDefect"
                                                        placeholder="Product: Defect">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <select class="form-control" id="assignedTechnician">
                                                        <option value=-1>Assigned Technician</option>
                                                        <c:forEach items="${technicians}" var="technician">
                                                            <option value="${technician.id}">${technician.fullDisplayInfo}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <a title="" class="btn medium primary-bg" href="#" id="saveAnchor">
                                                    <span class="button-content">Save</span>
                                                    </a>
                                                    <!-- a title="" class="btn medium primary-bg" href="#">
                                                    <span class="button-content">Cancel</span>
                                                    </a -->
                                                </div>
                                            </div>
                                        </form>
                                        <a class="popup-close" href ="javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</a>
                                    </div>
                                    <li>
                                        <div class="col-md-12">
                                            <a href="#normal-tabs-25" class="tile-button btn clearfix bg-white" title="">
                                                <div class="tile-header pad10A font-size-13 popover-title">
                                                    View Detail
                                                </div>
                                                <div class="tile-content-wrapper">
                                                    <i class="glyph-icon icon-refresh"></i>
                                                    <div class="tile-content" style="color:transparent;">
                                                        567
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                                <div id="normal-tabs-25">
                                    <table class="table text-center">
                                        <thead>
                                            <tr>
                                                <th class="text-center">Call ID</th>
                                                <th>Customer Name</th>
                                                <th>Customer Phone No.</th>
                                                <th>Assigned Technician</th>
                                                <th>Current Status</th>
                                                <th>Product Name</th>
                                                <th class="text-center">Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${callInfoList}" var="callInfo">
                                                <tr>
                                                    <td class="font-bold text-left">${callInfo.id}</td>
                                                    <td class="font-bold text-left">${callInfo.customerName}</td>
                                                    <td class="font-bold text-left">${callInfo.address.phoneNumber}</td>
                                                    <td class="font-bold text-left">${callInfo.assignedAgent.displayName}</td>
                                                    <td class="font-bold text-left">${callInfo.latestCallStatus}</td>
                                                    <td class="font-bold text-left">${callInfo.productName}</td>
                                                    <td>
                                                        <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'" class="btn medium bg-green" title="">
                                                            <span class="button-content"><i class="glyph-icon icon-edit"></i>Edit</span>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <div id="footer"></div>
    </body>
</html>