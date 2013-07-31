$ ->
	$.get "/getBusinesses", (data) ->
  		$.each data, (index, business) ->
    		$("#businesses").append $("<li>").text business.businessDescription
    		
    		console.log("here");
    		
    		 