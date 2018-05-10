$(document).ready(function () {  
	$("#btnTest").click(function () {
		var qParamter = $("#username").val(); 
		$.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/getProfile/'+qParamter,  
            type:'get', 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {
			var tableStr="<table>";
			tableStr =tableStr+"<thead><td>ID</td><td>Name</td><td>Sex</td><td>Unit</td>" +
					"<td>Phone</td><td>Email</td><td>IDcard</td></thead>";
			tableStr=tableStr+"<tr><td>"+resultData.userid+"</td>"+"<td>"+resultData.username+"</td>"+"<td>"+resultData.sex+"</td>"
					+"<td>"+resultData.unit+"</td>"+"<td>"+resultData.phone+"</td>"
					+"<td>"+resultData.email+"</td>"+"<td>"+resultData.IDcard+"</td></tr>";
			tableStr=tableStr+"</table>";
			$("#div1").append(tableStr);
            },  
        	error:function(XMLHttpRequest, textStatus, errorThrown){   
                alert(XMLHttpRequest.status);  
                alert(XMLHttpRequest.readyState);  
                alert(textStatus);  
            }  
        });
        
    });
	
	$("#btnTest1").click(function () {
		var qParamter = $("#username").val();
        $.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/getThingFuzzly/'+qParamter,  
            type:'get', 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {
        		if(resultData!=null){
	    			var obj = resultData.device;
	        		$("#div1").text('');
	        		var tableStr="<table>";
                    tableStr =tableStr+"<thead><td>ID</td><td>Name</td><td>Date</td><td>Unit</td>" +
                        "<td>Sta</td><td>Class</td><td>Supplier</td><td>Position</td>" +
                        "<td>Price</td><td>Manager</td></thead>";
	        		if (Array.isArray(obj)) {
	        			
		        		$(obj).each(function(index) {
		        			var val = obj[index];
		                    tableStr=tableStr+"<tr><td>"+val.equNumber+"</td>"+"<td>"+val.equName+"</td>"
		                        +"<td>"+val.equDate+"</td>"+"<td>"+val.equUnit+"</td>"
		                        +"<td>"+val.equSta+"</td>"+"<td>"+val.equClass+"</td>"
		                        +"<td>"+val.supplier+"</td>"+"<td>"+val.presentPosition+"</td>"
		                        +"<td>"+val.unitPrice+"</td>"+"<td>"+val.maintainer+"</td></tr>";
		        	      });
		                tableStr=tableStr+"</table>";
	        		}
	        		else{
	        				var tableStr="<table>";
	        				tableStr =tableStr+"<thead><td>ID</td><td>Name</td><td>Date</td><td>Unit</td>" +
		                        "<td>Sta</td><td>Class</td><td>Supplier</td><td>Position</td>" +
		                        "<td>Price</td><td>Manager</td></thead>";
	        				tableStr=tableStr+"<tr><td>"+obj.equNumber+"</td>"+"<td>"+obj.equName+"</td>"
		                        +"<td>"+obj.equDate+"</td>"+"<td>"+obj.equUnit+"</td>"
		                        +"<td>"+obj.equSta+"</td>"+"<td>"+obj.equClass+"</td>"
		                        +"<td>"+obj.supplier+"</td>"+"<td>"+obj.presentPosition+"</td>"
		                        +"<td>"+obj.unitPrice+"</td>"+"<td>"+obj.maintainer+"</td></tr>";
	        				tableStr=tableStr+"</table>";
        		}
        		}else{
        			
        		$("#div1").text('查无此人');
        		}
                $("#div1").append(tableStr);
            },  
        	error: function(err) {     
		        alert(err.responseText);     
		    } 
        });  
    }); 

	$("#btnTest2").click(function () {
		var qParamter = $("#username").val(); 
		$.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/getThing/'+qParamter,  
            type:'GET', 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {  
				var tableStr="<table>";
				tableStr =tableStr+"<thead><td>ID</td><td>Name</td><td>Date</td><td>Unit</td>" +
						"<td>Sta</td><td>Class</td><td>Supplier</td><td>Position</td>" +
						"<td>Price</td><td>Manager</td></thead>";
				tableStr=tableStr+"<tr><td>"+resultData.equNumber+"</td>"+"<td>"+resultData.equName+"</td>"
						+"<td>"+resultData.equDate+"</td>"+"<td>"+resultData.equUnit+"</td>"
						+"<td>"+resultData.equSta+"</td>"+"<td>"+resultData.equClass+"</td>"
						+"<td>"+resultData.supplier+"</td>"+"<td>"+resultData.presentPosition+"</td>"
						+"<td>"+resultData.unitPrice+"</td>"+"<td>"+resultData.maintainer+"</td></tr>";
				tableStr=tableStr+"</table>";
				$("#div1").append(tableStr);
            },  
        	error: function(err) {     
		        alert(err.responseText);     
		    } 
        });  
	}); 
	
	$("#btnTest3").click(function () {
		paramter= JSON.stringify({"username":$("#username").val(), "IDcard":$("#IDcard").val()
			, "sex":$("#sex").val(), "unit":$("#unit").val(),"phone":$("#phone").val(), "email":$("#email").val()});
		$.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/addUser',  
            type:'POST', 
            data:paramter, 
            cache : false,
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {
			    alert("your id is "+resultData.userid);
//				var tableStr="<table>";
//				tableStr =tableStr+"<thead><td>ID</td><td>Name</td><td>Sex</td><td>Unit</td>" +
//						"<td>Phone</td><td>Email</td><td>IDcard</td></thead>";
//				tableStr=tableStr+"<tr><td>"+resultData.userid+"</td>"+"<td>"+resultData.username+"</td>"+"<td>"+resultData.sex+"</td>"
//						+"<td>"+resultData.unit+"</td>"+"<td>"+resultData.phone+"</td>"
//						+"<td>"+resultData.email+"</td>"+"<td>"+resultData.IDcard+"</td></tr>";
//				tableStr=tableStr+"</table>";
//				$("#div1").append(tableStr);
//			    $("#div1").append('--------------');
//	  	        $("#div1").append('<p>姓名:' + resultData.username + '</p>');
//	  	        $("#div1").append('<p>性别:' + resultData.sex+ '</p>');
//	  	        $("#div1").append('<p>单位:' + resultData.unit + '</p>');
//	  	        $("#div1").append('<p>电话:' + resultData.phone + '</p>');
//	  	        $("#div1").append('<p>邮箱:' + resultData.email + '</p>');
//	  	        $("#div1").append('<p>身份证:' + resultData.IDcard + '</p>');
//	  	        $("#div1").append('--------------');
            },  
        	error: function(XMLHttpRequest, textStatus, errorThrown){   
                alert(XMLHttpRequest.status);  
                alert(XMLHttpRequest.readyState);  
                alert(textStatus);  
            }
        });  
	}); 
	

	$("#btnTest4").click(function () {   
		var qParamter = $("#username").val(); 
        $.ajax({  
        	url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/deleteDevice/'+qParamter,  
            type:'delete', 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {  
        		alert("Successful!");
            },  
        	error: function(err) {     
		        alert(err.responseText);     
		    } 
        });  
    });
	
	$("#btnTest5").click(function () {
		paramter= JSON.stringify({"equName":$("#equName").val(), "equDate":$("#equDate").val()
			, "equSta":$("#equSta").val(), "equUnit":$("#equUnit").val(),"extra":$("#extra").val()
			, "equClass":$("#equClass").val(),"supplier":$("#supplier").val(),"maintainer":$("#maintainer").val()
			, "presentPosition":$("#presentPosition").val(),"unitPrice":$("#unitPrice").val()}); 
		$.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/addDevice',  
            type:'POST', 
            data:paramter, 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {  
//				$("#div1").hide();
//				$("#div1").append('--------------');
//	  	        $("#div1").append('<p>编号:' + resultData.equNumber + '</p>');
//	  	        $("#div1").append('<p>名称:' + resultData.equName+ '</p>');
//	  	        $("#div1").append('<p>日期:' + resultData.equDate + '</p>');
//	  	        $("#div1").append('<p>单位:' + resultData.equUnit + '</p>');
//	  	        $("#div1").append('<p>状态:' + resultData.equSta + '</p>');
//	  	        $("#div1").append('<p>分类:' + resultData.equClass + '</p>');
//	  	        $("#div1").append('<p>供货商:' + resultData.supplier + '</p>');
//	  	        $("#div1").append('<p>存放位置:' + resultData.presentPosition + '</p>');
//	  	        $("#div1").append('<p>单价:' + resultData.unitPrice + '</p>');
//	  	        $("#div1").append('<p>管理者:' + resultData.maintainer + '</p>');
//	  	        $("#div1").append('<p>补充:' + resultData.extra + '</p>');
//	  	        $("#div1").append('--------------');
            },  
        	error: function(err) {     
		        alert(err.responseText);     
		    } 
        });  
	}); 
		
	$("#btnTest6").click(function () {
		var qParamter = $("#username").val(); 
		$.ajax({  
            url:'http://api.shenjian.io/todayoil/query?appid=8b0b0ac64a34af7361e65eddd0b65246&prov='+qParamter,  
            type:'get', 
            cache : false,
            dataType:'jsonp',
            jsonpCallback:'mytest',
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {	
			$("#div1").empty();
			var tableStr="<table>";
			tableStr =tableStr+"<thead><td>Provice</td><td>0</td><td>95</td><td>89</td>" +
					"<td>92</td><td>Time</td></thead>";
			var obj=resultData.data.showapi_res_body.list;
			if (Array.isArray(obj)){
				$(obj).each(function(index){
					var val=obj[index]
					tableStr=tableStr+"<tr><td>"+val.prov+"</td>"+"<td>"+val.p0+"</td>"
						+"<td>"+val.p95+"</td>"+"<td>"+val.p89+"</td>"
						+"<td>"+val.p92+"</td>"+"<td>"+val.ct+"</td></tr>";
				
				});
				tableStr=tableStr+"</table>";
			}
			else {
				tableStr=tableStr+"<tr><td>"+obj.prov+"</td>"+"<td>"+obj.p0+"</td>"
				+"<td>"+obj.p95+"</td>"+"<td>"+obj.p89+"</td>"
				+"<td>"+obj.p92+"</td>"+"<td>"+obj.ct+"</td></tr>";
			}
			
			$("#div1").append(tableStr);
            },  
        	error:function(XMLHttpRequest, textStatus, errorThrown){   
                alert(XMLHttpRequest.status);  
                alert(XMLHttpRequest.readyState);  
                alert(textStatus);  
            }  
        });
        
    });
	$("#btnTest7").click(function () {
		$.ajax({  
            url:'http://api.shenjian.io/?appid=5180e873961e919f3f60deffc1c77e29',  
            type:'get', 
            cache : false,
            dataType:'jsonp',
            jsonpCallback:'mytest',
            contentType: "application/json;charset=gb2312",  
            success : function(resultData, textStatus) {
			$("#div1").empty();
			var tableStr="<table>";
			tableStr =tableStr+"<thead><td>Rank</td><td>movie</td><td>box</td><td>Total</td>" +
					"<td>Days</td><td>Rate</td><td>Time</td></thead>";
			var obj=resultData.data;
			if (Array.isArray(obj)){
				$(obj).each(function(index){
					var val=obj[index]
					tableStr=tableStr+"<tr><td>"+val.Irank+"</td>"+"<td>"+val.MovieName+"</td>"
						+"<td>"+val.BoxOffice+"</td>"+"<td>"+val.sumBoxOffice+"</td>"
						+"<td>"+val.movieDay+"</td>"+"<td>"+val.boxPer+"<td>"+val.time+"</td></tr>";
				
				});
				tableStr=tableStr+"</table>";
			}
			else {
				tableStr=tableStr+"<tr><td>"+obj.Irank+"</td>"+"<td>"+obj.MovieName+"</td>"
				+"<td>"+obj.BoxOffice+"</td>"+"<td>"+obj.sumBoxOffice+"</td>"
				+"<td>"+obj.movieDay+"</td>"+"<td>"+obj.boxPer+"<td>"+obj.time+"</td></tr>";
			}
			
			$("#div1").append(tableStr);
            },  
        	error:function(XMLHttpRequest, textStatus, errorThrown){   
                alert(XMLHttpRequest.status);  
                alert(XMLHttpRequest.readyState);  
                alert(textStatus);  
            }  
        });
        
    });
	$("#btnTest8").click(function () {
		var qParamter = $("#username").val(); 
		$.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/getThing/'+qParamter,  
            type:'GET', 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) {
			 	$("#equNumber").val(resultData.equNumber);
			    $("#equName").val(resultData.equName);
			    $("#equDate").val(resultData.equDate);
			    $("#equUnit").val(resultData.equUnit);
			    $("#equSta").val(resultData.equSta);
			    $("#equClass").val(resultData.equClass);
			    $("#equDate").val(resultData.equDate);
			    $("#supplier").val(resultData.supplier);
			    $("#presentPosition").val(resultData.presentPosition);
			    $("#unitPrice").val(resultData.unitPrice);
			    $("#maintainer").val(resultData.maintainer);
			    $("#extra").val(resultData.extra);
            },  
        	error: function(err) {     
		        alert(err.responseText);     
		    } 
        });  
	}); 
	$("#btnTest9").click(function () {
		paramter= JSON.stringify({"equNumber":$("#equNumber").val(),"equName":$("#equName").val(), "equDate":$("#equDate").val()
			, "equSta":$("#equSta").val(), "equUnit":$("#equUnit").val(),"extra":$("#extra").val()
			, "equClass":$("#equClass").val(),"supplier":$("#supplier").val(),"maintainer":$("#maintainer").val()
			, "presentPosition":$("#presentPosition").val(),"unitPrice":$("#unitPrice").val()}); 
		$.ajax({  
            url:'http://windows10.microdone.cn:9090/TeachingDemo-RS/services/user/updateDevice',  
            type:'POST', 
            data:paramter, 
            cache : false,  
            contentType: "application/json;charset=utf-8",  
            success : function(resultData, textStatus) { 
				$("#equNumber").val(resultData.equNumber);
			    $("#equName").val(resultData.equName);
			    $("#equDate").val(resultData.equDate);
			    $("#equUnit").val(resultData.equUnit);
			    $("#equSta").val(resultData.equSta);
			    $("#equClass").val(resultData.equClass);
			    $("#equDate").val(resultData.equDate);
			    $("#supplier").val(resultData.supplier);
			    $("#presentPosition").val(resultData.presentPosition);
			    $("#unitPrice").val(resultData.unitPrice);
			    $("#maintainer").val(resultData.maintainer);
			    $("#extra").val(resultData.extra);
            },  
        	error: function(err) {     
		        alert(err.responseText);     
		    } 
        });  
	}); 
});

