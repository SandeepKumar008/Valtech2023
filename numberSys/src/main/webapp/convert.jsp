<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number System Converter</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body class="convert-bg">
	<div class="container convert-container">

		<h1 class="title">Number System Converter</h1>
		<form action="NumberSystemServlet" method="post">
			<div class="form-group">
				<label for="system" class="label">Number System:</label> <select
					id="system" name="system" class="form-control">
					<option value="hex">Hexadecimal</option>
					<option value="dec">Decimal</option>
					<option value="bin">Binary</option>
					<option value="oct">Octal</option>
					<option value="pow2">hecto</option>
					<option value="pow6">mega</option>
					<option value="pow9">giga</option>
					<option value="pow12">tera</option>
					<option value="pow-6">micro</option>
					<option value="pow-9">nano</option>
				 </select>
            </div>
            <div class="form-group">
                <label for="input1" class="label">Input 1:</label>
                <input type="text" id="input1" name="input1" class="form-control"><br>
            </div>
            <div class="form-group">
                <label for="input2" class="label">Input 2:</label>
                <input type="text" id="input2" name="input2" class="form-control"><br>
            </div>
            <button type="submit" class="btn btn-primary">Convert</button>
        </form>
    </div>
</body>
</html>