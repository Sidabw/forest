<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="main" style="background-color:white;height: 400px;width: 600px" ></div>
	<script type="text/javascript" src="../../js/echarts.js"></script>
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script type="text/javascript">
		function postImage(datalist) {
			console.log(datalist);
			console.log(',,');
			/* var datalist2 =datalist.split(',');
			var myChart = echarts.init(document.getElementById('main'));

			// 指定图表的配置项和数据
			var option = {
				title : {
					text : 'ECharts 入门示例'
				},
				tooltip : {},
				legend : {
					data : [ '销量' ]
				},
				xAxis : {
					data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ],
					//设置字体倾斜  
                    axisLabel:{  
                        interval:0,  
                        rotate:45,//倾斜度 -90 至 90 默认为0  
                        margin:2,  
                        textStyle:{  
                            fontWeight:"bolder",  
                            color:"#000000"  
                        }  
                    }
				},
				yAxis : {},
				series : [ {
					name : '销量',
					type : 'bar',
					data : datalist2,
					 //顶部数字展示pzr  
                    itemStyle: {  
                        normal: {  
                            label: {  
                                show: true,//是否展示  
                                textStyle: {  
                                    fontWeight:'bolder',  
                                    fontSize : '12',  
                                    fontFamily : '微软雅黑',  
                                }  
                            }  
                        }  
                    },
					animation : false
				// 关闭动画效果
				} ]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option); */
			//console.log(myChart.getDataURL());
		/* 	$.ajax({
				type : 'POST',
				url : '/sida/echartscontroller2',
				//async : false,
				data : {
					base64url : myChart.getDataURL()
				},
				success : function(data) {
				}
			}); */
		}
		/* var str = '5,20,36,10,10,20';
		var arr = str.split(',');
		postImage(arr); */
	</script>
</body>
</html>