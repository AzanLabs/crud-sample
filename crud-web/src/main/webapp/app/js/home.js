var homePage = {
	init :  function(){
		$("ul.navbar-nav li").removeClass("active");
		$("#homePage").addClass("active");
		$("#parishManagement").css("color","#9d9d9d");
		$(".content-holder").empty();
		var homePageHtml = '<h1>Welcome to Parish Management</h1>';
		$(".content-holder").append(homePageHtml);
	}
};