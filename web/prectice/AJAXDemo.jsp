<html>
<head>
    <script type="text/javascript">
        function loadXMLDoc()
        {
            var xmlhttp;
            var txt,x,i;
            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else {
                // code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function() {
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    var txt = xmlhttp.responseTest;
                    document.getElementById("myDiv").innerHTML=xmlhttp.responseTest;
                }
            }
            xmlhttp.open("GET","${pageContext.request.contextPath}/productServlet?method=AJAXTest",true);
            xmlhttp.send();
        }
    </script>
</head>

<body>

<h2>My Book Collection:</h2>
<div id="myDiv"></div>
<button type="button" onclick="loadXMLDoc()">获得我的图书收藏列表</button>

</body>
</html>