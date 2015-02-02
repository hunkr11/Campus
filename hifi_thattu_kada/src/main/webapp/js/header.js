$(function() {

	$("#modal_trigger").leanModal({
		top : 100,
		overlay : 0.6,
		closeButton : ".modal_close"
	});
})

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

function formSubmit(id) {

	if (id == "register") {
		// document.forms[0].uvc_user_name =
		// document.getElementById("uvc_user_name").value;
		// document.forms[0].vc_passwd =
		// document.getElementById("vc_passwd").value;
		// document.forms[0].uvc_email =
		// document.getElementById("uvc_email").value;

		var send_updates = document.getElementById("send_updates").checked;
		alert('send_updates-->' + send_updates);
		var action = document.forms[0].action = id + "?b_sendUpdates="
				+ send_updates;
		alert('action-->' + action);
		document.forms[0].submit();
	} else {
		alert('id-->' + id);
		document.getElementById("formId").action = id;
	//	document.forms["formId"].submit();
		document.getElementById("formId").submit();
		return true;
	//	document.forms[0].submit();
		//document.getElementsByName('formId').submit();
	}
}