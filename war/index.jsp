<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
  <head>
    	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    	<title>ContactList</title>
        <script src="//code.jquery.com/jquery-1.9.1.js"></script>  
		<meta http-equiv="X-Frame-Options" content="DENY"/>
		<link type="text/css" rel="stylesheet" href="css/index.css">
		<link href="css/runnable.css" rel="stylesheet" />
		<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
		<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
		<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  </head>
  <body class="body_container" dir="ltr">
  <div class="sub_container">
<div id="add" class="add_container">
<div class="coloradd">ADD</div>
 	<div>ENTER NAME:<input type="text" id="textval1"name="textval1" required ></input></div>
 	<div>ENTER NUMBER:<input type="text" id="textval2"name="textval2" required ></input></div>
  	<div>ENTER EMAIL:<input type="text" id="textval3"name="textval3" required></input></div>
    <div>ENTER ALTERNATE-EMAIL:<input type="text" id="textval4"name="textval4" required></input></div>
    <div>ENTER ADDRESS:<input type="text" id="textval5"name="textval5" required></input></div>
 	<div><button id="sButton" onclick="take1();">click</button></div>
  	<div id="message1"></div>
 </div>
 
<div id="search" class="search_container">
<div class="colorsearch">SEARCH</div>
 ENTER NAME:<input type="text" id="textvals1"name="textvals1" ></input>
  <button id="tButton" onclick="take3();">click</button>
  <div id="message3">
  <table id="innermessage"></table></div>
 </div>
 
 <div id="delete" class="remove_container">
 <div class="colordelete">DELETE</div>
 ENTER NUMBER:<input type="text" id="textvald1"name="textvald1"></input>
  <button id="dButton" onclick="take2();">click</button>
  <div id="message2"></div>
 </div>
 
 
 </div>
 <script type="text/javascript" src="js/validate.js"></script>
  </body>
</html>
