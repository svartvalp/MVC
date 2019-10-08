<%--
  Created by IntelliJ IDEA.
  User: Константин
  Date: 01.10.2019
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <form name="dates" id="dates">
    <input name="list" />
    <input type="submit" />
  </form>
  <script>
    dates.onsubmit = async(e) => {
      e.preventDefault();
      let  data = new FormData(document.forms.dates);
      let responce = await fetch('/dates?months=' + data.get("list"),
              {
                method:'GET'
              });
      let result = await  responce.json();
      alert(result);
    };
  </script>
  </body>
</html>
