<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Hello, World</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #container{height:100%}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=e45N5pTfiNyESr5GwhgYqktfjiAYzpHv">
        //v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
    </script>
</head>

<body>
<div id="container"></div>
<div id="allmap"></div>
<script type="text/javascript">
    // 创建地图实例
    var map = new BMap.Map("container");
    map.enableScrollWheelZoom(true);

    //添加控件
    map.addControl(new BMap.NavigationControl());   //平移缩放控件
    map.addControl(new BMap.ScaleControl());    //比例尺控件
    // map.addControl(new BMap.OverviewMapControl());  //缩略图控件
    map.addControl(new BMap.MapTypeControl());
    map.setCurrentCity("北京");

    //设置地图样式
    var mapStyle = {style:"midnight"};
    map.setMapStyle(mapStyle);

    // 创建点坐标
    var point = new BMap.Point(116.404, 39.915);
    // 初始化地图，设置中心点坐标和地图级别
    // map.centerAndZoom(point, 15);

    //自定义标注
    var point2 = new BMap.Point(116.415, 39.001);
    var marker = new BMap.Marker(point2);        // 创建标注
    map.addOverlay(marker);
    map.centerAndZoom(point2, 15);

    var point3 = new BMap.Point(116.414, 39.001);
    var marker3 = new BMap.Marker(point3);        // 创建标注
    map.addOverlay(marker3);

    var point4 = new BMap.Point(116.414, 39.011);
    var marker4 = new BMap.Marker(point4);        // 创建标注
    map.addOverlay(marker4);

    //添加信息窗口
    // var opts = {
    //     width: 250,
    //     height: 100,
    //     title: "hello title"
    // }
    // var infoWindow = new BMap.InfoWindow("hello content", opts);
    // map.openInfoWindow(infoWindow, map.getCenter());

    //添加交通流量的图层
    // var traffic = new BMap.TrafficLayer();
    // map.addTileLayer(traffic);

    //根据daboxId创建自定义图层，用户可用自己创建的geotableid替换30960
    // var customLayer=new BMap.CustomLayer({
    //     geotableId: 30960,
    //     q: '', //检索关键字
    //     tags: '', //空格分隔的多字符串
    //     filter: '' //过滤条件,参考http://lbsyun.baidu.com/index.php?title=lbscloud/api/geosearch
    // });
    // map.addTileLayer(customLayer);

    //检索服务 ，检索poi(point of interest 兴趣点), 是不是云检索超过配额了啊。。 没结果呢
    // var map = new BMap.Map("container");
    // map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
    // var local = new BMap.LocalSearch(map, {
    //     renderOptions:{map: map}
    // });
    // local.search("景点");



</script>
</body>
</html>