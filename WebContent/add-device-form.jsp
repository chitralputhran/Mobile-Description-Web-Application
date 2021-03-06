<!DOCTYPE html>
<html>

<head>
	<title>Add Device</title>


	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
</head>

<body>

		<div class="card-header">
			<h2>Mobile Device</h2>
		</div>

	
	<div id="container">
		<h5>Add Device</h5>
		
		<form action="ControllerDB" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table class = "table">
				<tbody>
					<tr>
						<td><label>Device Name:</label></td>
						<td><input type="text" name="deviceName" /></td>
					</tr>

					<tr>
						<td><label>Brand:</label></td>
						<td><input type="text" name="brand" /></td>
					</tr>

					<tr>
						<td><label>Technology:</label></td>
						<td><input type="text" name="technology" /></td>
					</tr>
					
					<tr>
						<td><label>GPRS:</label></td>
						<td><input type="text" name="gprs" /></td>
					</tr>
					
					<tr>
						<td><label>Edge:</label></td>
						<td><input type="text" name="edge" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save btn btn-primary" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="ControllerDB">Back to List</a>
		</p>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>
