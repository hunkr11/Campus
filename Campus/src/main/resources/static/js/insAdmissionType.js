/**
 * 
 */

$(document).ready(function() {
	alert('code');
	$('#code').autocomplete({
		
		serviceUrl: '${pageContext.request.contextPath}/getAdmissionTypeCode',
		paramName: "tagName",
		delimiter: ",",
	   transformResult: function(response) {
 
		return {      	
		  //must convert json to javascript object before process
		  suggestions: $.map($.parseJSON(response), function(item) {
 
		      return { value: item.tagName, data: item.id };
		   })
 
		 };
 
            }
 
	 });
 
  });