<!doctype html>
<html>
<head>
   <title>Sum of two integers</title>
</head>
<body>
    <h1>Input two integers</h1>

    <!-- method m��rittelee pyynn�n tyypin, joka on oletuksena get -->
    <form method="post" action="/sum">
        <!-- name m��rittelee, mink� nimiseen http-parametriin kent�n arvo asetetaan -->
        a = <input type="number" name="a" required><br />
        b = <input type="number" name="b" required><br />

        <input type="submit" value="Calculate sum">
    </form>
</body>
</html>