<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>
            POST-METHOD
        </title>
    </head>
    <body>
        <form name="dates" id="dates">
            <input name="list" />
            <input type="submit" />
        </form>
            <script>
                document.forms.dates.onsubmit = async(e) =>
                {
                    e.preventDefault();
                    let data = new FormData(document.forms.dates);
                    let dat = JSON.parse(data.get("list"));
                    let response = await fetch('/dates/save', {
                        method: 'POST',
                        body: dat
                    });
                }
            </script>
    </body>
</html>