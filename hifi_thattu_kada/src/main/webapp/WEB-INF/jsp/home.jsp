<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hifi_thattu_kada</title>

<!-- copied and added -->

<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />

<!-- ends here -->

<style type="text/css">
#header {
	position: fixed;
	top: 0;
	width: 99.3%;
	height: 50px;
	background: #3B170B;
	font-style: italic;
	line-height: 50px;
	vertical-align: middle;
}

.logo {
	width: 10px;
	height: 10px;
	margin: 0 0 0 -2000px;
	display: inline-block;
	float: left;
}

.title {
	display: inline-block;
	color: #fff;
	position: relative;
	float: inherit;
}

.logister {
	position: relative;
	text-align: right;
	display: inline-block;
	color: #fff;
	float: right;
}

.login:visited {
	color: #fff;
}

.login:LINK {
	color: #fff;
}

.login:HOVER {
	color: #99CC00;
}
</style>

</head>
<body>
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
			<header class="popupHeader"> <span class="header_title">Login</span>
			<span class="modal_close"><i class="fa fa-times"></i></span> </header>

			<section class="popupBody"> <!-- Social Login -->
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
			<form:form commandName="formname"  action="register" method="post">
			<div class="user_login">
			 
			<!-- 	<form name="form1" method="post">  -->
					<label>Email / User Name</label> 
						<input type="text" name="userName" id="userName"/> <br />					 
					<label>Password</label>
						<input type="password" name="usrPasswd" id="usrPasswd" /><br />
					

					<div class="checkbox">
						<input id="remember" type="checkbox" /> <label for="remember">Remember me on this computer</label>
					</div>

					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i class="fa fa-angle-double-left"></i> Back</a>
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
						<form:input id="uvc_user_name" path="uvc_user_name"/> <br /> 
						 <input type="hidden" name="uvc_user_name" >
					<label>Email</label> 
						<form:input id="uvc_email" path="uvc_email"/> <br /> 
						<input type="hidden" name="uvc_email" >
					<label>Password</label> 
						<form:password id="vc_passwd" path="vc_passwd" /> <br />
						<input type="hidden" name="vc_passwd" >

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
</body>

<script type="text/javascript">
	$("#modal_trigger").leanModal({
		top : 100,
		overlay : 0.6,
		closeButton : ".modal_close"
	});

	$(function() {
		// Calling Login Form
		$("#login_form").click(function() {
			$(".social_login").hide();
			$(".user_login").show();
			return false;
		});

		// Calling Register Form
		$("#register_form").click(function() {
			$(".social_login").hide();
			$(".user_register").show();
			$(".header_title").text('Register');
			return false;
		});

		// Going back to Social Forms
		$(".back_btn").click(function() {
			$(".user_login").hide();
			$(".user_register").hide();
			$(".social_login").show();
			$(".header_title").text('Login');
			return false;
		});

	})
	
	function formSubmit(id){
		
		if(id=="register"){
		//	document.forms[0].uvc_user_name = document.getElementById("uvc_user_name").value;
		//	document.forms[0].vc_passwd = document.getElementById("vc_passwd").value;
		//	document.forms[0].uvc_email = document.getElementById("uvc_email").value;
		
			
			var send_updates = document.getElementById("send_updates").checked;
			alert('send_updates-->'+send_updates);	
			var action = document.forms[0].action=id+"?b_sendUpdates="+send_updates;
			alert('action-->'+action);
			document.forms[0].submit();
		}
		else{
			document.forms[0].action=id;
			document.forms[0].submit();
		}	
		
		
		
	}
</script>


</html>