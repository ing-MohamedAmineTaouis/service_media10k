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
        <h1>Products List</h1>
    </header>
    <main>
        <table class="table table-striped">
            <thead class="table-dark">
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Product Category</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productsJsp}" var="product">
                <tr>
                    <td>${product.idProduct}</td>
                    <td>${product.nomProduct}</td>
                    <td>${product.prixProduct}</td>
                    <td>${product.categorieProduct.nomCategorie}</td>
                    <td>
                        <a href="showProduct?id=${product.idProduct}"
                           class="btn btn-warning btn-sm">Edit</a>
                        <a onclick="return confirm('Are you sure to delete this item ?')"
                           href="deleteProduct?id=${product.idProduct}"
                           class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
    <footer class="text-center py-4">
        <a href="createProduct" class="btn btn-success btn-lg">Product Creation</a>
    </footer>
</div>
</body>
</html>
