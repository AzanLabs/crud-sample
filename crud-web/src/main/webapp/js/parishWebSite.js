var parishManagementWebsite = {
	init : function(){
		$("ul.navbar-nav li").removeClass("active");
		$("#parishManagement").css("color","white");
		$(".content-holder").empty();
		var webSiteHTML = '<div style="width:inherit;height:525px;"><img src="images/image-2.jpg" style="max-width:100%;height:100%;" /></div>';
		$(".content-holder").append(webSiteHTML);
	}
}