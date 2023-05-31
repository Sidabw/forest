<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Hello, World</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #allmap{height:100%}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=e45N5pTfiNyESr5GwhgYqktfjiAYzpHv">
        //v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
    </script>
</head>

<body>
<div id="allmap"></div>
<script type="text/javascript">
    //坑1，用火狐测试...
    // 创建地图实例
    var map = new BMap.Map("allmap");
    map.enableScrollWheelZoom(true);

    //添加控件
    map.addControl(new BMap.NavigationControl());   //平移缩放控件
    map.addControl(new BMap.ScaleControl());    //比例尺控件
    // map.addControl(new BMap.OverviewMapControl());  //缩略图控件
    map.addControl(new BMap.MapTypeControl());

    //设置地图样式
    var mapStyle = {style:"midnight"};
    map.setMapStyle(mapStyle);
    //定位：浏览器定位
    var geolocation = new BMap.Geolocation();
    geolocation.getCurrentPosition(function(r){
        if(this.getStatus() == BMAP_STATUS_SUCCESS){
            var mk = new BMap.Marker(r.point);
            map.addOverlay(mk);
            // map.panTo(r.point);
            map.centerAndZoom(r.point,22);
            // alert('您的位置：'+r.point.lng+','+r.point.lat);
        }
        else {
            alert('failed'+this.getStatus());
        }
    });
</script>
</body>
</html>