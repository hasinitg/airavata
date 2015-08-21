<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Airavata Sample Web Client</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<section class="container">
    <div class="login">
        <h1>Please select from the following authentication options:</h1>
        <form action="oauth2client" id="loginForm" method="post">
            <table style="width:100%;text-align:center;'">
                <tr>
                    <td style="text-align:center;width:100%">
                        <input type="submit" class="button" name="authType" value="OpenID-Connect"/>
                    </td>
                </tr>
                <tr></tr>
                <tr>
                    <td style="text-align:center;width:100%">
                        <input type="submit" class="button" name="authType" value="UsernamePassword"/>
                    </td>
                </tr>
            </table>
        </form>
        <div>
</section>

</body>
</html>