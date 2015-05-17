var createPriestProfile = {
	init : function(){
		$("ul.navbar-nav li").removeClass("active");
		$("#createPriestProfile").addClass("active");
		$("#parishManagement").css("color","#9d9d9d");
		$(".content-holder").empty();
		var priestProfieHTML = '<div class="posRelative"><form id="priest_form" class="form-horizontal" role="form">'
								+'<div class="form-group">'
								  +'<label class="control-label col-sm-2" for="idValue">Login ID:</label>'
								  +'<div class="col-sm-6">'
									+'<input type="text" class="form-control" id="idValue" placeholder="Enter your Login Id" required>'
								  +'</div>'
								+'</div>'
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
							  +'<div class="profileImageUpload">'
									+'<div style="width:150px;height:150px;border:1px solid black;">'			
										+'<img src="images/no-image-icon-md.png" alt="Profile Picture" style="max-width:100%;height:100%;" class="profilePicImageHolder"/>'
									+'</div>'
							  +'</div>'
							  +'<div class="profileUploadButton">'
								+'<div class="fileUpload btn btn-primary">'
									+'<span>Change Image</span>'
									+'<input id="uploadBtn" type="file" class="upload" onchange="readImageURL(this);" />'
								+'</div>'
								 /* +'<input type="file" id="profile_image" onchange="readImageURL(this);">' */
							   +'</div>'
							  +'</div>';
		$(".content-holder").append(priestProfieHTML);
	},
	formValidation : function(){
		var phoneNumber = $("#contactNumber").val();
		var loginID = $("#idValue").val();
		var firstName = $("#firstName").val();
		var currentChurch = $("#currentChurch").val();
		var about = "about";
		var gender = "Male";
		
		var priest = {
			id : loginID,
			firstName : firstName,
			currentChurch : currentChurch,
			about : about,
			gender : gender
		};
		
		$.ajax({
			type : "POST",
			async : true,
			dataType : "application/json",
			url : "http://localhost:8080/crud/rest/priest/create",
			data : priest,
			xhrFields: {
				withCredentials: true
			  },
			crossDomain: true,
			success : function(resp){
				console.log(resp.responseText);
				debugger;
			},
			error : function(resp){
				console.log(error);
			}
	});
	}
}