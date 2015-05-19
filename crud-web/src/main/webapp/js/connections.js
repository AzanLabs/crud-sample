//This file contains jquery calls to connect to the endpoint

//to sav priest profile
var priest = {}; //fill it with priest data
$.ajax({
    type : "POST",
    dataType : "json",
    contentType : "application/json;charset-UTF-8",
    url : './rest/priest/create',
    data : JSON.stringify(priest),
    success : function(resp){
        console.log(resp);
    },
    error : function(resp){
        console.log(resp);
    }
});


//to get all priest
$.ajax({
    type : "GET",
    url : './rest/priest/all',
    success : function(resp){
        console.log(resp);
    },
    error : function(resp){
        console.log(resp);
    }
});

//to update a priest
var priest = {}//fill it with data to be updated id is must
$.ajax({
    type : "PUT",
    url : './rest/priest/update',
    dataType : "json",
    contentType : "application/json;charset-UTF-8",
    data : JSON.stringify(priest),
    success : function(resp){
        console.log(resp);
    },
    error : function(resp){
        console.log(resp);
    }
});

//to delete a priest
var priestId = 1002 //id of priest
var delUrl = './rest/priest/delete/'+id;
$.ajax({
    type : "DELETE",
    url : delUrl,
    data : JSON.stringify(priest),
    success : function(resp){
        console.log(resp);
    },
    error : function(resp){
        console.log(resp);
    }
});


//to upload prist image
/*
var data = new FormData();
var file = $("#uploadBtn")[0].files[0];
data.append("file", file);
data.append("id", "1003");
data.
$.ajax({
    type : "POST",
    url : "http://localhost:8080/crud/rest/image/upload",
    cache : false,
    contentType : 'multipart/form-data',
    processData : false,
    data : file,
    success : function(resp){
        console.log(resp);
    },
    error : function(resp){
        console.log(resp);
    }
});*/ //not working

//to get the priest profile image
var idOfPriest = "1003";
var getUrl = "./rest/priest/image/"+idOfPriest;
$.ajax({
    type : "GET",
    url : getUrl,
    success : function(resp){
        console.log(resp);
    },
    error : function(resp){
        console.log(resp);
    }
});
// call the url { grtUrl } from src of image tag to get the image.