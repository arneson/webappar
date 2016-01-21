<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="pageSection" class="partial-form">

    <label for="id-input"></label>
    <input type="text" id="id-input" disabled value="${product.id}"/>
    <label for="name-input"></label>
    <input type="text" id="name-input" value="${product.name}"/>
    <label for="price-input"></label>
    <input type="text" id="price-input" value="${product.price}"/>
    <button>Save</button>
    <button onclick="window.history.back()">Cancel</button>
    
</section>

