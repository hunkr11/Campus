/**
 * 
 */

$(document).ready(function(){

	$('#code').autocomplete({
		//  alert('test 1');
		//	alert('page context' + $(pageContext.request.contextPath));
			serviceUrl : '/module/academic/master/admissionType/getAdmissionTypeCode',			
			paramName : "tagName",
			delimiter : ",",
			transformResult : function(response) {

				return {
					// must convert json to javascript object before process
					suggestions : $.map($.parseJSON(response), function(item) {

						return {
							/*source: [
					                  { label: "India", value: "IND" },
					                  { label: "Australia", value: "AUS" }
					               ]*/
						
							value : item.acad_typ_code,
							data : item.acad_typ_id
						};
					})

				};

			}

		});
	
});
