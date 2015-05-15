
$(document).ready(function(){
	console.log("Jquery is Loading");
	parishManagement.init();
});
	
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
	}
};
