<%@ page import="com.smma.service10.entities.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Edition</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>
<main>
    <header class="text-center pb-4">
        <h1>Product Update</h1>
    </header>
    <form action="updateProduct" method="post" class="container">
        <div class="form-group mb-2">
            <label for="nomProduct">Product Name:</label>
            <input type="text" class="form-control" id="nomProduct" name="nomProduct" value="${productJsp.nomProduct}">
        </div>
        <div class="form-group mb-2">
            <label for="prixProduct">Price:</label>
            <input type="text" class="form-control" id="prixProduct" name="prixProduct" value="${productJsp.prixProduct}">
        </div>
        <div class="form-group mb-2">
            <label for="categorieProduct">Category:</label>
            <select class="form-control" id="categorieProduct" name="categorieProduct">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.idCategorie}">${category.nomCategorie}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success w-100">Update</button>
    </form>
</main>
<footer class="text-center pt-4">
    <a href="productsList" class="btn btn-secondary">Products List</a>
</footer>
</body>
</html>
