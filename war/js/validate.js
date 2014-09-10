

window.onload=init;
function init(){
	document.getElementById("textval1").focus();

}
/*function getvalue(){
	$( document ).ready(function() {
	$(function() {
	  $("#getvalue").validate({
	      rules: {
	          textval1: "required",
	          textval2: {
	              required: true,
	              number: true,
	              minlength: 10
	          },
	          textval3: {
	              required: true,
	              email: true
	          },
	          textval4: {
	              required: true,
	              email: true
	          },
	          textval5:"required",
	         
	      },
	      messages: {
	          textval1: "Please enter your first name",
	          textval2: "Please enter your phonenumber",           
	          textval3: "Please enter a valid email id",
	          textval4: "Please enter a valid email id",
	          textval5: "Please enter your valid address"
	      },
	     
	      submitHandler: function(form) {
	    	  form.click();
	    	  take1();
	      }
	  
	  });
	
	});
	});
	}*/
function take1(){
	$( document ).ready(function() {
    var textval1 = $("#textval1").val();
    var textval2 = $("#textval2").val();
    var textval3 = $("#textval3").val();
    var textval4 = $("#textval4").val();
    var textval5 = $("#textval5").val();
   
	var collect={"textval1":textval1,"textval2":textval2,"textval3":textval3,"textval4":textval4,"textval5":textval5};
                       $.ajax({ 
                      url:'/JSONstartServlet', 
                      type:'GET',                                  
                      contentType: 'application/json',
                      data:collect,
                      dataType: 'json',
                      success: function(data) { 
                                                 
                                                  
                                                   $("#message1").html("<p>succefully inserted</p>");
                                                   document.location.reload(true);
                      },
                                    error: function(e) {
                                    	$("#message1").html("<p>Fields are Empty</p>");
                                    	document.location.reload(true);
                                    }
                  });
	 });
              
}
function take2(){
	$( document ).ready(function() {               
    $('#dButton').click(function(event) {  
        var textvald1=$('#textvald1').val();
     $.get('JSONstartServlet1',{textvald1:textvald1},function(responseText) { 
            $('#message2').text(responseText);         
        });
    });
	   });
}

function take3(){
	$( document ).ready(function() { 
$('#tButton').click(function() {  
var textvals1=$("#textvals1").val();
$.getJSON('JSONstartServlet2',{textvals1:textvals1},function(responseJson) {   
                      
   var table = $('#innermessage');               
   $.each(responseJson, function(key, value) { 
	   
      $('<tr>').appendTo(table)
       .append($('<td>').text("Name:"))
        .append($('<td>').text(value.name));
      $('<tr>').appendTo(table) 
      .append($('<td>').text("Phone Number:"))
        .append($('<td>').text(value.ph_No));
      $('<tr>').appendTo(table)
      .append($('<td>').text("Email:"))
        .append($('<td>').text(value.email));
      $('<tr>').appendTo(table)
      .append($('<td>').text("Alternate-Email:"))
        .append($('<td>').text(value.al_Email));
      $('<tr>').appendTo(table)
      .append($('<td>').text("Address:"))
        .append($('<td>').text(value.address));
        });
});
});
	 });

}



