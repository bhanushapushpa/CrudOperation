<!doctype html>
<%@page import="Entity.book"%>
<%@page import="java.util.List"%>
<%@page import="Connection.crudConnection"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Book Store</title>
</head>
<body>
	<%
	crudConnection connection = new crudConnection();
	List<book> books = connection.bookDetail();
	String status = (String) session.getAttribute("Done");
	Boolean deletedBook = (Boolean) session.getAttribute("deleted");
	%>


	<div class="container">
		<div class="row ">
			<div class="col-12 ">
				<!--Status check  -->
					<div
						class="container text-center fw-bolder fs-3 <%=status == "Updated Successfully" ? "successCheck" : "not_successCheck"%> ">
						<span><%=status == null ? "" : status%></span>
					</div>
				<div class="head text-center mt-4">
					<h2>Book Store</h2>
				</div>
				<table class="table table-hover mt-5">
					<a class="btn btn-primary" href="addBook.jsp">Add</a>
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">BookName</th>
							<th scope="col">BookImage</th>
							<th scope="col">AuthorName</th>
							<th scope="col">PublicationName</th>
							<th scope="col">Description</th>
							<th scope="col">BookPrice</th>
							<th scope="col"></th>
						</tr>
					</thead>

					<tbody>
						<%
						if (books != null) {
							for (book b : books) {
						%>
						<tr>
							<td><%=b.getId()%></td>
							<td><%=b.getBookName()%></td>
							<%-- <td><%=b.getBookImage()%></td> --%>
							<td><img src="./Img/<%=b.getBookImage()%>"
								class="card-img-top h-10" style="height: 40px; width: 40px"
								alt="..."></td>
							<td><%=b.getAuthorName()%></td>
							<td><%=b.getPublicationName()%></td>
							<td><%=b.getDescription()%></td>
							<td><%=b.getBookPrice()%></td>
							<td>
							<a class="btn btn-sm btn-success"href="updateBook.jsp?id=<%=b.getId()%>">Update book</a> 
							<a class="btn btn-sm btn-danger" href="deleteBook?id=<%=b.getId()%>">Cancel book</a></td>
						</tr>
						<%
						}
						}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


</body>
</html>