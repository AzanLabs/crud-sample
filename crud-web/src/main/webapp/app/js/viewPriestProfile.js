var viewPriestProfile = {
	init : function(){
		$("ul.navbar-nav li").removeClass("active");
		$("#viewPriestProfile").addClass("active");
		$("#parishManagement").css("color","#9d9d9d");
		$(".content-holder").empty();
		var viewProfileHTML = '<div>'
								  +'<div>'
										+'<div>'
											+'<button type="button" class="btn btn-default viewUserDetails" style="width:70%;" name="user1">User 1</button><a href="javascript:void(0);" name="user1" class="deletedICON"  style="margin-left:10px;margin-right:10px;"><span class="glyphicon glyphicon-trash"></span></a>'
										+'</div>'
										+'<div style="display:none;margin-top:10px;" class="user1">'
											+'<form class="form-horizontal" role="form">'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="firstName">First Name:</label>'
												  +'<div class="col-sm-6">'
													+'<input type="text" class="form-control" id="firstName" placeholder="Enter your First Name" required>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="lastName">Last Name:</label>'
												  +'<div class="col-sm-6">'
													+'<input type="text" class="form-control" id="lastName" placeholder="Enter your Last Name" required>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="gender">Gender:</label>'
												  +'<div class="col-sm-3">'
													+'<label class="radio-inline"><input type="radio" name="optradio" required>Male</label>'
													+'<label class="radio-inline"><input type="radio" name="optradio" required>Female</label>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="qualification">Qualification:</label>'
												  +'<div class="col-sm-6">'         
													+'<input type="text" class="form-control" id="qualification" placeholder="Enter your Qualification" required>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="currentChurch">Current Church:</label>'
												  +'<div class="col-sm-6">'         
													+'<input type="text" class="form-control" id="currentChurch" placeholder="Enter your Current Church" required>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="email">Email:</label>'
												  +'<div class="col-sm-6">'
													+'<input type="email" class="form-control" id="email" placeholder="Enter email" required>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'
												  +'<label class="control-label col-sm-2" for="contactNumber">Phone:</label>'
												  +'<div class="col-sm-6">'
													+'<input type="tel" class="form-control" id="contactNumber" placeholder="Enter your Phone Number" required>'
												  +'</div>'
												+'</div>'
												+'<div class="form-group">'        
												  +'<div class="col-sm-offset-2">'
													+'<div class="col-sm-2">'
														+'<button type="submit" id="createPriestProfileSubmit" class="btn btn-default">Submit</button>'
													+'</div>'
													+'<div class="col-sm-3">'
														+'<button type="button" id="createPriestProfileCancel" class="btn btn-default">Cancel</button>'
													+'</div>'
												  +'</div>'
												+'</div>'
											+'</form>'
										+'</div>'
								  +'</div>'
								  +'<div style="margin-top:10px;">'
										+'<button type="button" class="btn btn-default viewUserDetails" style="width:70%;" name="user2">User 2</button><a href="javascript:void(0);" style="margin-left:10px;margin-right:10px;"><span class="glyphicon glyphicon-trash"></span></a>'
								  +'</div>'
									+'<div style="display:none;margin-top:10px;" class="user2">'
										+'<form class="form-horizontal" role="form">'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="firstName">First Name:</label>'
											  +'<div class="col-sm-6">'
												+'<input type="text" class="form-control" id="firstName" placeholder="Enter your First Name" required>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="lastName">Last Name:</label>'
											  +'<div class="col-sm-6">'
												+'<input type="text" class="form-control" id="lastName" placeholder="Enter your Last Name" required>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="gender">Gender:</label>'
											  +'<div class="col-sm-3">'
												+'<label class="radio-inline"><input type="radio" name="optradio" required>Male</label>'
												+'<label class="radio-inline"><input type="radio" name="optradio" required>Female</label>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="qualification">Qualification:</label>'
											  +'<div class="col-sm-6">'         
												+'<input type="text" class="form-control" id="qualification" placeholder="Enter your Qualification" required>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="currentChurch">Current Church:</label>'
											  +'<div class="col-sm-6">'         
												+'<input type="text" class="form-control" id="currentChurch" placeholder="Enter your Current Church" required>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="email">Email:</label>'
											  +'<div class="col-sm-6">'
												+'<input type="email" class="form-control" id="email" placeholder="Enter email" required>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'
											  +'<label class="control-label col-sm-2" for="contactNumber">Phone:</label>'
											  +'<div class="col-sm-6">'
												+'<input type="tel" class="form-control" id="contactNumber" placeholder="Enter your Phone Number" required>'
											  +'</div>'
											+'</div>'
											+'<div class="form-group">'        
											  +'<div class="col-sm-offset-2">'
												+'<div class="col-sm-2">'
													+'<button type="submit" id="createPriestProfileSubmit" class="btn btn-default">Submit</button>'
												+'</div>'
												+'<div class="col-sm-3">'
													+'<button type="button" id="createPriestProfileCancel" class="btn btn-default">Cancel</button>'
												+'</div>'
											  +'</div>'
											+'</div>'
										+'</form>'
									+'</div>'
								  +'</div>'
								+'</div>';
		$(".content-holder").append(viewProfileHTML);
	},
	showUserDetails : function(currentItem){
		console.log("currentItem",currentItem);
		if(currentItem.attr("name") == "user1"){
			if(!PARISHMANAGEMENT.ISUSERCLICKED){
				PARISHMANAGEMENT.ISUSERCLICKED = true;
				PARISHMANAGEMENT.ISSLIDEUP = false;
			}
			if(PARISHMANAGEMENT.ISSLIDEUP){
				PARISHMANAGEMENT.ISSLIDEDOWN = true;
				PARISHMANAGEMENT.ISSLIDEUP = false;
				$(".user1").slideUp("slow");
			} else {
				PARISHMANAGEMENT.ISSLIDEUP = true;
				PARISHMANAGEMENT.ISSLIDEDOWN = false;
				$(".user1").slideDown("slow");
			}
			$(".user2").css("display","none");
			$(".user1").css("display","block");
		} else {
			if(PARISHMANAGEMENT.ISUSERCLICKED){
				PARISHMANAGEMENT.ISUSERCLICKED = false;
				PARISHMANAGEMENT.ISSLIDEUP = false;
			}
			if(PARISHMANAGEMENT.ISSLIDEUP){
				PARISHMANAGEMENT.ISSLIDEDOWN = true;
				PARISHMANAGEMENT.ISSLIDEUP = false;
				$(".user2").slideUp("slow");
			} else {
				PARISHMANAGEMENT.ISSLIDEUP = true;
				PARISHMANAGEMENT.ISSLIDEDOWN = false;
				$(".user2").slideDown("slow");
			}
			$(".user1").css("display","none");
			$(".user2").css("display","block");
		}
	}
}