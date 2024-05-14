<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Products List</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <header class="text-center py-4">
        <h1>Categories List</h1>
    </header>
    <main>
        <table class="table table-secondary table-striped">
            <tr>
                <th>Category Id</th>
                <th>Category Name</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${categoriesJsp}" var="categorie">
                <tr>
                    <td>${categorie.idCategorie}</td>
                    <td>${categorie.nomCategorie}</td>
                    <td>
                        <a onclick="return confirm('Are you sure to delete this item ?')"
                           href="deleteCategorie?id=${categorie.idCategorie}"
                           class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </main>
    <footer class="text-center py-4">
        <a href="createCategorie" class="btn btn-success btn-lg">Add categorie</a>
    </footer>
</div>
</body>
</html>
