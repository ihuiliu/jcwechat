<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>金诚太悦</title>
		 <script src="jquery-1.9.1.min.js"></script>
	</head>
	<body>
		hhhhhhhhhhhhhhhhhhhh
		
		<input type="button"  value="立即登录" class="width100" onClick="getcode();">
		
	</body>
	<script type="text/javascript">	

	function getcode(){
	
		var jsonStr = {   
				 "mobileno": "13735478178",
				 "password": "435435",
					"status":"0",
					"comefrom":"1"  
		}
		// var jsonStr = $.toJSON( request );  
			$.ajax({
		        type: "post",
		        data : jsonStr,  
		       	//dataType: "json",
		        url: '${pageContext.request.contextPath}/user/login.action',
		        success: function (data) {
		            	alert(data);
		            	//alert(data.content);
		            }
		        
		    });
		
	}



</script>
</html>
