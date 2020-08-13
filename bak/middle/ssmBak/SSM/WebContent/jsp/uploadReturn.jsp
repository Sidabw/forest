<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv=Content-Type content="text/html; charset=utf-8" />
<title>单张图片上传</title>
<!-- <link rel="stylesheet" type="text/css" href="../CSS/uploadImg.css">
<link rel="stylesheet" href="../CSS/bootstrap.min.css"> -->
<script src="../js/jquery-1.9.1.js"></script>
<style type="text/css">
</style>
</head>
<body>
	<div style="height: 500px;">
		<div class="img-box">
			<img src="" id="yushow" />
			<button class="btn-uploading" onclick="uploadBtn();">
				<i class="icon-uploading"></i>上传图片
			</button>
			<a class="shan" onclick="deleteImg();">删除</a>
		</div>
		<input type="file" name="file" style="display: none;"
			onchange="previewImg(this);" id="upload" accept="image/*" />
	</div>
</body>
<script type="text/javascript">
	function uploadBtn() {
		$("#upload").click();
	}

	//图片预览
	function previewImg(imgFile) {
		console.log(imgFile);//这里打印出是整个input标签
		var extension = imgFile.value.substring(imgFile.value.lastIndexOf("."),
				imgFile.value.length);//扩展名
		// console.log(extension);
		extension = extension.toLowerCase();//把文件扩展名转换为小写
		if ((extension != '.jpg') && (extension != '.gif')
				&& (extension != '.jpeg') && (extension != '.png')
				&& (extension != '.bmp')) {
			layer.msg("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传，谢谢 !");
			$(".btn-uploading").focus();//将焦点定位在文件上传的按钮上，可以直接按确定键再次触发
		} else {
			var path;//预览地址
			if (document.all) {//IE
				imgFile.select();
				path = document.selection.createRange().text;
				//alert("if"+path);
			} else {//火狐，谷歌
				path = window.URL.createObjectURL(imgFile.files[0]);
			}
			$("#yushow").attr("src", path);//设置预览地址
			uploadImg(imgFile);
		}
	}

	//开始上传
	function uploadImg(imgFile) {
		//获取图片文件
		var file = imgFile.files[0];//文件对象,文件的名称
		var name = file.name;//图片名
		//var size = file.size;//图片大小
		//var type = file.type;//文件类型
		//检测浏览器对FileReader的支持
		if (window.FileReader) {
			var reader = new FileReader();
			reader.onload = function() {//异步方法,文件读取成功完成时触发
				var dataImg = reader.result;//文件一旦开始读取，无论成功或失败，实例的 result 属性都会被填充。如果读取失败，则 result 的值为 null ，否则即是读取的结果
				syncUpload(name, dataImg);
			};
			reader.readAsDataURL(file);//将文件读取为 DataURL
		} else {
			layer.msg("浏览器不支持H5的FileReader!");
		}
	}

	function syncUpload(name, dataImg) {
		var imgFile = dataImg.replace(/\+/g, "#wb#");//将所有“+”号替换为“#wb#”
		imgFile = imgFile.substring(imgFile.indexOf(",") + 1);//截取只保留图片的base64部分,去掉了data:image/jpeg;base64,这段内容
		imgFile = encodeURIComponent(imgFile);//把字符串作为 URI 组件进行编码。后台容器会自动解码一次
		name = encodeURIComponent(encodeURIComponent(name));//这里对中文参数进行了两次URI编码，后台容器自动解码了一次，获取到参数后还需要解码一次才能得到正确的参数内容
		var mydata = "method=uploadImg&imgFile=" + imgFile + "&imgName=" + name;
		$.ajax({
			url : "../CarousePicServlet",
			data : mydata,
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.state == 'ok') {
					document.getElementById("upload").value = "";//重置文件域
					layer.msg(data.msg);
				} else if (data.state == 'error') {
					layer.msg(data.msg);
				}
			}
		});
	}

	//删除图片
	function deleteImg() {
		$.ajax({
			url : "../CarousePicServlet",
			data : "method=deleteImg",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.state == 'ok') {
					layer.msg(data.msg);
				} else if (data.state == 'error') {
					layer.msg(data.msg);
				}
			}
		});
	}
</script>
</html>