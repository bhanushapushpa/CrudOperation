<%@page import="Entity.book"%>
<%@page import="Connection.crudConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<%
String Id= request.getParameter("id");
crudConnection c = new crudConnection();
book b = c.bookReturn(Integer.parseInt(Id));
%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3 ">
				<form  action="updateBook?id=<%=Id%>" method="post" enctype="multipart/form-data">

					
					
					<div>
					<a class="btn btn-primary" href="index.jsp">Home</a>
					</div>

					<h2 class="text-center mt-4">Update Book</h2>

					<!-- Name -->
					<div class="mb-3">
						<label for="nameFormControlInput1" class="form-label">
							Book Name </label> <input type="text" name="BookName" 
							value="<%=b.getBookName()%>"
							class="form-control" id="nameFormControlInput1">
					</div>
					
					<!-- AuthorName -->
					<div class="mb-3">
						<label for="nameFormControlInput1" class="form-label">
							Author Name </label> <input type="text" name="AuthorName"
							value="<%=b.getAuthorName()%>"
							class="form-control" id="nameFormControlInput1">
					</div>
					
					<!-- PublicationName -->
					<div class="mb-3">
						<label for="nameFormControlInput1" class="form-label">
							Publication Name </label> <input type="text"
							value="<%=b.getPublicationName()%>"
							 name="PublicationName"
							class="form-control" id="nameFormControlInput1">
					</div>
					
					
					<!-- BookPrice -->
					<div class="mb-3">
						<label for="priceFormControlInput1" class="form-label">
							Price </label> <input type="text" 
							value="<%=b.getBookPrice() %>"
							name="BookPrice" class="form-control"
							id="priceFormControlInput1">
					</div>

					

					<!-- Image -->
					<div class="mb-3">
						<label for="formFile" class="form-label"> Image </label> <input
							class="form-control" type="file" name="foodImage"
							 value="<%=b.getBookImage() %>" id="formFile">
					</div>


					<!-- Description -->
					<div class="mb-3">
						<label for="foodFormControlTextarea1" class="form-label">Food
							Book Description</label>
						<textarea class="form-control" name="Description"
							id="foodFormControlTextarea1" rows="3"> <%=b.getDescription()%>
				</textarea>
					</div>

					<div class="d-grid gap-2 col-3 mx-auto">
						<button class="btn" style="background-color: #F47724;"
							type="submit">Update</button>
					</div>
				</form>


			</div>
		</div>

	</div>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>