<%@ page import="com.smma.service10.entities.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Creation</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>
<header class="text-center py-4">
    <h1>Add Product</h1>
</header>
<main class="container">
    <form action="saveProduct" method="post" class="w-50 mx-auto">
        <div class="mb-3">
            <label for="nomProduct" class="form-label">Product Name :</label>
            <input type="text" id="nomProduct" name="nomProduct" class="form-control">
        </div>
        <div class="mb-3">
            <label for="prixProduct" class="form-label">Price :</label>
            <input type="text" id="prixProduct" name="prixProduct" class="form-control">
        </div>
        <div class="mb-3">
            <label for="categorieProduct" class="form-label">Category :</label>
            <select id="categorieProduct" name="categorieProduct" class="form-select">
                <%
                    List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
                    if(categories != null) {
                        for (Categorie category : categories) {
                %>
                <option value="<%= category.getIdCategorie() %>"><%= category.getNomCategorie() %></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <div class="text-center">
            <input type="submit" value="Save" class="btn btn-success btn-lg">
        </div>
    </form>
    <div class="text-center mt-3">
        ${messageJsp}
    </div>
</main>
<footer class="text-center py-4">
    <a href="productsList" class="btn btn-secondary">Product List</a>
</footer>
</body>
</html>
