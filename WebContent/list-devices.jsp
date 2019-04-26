<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Mobile Devices</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>



<body>


<div class="jumbotron ">
  <div class="container">
    <h1 class="display-4">Mobile Database</h1>
    <p class="lead">You will find your mobile phone right here on this website, you do not have to look anywhere else !</p>
    <hr class="my-4">
    <p>Just add a new mobile phone into the database by clicking the button below.</p>
    <input type="button" value="Add Device" 
				   onclick="window.location.href='add-device-form.jsp'; return false;"
				   class="btn btn-primary btn-lg"
			/>
  </div>
</div>

	<div id="container">
	
		<div id="content">
			
			<table class = "table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Device Name</th>
					<th>Brand</th>
					<th>Technology</th>
					<th>GPRS</th>
					<th>Edge</th>
					<th>Action</th>
				</tr>
				
			</thead>
				<c:forEach var="tempDevice" items="${DEVICE_LIST}">
					
				
					<c:url var="tempLink" value="ControllerDB" >
						<c:param name="command" value="LOAD" />
						<c:param name="deviceId" value="${tempDevice.id}" />
					</c:url>

				
					<c:url var="deleteLink" value="ControllerDB">
						<c:param name="command" value="DELETE" />
						<c:param name="deviceId" value="${tempDevice.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempDevice.deviceName} </td>
						<td> ${tempDevice.brand} </td>
						<td> ${tempDevice.technology} </td>
						<td> ${tempDevice.gprs} </td>
						<td> ${tempDevice.edge} </td>
						<td> 
							<a href="${tempLink}" class="badge badge-success">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this device?'))) return false" class="badge badge-danger">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
	
	
	<div class="card">
  	<h5 class="card-header">More Information</h5>
  <div class="card-body">
    <h5 class="card-title">Web Database Application Development</h5>
    <p class="card-text">This project belongs to Chitral Puthran, Masters Student at University of New Haven, under the guidance of Prof. Tamara Luarasi.</p>
    <a href="https://www.newhaven.edu/" class="btn btn-primary">University Link</a>
  </div>
</div>
	
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>








