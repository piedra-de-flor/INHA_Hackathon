<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
<script>
    $(function() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition (function(pos) {
                $('#latitude').html(pos.coords.latitude);
                $('#longitude').html(pos.coords.longitude);
            });
        } else {
            alert("This browser is not support Geolocation")
        }
    });
</script>
</head>
<body>
    <ul>
        <li>latitude :<span id="latitude"></span></li>
        <li>longitude :<span id="longitude"></span></li>
    </ul>
</body>
</html>

