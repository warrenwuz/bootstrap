<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>Spitter</title>
    <style type="text/css">
			body {
				font-family: sans-serif;
			}

			.spittleList h1 {
				font-size: 16pt;
			}

			.spittleList ul {
				list-style: none;
				margin-left: 0px;
				padding-left: 0px;
			}

			.spittleList ul li:first-child {
				border-top: 0px;
			}

			.spittleList ul li {
				border-top: 1px solid #cccccc;
			}

			.spittleTime {
				font-size: 8pt;
			}

			.spittleLocation {
				font-size: 8pt;
			}

			.spittleForm h1 {
				font-size: 16pt;
			}
		</style>
  </head>
  <body>
    <h1>Welcome to Spitter</h1>
    <a href="<c:url value="/spittles" />">Spittles</a> | 
    <a href="<c:url value="/spitter/register" />">Register</a>
  </body>
</html>
