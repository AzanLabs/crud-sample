
$(document).ready(function(){
	console.log("Jquery is Loading");
	parishManagement.init();
});
 /*Global Boolean Flags */ 
var PARISHMANAGEMENT = {
	ISSLIDEDOWN : false,
	ISSLIDEUP : false,
	ISUSERCLICKED : false
};
	
var parishManagement = {
	init :function(){
		parishManagementWebsite.init();
		this.createEvents();
	},
	createEvents : function(){
		$("#homePage").click(function(e){
			e.preventDefault();
			homePage.init();
		});
		$("#createPriestProfile").click(function(e){
			e.preventDefault();
			createPriestProfile.init();
		});
		$("#viewPriestProfile").click(function(e){
			e.preventDefault();
			viewPriestProfile.init();
		});
		$("#parishManagement").click(function(e){
			e.preventDefault();
			parishManagementWebsite.init();
		});
		$("#createPriestProfileSubmit").click(function(e){
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
			util.showAlertBox();
		});
		
		
	}
};


