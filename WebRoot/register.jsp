<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>fff</title>

<style type="text/css">
	#tabUser input , #tabUser select {
		width : 100%
	}
	
	#tabUser tr td:nth-child(1){
		text-align:right;
	}
	
	.error {
		border : 2px dotted red;
	}
</style>

<link rel="stylesheet" type="text/css" href="jquery/jquery-ui-1.11.0/jquery-ui.min.css" >
	<script src="jquery/jquery-1.11.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="jquery/jquery-ui-1.11.0/jquery-ui.min.js"></script>
	<script type="text/javascript" src = "jquery/jquery-ui-1.11.0/jquery.ui.datepicker-zh-CN.js"></script>

<script type="text/javascript">
	$(function(){
		//将所有文本框的自动提醒关掉
		$("input[type='text']").attr("autocomplete" , "off");
		
		//each函数用于遍历选择器拿到的结果，在function(){}中使用$(this)来获取当前的对象
		$("*[title]").each(function(){
			$(this).attr("placeholder" , $(this).attr("title"));
		})
		//dialog()是jquery ui 为选择器扩展的方法，使用dialog可以将div变成对话框
		$("#divPanel").dialog({
			title : "用户注册" , 
			width : 600,
			height : 460,
			buttons : {
				"提交" : function(){
					var inpName = $("#name");
					var inpSex = $("#sex");
					var inpNativeplace = $("#nativeplace");
					var inpIdcard = $("#idcard");
					var inpBirthday = $("#birthday");
					
					$("input , select").removeClass("error");
					
					if(inpName.val().trim().length == 0){
						inpName.tooltip("open");
						inpName.addClass("error");
					};
					
					if(inpNativeplace.val().trim().length == 0){
						inpNativeplace.tooltip("open");
						inpNativeplace.addClass("error");
					};
					
					if(inpIdcard.val().trim().length == 0){
						inpIdcard.tooltip("open");
						inpIdcard.addClass("error");
					};
					
					if(inpBirthday.val().trim().length == 0){
						inpBirthday.tooltip("open");
						inpBirthday.addClass("error");
					};
					
					if($("*.error").size() == 0 ){
						$("#frmUser").submit();
					}
				},
				"重填" : function(){
					alert("点击重填按钮");
				}
			},
			position : {
				my : "center center",
				at : "center center"
			}
		});
		/*
		$("#nativeplace").autocomplete({
			source : "area" , 
			select : function(event , rec){
				console.info(rec);
				//val()不写参数代表获取，设置一个参数代表赋值
				$("#nativeplaceid").val(rec.item.id)
			}
		});*/
		
		$("#birthday").datepicker();
		$("*[title]").tooltip({
			position : {
				my : "left top" , 
				at : "right top"
			}
		});
	})
</script>
</head>
<body>
	<div id = "divAlert">验证有错</div>
	<div id = "divPanel">
		<form name = "frmUser" id = "frmUser" action = "reg.action" method = "post" enctype="multipart/form-data">
			<table style = "width:100%" id = "tabUser">
				<tr>
					<td style = "width : 20%">姓名:</td>
					<td style = "width : 80%"><input type = "text" id= "name" name = "name" title = "请输入中文名称！" /></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>
						<select name = "sex" id = "sex" title = "请选择性别">
							<option value = "男" selected>男</option>
							<option value = "女">女</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td style = "width : 20%">籍贯:</td>
					<td style = "width : 80%">
					<input type = "text" name = "nativeplace" id = "nativeplace" title = "请输入地区关键字"/>
						<input type = "hidden" name = "nativeplaceid" id = "nativeplaceid" />
					</td>
				</tr>
				
				<tr>
					<td style = "width : 20%">身份证:</td>
					<td style = "width : 80%"><input type = "text" name = "idcard" id = "idcard" title = "请输入15位或18位有效身份证号"/></td>
				</tr>
				
				<tr>
					<td style = "width : 20%">生日:</td>
					<td style = "width : 80%">
					<input type = "text" name = "birthday" id = "birthday" readonly = "readonly"  title = "请选择生日"/></td>
				</tr>
				
				<!-- tr>
					<td style = "width : 20%">身份证照片:</td>
					<td style = "width : 80%">
						<input type = "file" name = "idphoto" id = "idphoto"   title = "请选择身份证照片"/>
					</td>
				</tr -->
			</table>
		</form>
	</div>
</body>
</html>