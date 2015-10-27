<html>
    <head>
        <title>Add Call | Repairbranch</title>
        <%@ include file="commonHeadIncludes.jsp" %>
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
                                    <div id="light" class="white_content">
                                        <h3>Add call</h3>
                                        <form class="form-horizontal" role="form">
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="firstname"
                                                        placeholder="Customer Name">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="phoneNumber"
                                                        placeholder="Customer Phone No.">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="firstname"
                                                        placeholder="Address: First line">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="phoneNumber"
                                                        placeholder="Address: Second line">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="firstname"
                                                        placeholder="Address: Landmark">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <select class="form-control">
                                                        <option>City</option>
                                                        <option>1</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="firstname"
                                                        placeholder="Address: Pincode">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <select class="form-control">
                                                        <option>State</option>
                                                        <option>1</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="firstname"
                                                        placeholder="Product: Name">
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                    <input type="text" class="form-control" id="firstname"
                                                        placeholder="Product: Defect">
                                                </div>                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6 mrg5B">
                                                    <select class="form-control">
                                                        <option>Assigned Technician</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                    </select>
                                                </div>
                                                <div class="col-sm-6 mrg5B">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <a title="" class="btn medium primary-bg" href="#">
                                                    <span class="button-content">Save</span>
                                                    </a>
                                                    <a title="" class="btn medium primary-bg" href="#">
                                                    <span class="button-content">Cancel</span>
                                                    </a>
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
                                                <th>Assigned Technician</th>
                                                <th>Current Status</th>
                                                <!--th class="text-center">Actions</th-->
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td class="font-bold text-left">John Clark (1234567890)</td>
                                                <td class="font-bold text-left">Raju Srivastav (1234567890)</td>
                                                <td class="font-bold text-left">CREATED</td>
                                                <!--td>
                                                    <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'" class="btn medium bg-green" title="">
                                                    <span class="button-content"><i class="glyph-icon icon-edit"></i>Edit</span>
                                                    </a>
                                                </td-->
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-----Popup content---->
                            <!--div id="light" class="white_content">
                                <h3>Edit call</h3>
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-6 mrg5B">
                                            <input type="text" class="form-control" id="firstname"
                                                placeholder="First Name">
                                        </div>
                                        <div class="col-sm-6 mrg5B">
                                            <input type="text" class="form-control" id="lastname"
                                                placeholder="Last Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 mrg5B">
                                            <input type="text" class="form-control" id="phone"
                                                placeholder="Phone No.">
                                        </div>
                                        <div class="col-sm-6 mrg5B">
                                            <input type="text" class="form-control" id="email"
                                                placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 mrg5B">
                                            <select class="form-control">
                                                <option>Dropdown</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-6 mrg5B">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10">
                                            <a title="" class="btn medium primary-bg" href="#">
                                            <span class="button-content">Save</span>
                                            </a>
                                            <a title="" class="btn medium primary-bg" href="#">
                                            <span class="button-content">Cancel</span>
                                            </a>
                                        </div>
                                    </div>
                                </form>
                                <a class="popup-close" href ="javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">Close</a>
                            </div-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <div id="footer"></div>
    </body>
</html>