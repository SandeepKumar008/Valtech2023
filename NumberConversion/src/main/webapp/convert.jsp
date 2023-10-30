<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number System Converter</title>
<style type="text/css">
* {
    margin: 0;
    padding: 0;
}
body {
    background-color: #f2f2f2;
    font-family: Arial, sans-serif;
}
.container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}
.title {
    font-size: 24px;
    text-align: center;
    margin-bottom: 20px;
    color: #3498db;
}
.form-group {
    margin-bottom: 15px;
}

.label {
    font-weight: bold;
}
.form-control {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
}
.btn {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #3498db;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}
select.form-control {
    width: 100%;
}
.form-group + .form-group {
    margin-top: 10px;
}
</style>
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