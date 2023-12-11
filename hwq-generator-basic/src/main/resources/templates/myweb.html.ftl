<html>
<head>
  <title>测试!</title>
</head>
<body>
  <h1>欢迎 ${user}!</h1>
  <p>:
  <ul>
    <#list menuItems as item>
      <a href="${item.url}">${item.label}</a>!
    </#list>
  </ul>
<footer>
  ${currentYear} Hwq的测试页面
</footer>
</body>
</html>