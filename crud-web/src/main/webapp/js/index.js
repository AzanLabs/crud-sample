
$(document).ready(function(){
	console.log("Jquery is Loading");
	sessionStorage.clear();
	parishManagement.init();
});
/*Global Variables */
	CURRENT_PAGE = "parishWebSite";
 /*Global Boolean Flags */ 
var PARISHMANAGEMENT = {
	ISSLIDEDOWN : false,
	ISSLIDEUP : false,
	ISUSERCLICKED : false
};
	
parishManagement = {
	init :function(){
		var pageName = this.urlChange();
		this.setPageNavigation(pageName);
		this.events.createEvents();
	},
	urlChange : function(){
		var pageName = "";
		if(window.location.hash !="" && window.location.hash != "undefined"){
			var hashChange = window.location.hash.split("#");
			pageName = hashChange[1];
		} else {
			pageName = "parishWebSite";
		}
		return pageName;
	},
	setPageNavigation : function(page){
		CURRENT_PAGE = page;
        this.loadPage(CURRENT_PAGE);
        this.setPage(CURRENT_PAGE, CURRENT_PAGE, CURRENT_PAGE, "");
	},
	loadPage : function(page){
		if(page == "home"){
			homePage.init();
		} else if(page == "createProfile"){
			createPriestProfile.init();
		} else if(page == "viewProfile"){
			viewPriestProfile.init();
		} else {
			parishManagementWebsite.init();
		}
	},
	setPage : function(page, url, title, data){
		if (url == undefined) {
            url = "parishWebSite";
        }
        data = data ? data : ""; // json data for the page
        var urlWithHash = "#" + url;
        var dataModified = {
            "url": url,
            "data": data
        };
        window.history.pushState(dataModified, title, urlWithHash);
	}
}
parishManagement.events = {
	createEvents : function(){
		var pageName = "";
		$("#homePage").click(function(e){
			e.preventDefault();
			var pageName = "home";
			parishManagement.setPageNavigation(pageName);
		});
		$("#createPriestProfile").click(function(e){
			var pageName = "createProfile";
			parishManagement.setPageNavigation(pageName);
			e.preventDefault();
		});
		$("#viewPriestProfile").click(function(e){
			e.preventDefault();
			var pageName = "viewProfile";
			parishManagement.setPageNavigation(pageName);
		});
		$("#parishManagement").click(function(e){
			e.preventDefault();
			var pageName = "parishWebSite";
			parishManagement.setPageNavigation(pageName);
		});
		
		$(document).on("click","#createPriestProfileSubmit",function(e){
			createPriestProfile.formValidation();
			e.preventDefault();
		});
		// User Information edit
		$(document).on("click",".viewUserDetails",function(e){
			var currentTarget = $(e.currentTarget);
			console.log("currentTarget",currentTarget.attr("name"));
			viewPriestProfile.showUserDetails(currentTarget);
			e.preventDefault();
		});
		
		//Deleting the User Information
		$(document).on("click",".deletedICON",function(e){
			var message = "Are you sure you want to delete";
			util.showConfirmBox(message);
		});
		/* $(document).on("change",".radioClass",function(e){
		   alert($('input[name="optradio"]:checked', '.radioClass').val()); 
		   var values = $('input[name="optradio"]:checked').find("radioClass").val();
		   sessionStorage.gender = $('input[name="optradio"]:checked', '.radioClass').val();
		   e.preventDefault();
		}); */
		$('input[type="radio"]').click(function(e){
			sessionStorage.gender = $('input[name="optradio"]:checked').val();
		})
	}
}

parishManagement.view = {
	savedProfileResult : function(result){
		var message = "Your details are saved successfully,please view your details..!",pageName = "viewProfile";
		util.showAlertBox(message);
		debugger;
		parishManagement.setPageNavigation(pageName);
	},
	handleError : function(result){
		var message = "Service not available";
		util.showAlertBox(message);
	}
}
//Profile Image Upload
function readImageURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function (e) {
			$('.profilePicImageHolder').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
};



