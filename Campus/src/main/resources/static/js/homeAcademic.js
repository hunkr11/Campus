/**
 * 
 */

	$(".mySelector").click(function() {
		$(this).find("li").find("ul").show();
	});

	$('#cssmenu li.active').children('ul').show();
	$('#cssmenu li.has-sub>a').on('click', function() {
		$(this).removeAttr('href');
		var element = $(this).parent('li');
		if (element.hasClass('active')) {
			element.removeClass('active');
			element.find('li').removeClass('active');
			element.find('ul').slideUp();
		} else {
			element.addClass('active');
			element.children('ul').slideDown();
			element.siblings('li').children('ul').slideUp();
			element.siblings('li').removeClass('active');
			element.siblings('li').find('li').removeClass('active');
			element.siblings('li').find('ul').slideUp();
		}
	});