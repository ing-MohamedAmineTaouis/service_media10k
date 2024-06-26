<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <Link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <title>New Category</title>
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card w-50">
        <div class="card-header bg-danger">
            <h3 class="card-title text-center text-white fw-bold">Create new category</h3>
        </div>
        <div class="card-body">
            <form action="saveCategorie" method="post">
                <div class="mb-3">
                    <label for="nomCategorie" class="form-label">Category Name:</label>
                    <input type="text" id="nomCategorie" name="nomCategorie" class="form-control">
                </div>
                <div class="text-center">
                    <input type="submit" value="Save" class="btn btn-lg btn-success">
                </div>
            </form>
            <div class="text-center mt-3">
                ${messageJsp}
            </div>
        </div>
        <div class="card-footer text-center">
            <a href="categoriesList" class="btn btn-secondary">Back to Categories List</a>
        </div>
    </div>
</div>
</body>
</html>
