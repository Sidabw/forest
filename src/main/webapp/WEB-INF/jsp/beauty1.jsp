<%--
  Created by IntelliJ IDEA.
  User: think
  Date: 2018/8/8
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <title>Home</title>
    <meta name="description" content="">
    <meta name="author" content="WebThemez">

    <link rel="stylesheet" href="/beautyTemplate1/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/beautyTemplate1/css/isotope.css" media="screen" />
    <link rel="stylesheet" href="/beautyTemplate1/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
    <link href="/beautyTemplate1/css/animate.css" rel="stylesheet" media="screen">
    <link href="/beautyTemplate1/flexslider/flexslider.css" rel="stylesheet" />
    <link href="/beautyTemplate1/js/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link rel="stylesheet" href="/beautyTemplate1/css/styles.css" />
    <!-- Font Awesome -->
    <link href="/beautyTemplate1/font/css/font-awesome.min.css" rel="stylesheet">
    <link rel="shortcut icon" href="piggy.ico" type="image/x-icon" />
</head></head>
<body>
<header class="header">
    <div class="container">
        <nav class="navbar navbar-inverse" role="navigation">
            <%--<div class="navbar-header">
                <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a href="/beauty1#home" class="navbar-brand scroll-top logo  animated bounceInLeft"><b><i>FOREST</i></b></a> </div>--%>
            <div class="navbar-header">
                <button type="button" id="nav-toggle1" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a href="/beauty1#home" class="navbar-brand scroll-top logo  animated bounceInLeft"><b><i>
                    <img src="/sida2.png" width="8%" height="8%" alt="ujnlogo"/>
                    sidabw
                </i></b></a> </div>
            <!--/.navbar-header-->
            <div id="main-nav" class="collapse navbar-collapse">
                <ul class="nav navbar-nav" id="mainNav">
                    <li class="active" id="firstLink"><a href="#home" class="scroll-link">Home</a>
                </ul>
                <ul class="nav navbar-nav" id="mainNav1">
                    <li class="active" id="firstLink1">
                        <a href = "/logout"> 注销 </a>
                </ul>
            </div>
            <!--/.navbar-collapse-->
        </nav>
        <!--/.navbar-->
    </div>
    <!--/.container-->
</header>
<!--/.header-->
<div id="#top"></div>
<section id="home">
    <div class="banner-container">
        <!-- Slider -->
        <div id="main-slider" class="flexslider">
            <ul class="slides">
                <li>
                    <img src="/beautyTemplate1/images/slides/1.jpg" alt="" />
                    <div class="flex-caption">
                        <h3>Awesome Design</h3>
                        <p>Doloribus omnis minus temporibus perferendis ipsa architecto non, magni quam</p>
                    </div>
                </li>
                <li>
                    <img src="/beautyTemplate1/images/slides/2.jpg" alt="" />
                    <div class="flex-caption">
                        <h3>Fully Responsive</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elitincidunt eius magni provident.</p>
                    </div>
                </li>
                <li>
                    <img src="/beautyTemplate1/images/slides/3.jpg" alt="" />
                    <div class="flex-caption">
                        <h3>Multi-purpose Theme</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit donec mer lacinia.</p>
                    </div>
                </li>
            </ul>
        </div>
        <!-- end slider -->
    </div>
    <div class="container hero-text2">
        <h3>Lorem ipsum dolor sit amet, ea eum labitur scsstie percipitoleat<br/> fabulas complectitur deterruisset at pro</h3>
    </div>
</section>
<section id="services" class="page-section colord">
    <div class="container">
        <div class="row">
            <!-- item -->
            <div class="col-md-3 text-center"> <i class="circle"><img src="/beautyTemplate1/images/1.png" alt=""  onclick="clickUploadIcon()"></i>
                <h3 onclick="clickUploadText()">Upload</h3>
                <h3 onclick="alert(1)">web socket</h3>

                <form id="uploadFormId" action="/user/upload2", method="post", enctype="multipart/form-data">
                    <input type="file" style = "display: none" id="uploadFileId" name="uploadFile" multiple="multiple"/>
                    <input name="userIdtime" value="sidabw" style = "display: none"/>
                </form>

                <p id="websocketMessageId">click the icon to choose the files to be uploaded, and click the text "Upload" to confirm upload operation.</p>
            </div>
            <!-- end: -->

            <!-- item -->
            <div class="col-md-3 text-center"><i class="circle"> <img src="/beautyTemplate1/images/2.png" alt="" /></i>
                <h3>Development</h3>
                <p>Nullam ac rhoncus sapien, non gravida purus. Alinon elit imperdiet congue. Integer elit imperdiet congue.</p>
            </div>
            <!-- end: -->

            <!-- item -->
            <div class="col-md-3 text-center"><i class="circle"> <img src="/beautyTemplate1/images/3.png" alt="" /></i>
                <h3>Marketing</h3>
                <p>Nullam ac rhoncus sapien, non gravida purus. Alinon elit imperdiet congue. Integer ultricies sed elit impe.</p>
            </div>
            <!-- end: -->

            <!-- item -->
            <div class="col-md-3 text-center"><i class="circle"> <img src="/beautyTemplate1/images/4.png" alt="" onclick="editSchduler()"/></i>
                <h3>Scheduler Creater</h3>
                <p>Create your scheduler and check out your email in half of minuter. Let's begin a journey.</p>
            </div>


            <!-- end:-->
        </div>
    </div>
    <!--/.container-->
</section>
<a href="/beautyTemplate1/#top" class="topHome"><i class="fa fa-chevron-up fa-2x"></i></a>
<section>
   <%-- <h1>prc</h1>
    <p1>The People's Repulic of China was born in 1949...</p1>--%>
    <div style="width: 100%; height: 100%; background-color: #D22F2F"></div>
</section>
<input id="secId" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<script src="/beautyTemplate1/js/modernizr-latest.js"></script>
<script src="/beautyTemplate1/js/jquery-1.8.2.min.js"></script>
<%--<script src="/js/jquery.min.js"></script>--%>
<script>

    function clickUploadText() {
        // alert(2);
        var uploadFormId = document.getElementById("uploadFormId");
        uploadFormId.submit();
    }

    function clickUploadIcon() {
        // alert(1);
        var uploadFileId = document.getElementById("uploadFileId");
        uploadFileId.click();
    }

    function  editSchduler() {
        var secValue = $("#secId").val();
        alert(secValue);
        alert(1);
        $.ajax({
            type: "POST",
            url: "/scheduler/editSchduler",
            data: {
                "_csrf" : secValue
            },
           /* dataType: "json",*/
            success: function (data) {
                alert(data);
                if (data.result == "1") {
                    window.location.href = "/user/dataList";
                } else {
                    alert("账号密码不能为空！");
                }
            }
        })
    }

    function  logout() {
        alert(2);
        $.ajax({
            type: "GET",
            url: "/logout",
            data: {
            },
            /*dataType: "json",*/
            success: function (data) {

               /* alert(data);
                if (data.result == "1") {
                    window.location.href = "/user/dataList";
                } else {
                    alert("账号密码不能为空！");
                }*/
            }
        })
    }
    //web socket 相关
    /*var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket("ws://localhost:8080/websocket");
    }
    else{
        alert('Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function(){
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function(event){
        setMessageInnerHTML("open");
    }

    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function(){
        setMessageInnerHTML("close");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML){
        document.getElementById('websocketMessageId').innerHTML += innerHTML + '<br/>';
    }

    //关闭连接
    function closeWebSocket(){
        websocket.close();
    }

    //发送消息
    function send(){
        var message = document.getElementById('text').value;
        websocket.send(message);
    }*/
</script>
</body>
</html>
