<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="jquery/jquery-ui-1.11.0/jquery-ui.min.css" >
<link type="text/css" rel="stylesheet" href="css/ui.jqgrid.css">

<script src="jquery/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="jquery/jquery-ui-1.11.0/jquery-ui.min.js"></script>
	<script type="text/javascript" src = "jquery/jquery-ui-1.11.0/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript" src="jquery/jquery.jqGrid.src.js"></script>
    <script type="text/javascript" src="jquery/grid.locale-cn.js"></script>
<script type="text/javascript">
	function showIdPhotos(imgName){
		$("#imgIdPhoto").attr("src" , "idphotos/" + imgName);
		$("#dlgImage").dialog({
			width:$("#imgIdPhoto").css("width") + 30,
			heigth:$("#imgIdPhoto").css("height") + 10,
			modal:true,
			title : "身份证"
		});
	}
	
	function down(imgName){
		window.location = "users/download.action?idphotoFileName=" + imgName;
	}
	
	$(function(){
		$("#divPanel").dialog({
			title : "用户列表",
			width : 800,
			height : 400
		});
		
		$("#tabUserList").jqGrid({
			width : 700,
			height : 300,
			url : "getlist.action" , 
			datatype : "json" ,
			colNames :["姓名" , "性别" , "籍贯" , "身份证号" , "生日" , "照片"] ,
			colModel :[
				{name : "name" , index : "name" , width:100},
				{name : "sex" , index : "sex" , width:100},
				{name : "nativeplace" , index : "nativeplace" , width:100},
				{name : "idcard" , index : "idcard" , width:100},
				{name : "birthday" , index : "birthday" , width:100},
				{name : "filename" , index : "filename" , width:100 , align : "center"}
			],
			pager : "#pager",
			rowNum : 5,
			rowList : [5,10,20,50,100] 
		})
	})
</script>
</head>
<body>
	<div id = "divPanel">
		<table id = "tabUserList"></table>
	</div>
	<div id = "pager"></div>
	<div id = "dlgImage" style = "display:none">
		<img id = "imgIdPhoto"/>
	</div>
</body>
</html>