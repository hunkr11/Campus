<div id="body" class="container">
	<div id="header">
		<div class="logo">
			<img src="/images/thatt_kada_logo.png" alt="thatt_kada_logo" />
		</div>
		<div class="title">hifi_thattu_kada</div>
		<div class="logister">
			<a id="modal_trigger" class="login" href="#modal">login</a>
		</div>
	</div>
	<!-- Copied from Online -->

	<div id="modal" class="popupContainer" style="display: none;">
		<header class="popupHeader">
			<span class="header_title">Login</span> <span class="modal_close"><i
				class="fa fa-times"></i></span>
		</header>

		<section class="popupBody">
			<!-- Social Login -->
			<div class="social_login">
				<div class="">
					<a href="#" class="social_box fb"> <span class="icon"><i
							class="fa fa-facebook"></i></span> <span class="icon_title">Connect
							with Facebook</span>

					</a> <a href="#" class="social_box google"> <span class="icon"><i
							class="fa fa-google-plus"></i></span> <span class="icon_title">Connect
							with Google</span>
					</a>
				</div>

				<div class="centeredText">
					<span>Or use your Email address</span>
				</div>

				<div class="action_btns">
					<div class="one_half">
						<a href="#" id="login_form" class="btn">Login</a>
					</div>
					<div class="one_half last">
						<a href="#" id="register_form" class="btn">Sign up</a>
					</div>
				</div>
			</div>

			<!-- Username & Password Login form -->
			<form:form id="formId"  name="formId" commandName="userPojo" action="" method="post">
				<div class="user_login">

					<!-- 	<form name="form1" method="post">  -->
					<label>Email / User Name</label> <input type="text" name="userName"
						id="userName" /> <br /> <label>Password</label> <input
						type="password" name="usrPasswd" id="usrPasswd" /><br />


					<div class="checkbox">
						<input id="remember" type="checkbox" /> <label for="remember">Remember
							me on this computer</label>
					</div>

					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i
								class="fa fa-angle-double-left"></i> Back</a>
						</div>
						<div class="one_half last">
							<a href="javascript:formSubmit('login')" class="btn btn_red">Login</a>
						</div>
					</div>
					<!--	</form>  -->

					<a href="#" class="forgot_password">Forgot password?</a>
				</div>

				<!-- Register Form -->
				<div class="user_register">

					<label>Full Name</label>
					<form:input id="uvc_user_name" path="uvc_user_name" />
					<br /> <input type="hidden" name="uvc_user_name"> <label>Email</label>
					<form:input id="uvc_email" path="uvc_email" />
					<br /> <input type="hidden" name="uvc_email"> <label>Password</label>
					<form:password id="vc_passwd" path="vc_passwd" />
					<br /> <input type="hidden" name="vc_passwd">

					<div class="checkbox">
						<input id="send_updates" name="b_send_updates" type="checkbox" />
						<label for="send_updates">Send me occasional email updates</label>
					</div>

					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i
								class="fa fa-angle-double-left"></i> Back</a>
						</div>
						<div class="one_half last">
							<a href="javascript:formSubmit('register')" class="btn btn_red">Register</a>
						</div>
					</div>

				</div>
			</form:form>
		</section>
	</div>

	<!--  Ends here -->

</div>

