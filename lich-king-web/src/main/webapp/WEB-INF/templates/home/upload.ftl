<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lich King Upload</title>
</head>
<body>
<form method="post" action="http://upload.qiniu.com/"
      enctype="multipart/form-data">
    <input name="key" type="hidden" value="<resource_key>">
    <input name="x:<custom_name>" type="hidden" value="<custom_value>">
    <input name="token" type="hidden" value="<upload_token>">
    <input name="file" type="file"/>
    <input name="crc32" type="hidden"/>
    <input name="accept" type="hidden"/>
</form>
</body>
</html>