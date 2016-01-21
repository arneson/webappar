<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="pageSection" class="partial-form">
    <form action="${pageContext.request.contextPath}/products/add" method="post" role="form" id="input">
        <fieldset>
            <legend>Product</legend>
            <div class="form-group">
                <label for="id" >Id</label>
                <input type="text" name="id" value="Generated" disabled class="form-control"/>
            </div>
            <div class="form-group">
                <label for="name">Name (string)</label>
                <input id="name" type="text" name="name" maxlength="12"
                       required class="form-control"/>
            </div>
            <div class="form-group">
                <label for="price">Price (double)</label>
                <input id="price" type="number" name="price" min="0" max="1000" 
                       required class="form-control"/>
            </div>
            <div class="btn-group-sm">             
                <button id="add" type="submit" class="btn btn-default">Add Product</button>
                <button type="reset" class="btn btn-default">Reset</button>
                <button onclick="window.history.back();" class="btn btn-default">Cancel</button>
            </div>
        </fieldset>
    </form> 
</section>
