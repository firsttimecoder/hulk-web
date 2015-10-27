<html>
    <head>
        <title>Call Management | Repairbranch</title>
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
                    <div class="col-md-12">
                        <form action="/login" id="login-validation" class="col-md-5 center-margin" method="post">
                            <div id="login-form" class="content-box form-vertical" style="margin-top:0px;">
                                <h3 class="content-box-header ui-state-default">
                                    <div class="glyph-icon icon-separator">
                                        <i class="glyph-icon icon-user"></i>
                                    </div>
                                    <span>Call Management Login</span>
                                </h3>
                                <div class="content-box-wrapper pad20A pad0B">
                                    <div class="form-row">
                                        <div class="form-label col-md-2">
                                            <label for="login_email">
                                            Username:
                                            <span class="required">*</span>
                                            </label>
                                        </div>
                                        <div class="form-input col-md-10">
                                            <div class="form-input-icon">
                                                <i class="glyph-icon icon-envelope-o ui-state-default"></i>
                                                <input placeholder="Username" data-type="email" data-trigger="change" data-required="true" type="login_email" name="username" id="login_email">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-label col-md-2">
                                            <label for="login_pass">
                                            Password:
                                            </label>
                                        </div>
                                        <div class="form-input col-md-10">
                                            <div class="form-input-icon">
                                                <i class="glyph-icon icon-unlock-alt ui-state-default"></i>
                                                <input placeholder="Password" data-trigger="keyup" data-rangelength="[3,25]" type="password" name="password" id="login_pass">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-checkbox-radio col-md-6">
                                            <input type="checkbox" class="custom-checkbox" name="remember-me" id="remember-me">
                                            <label for="remember-password" class="pad5L">Remember password?</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="button-pane text-center">
                                    <button type="submit" class="btn large primary-bg text-transform-upr font-size-11" id="demo-form-valid" title="Validate!">
                                    <span class="button-content">
                                    OK
                                    </span>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
</div>
</body>
</html>