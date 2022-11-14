<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../Common/Shared/Merge/sharedBeginning.jsp" %>
<!--Web start-->
<!-- Did get the path-->
<c:if test="${categoria != null}">
    <form action="actualizarCategoria" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
</c:if>
<!--Didn't get the path-->
<c:if test="${categoria == null}">
    <form action="insertarCategoria" method="post"
    class="bg-white shadow-md rounded mt-4 px-8 pt-6 pb-8 mb-4">
</c:if>
<h2>
    <!-- Didn't get the path-->
    <c:if test="${categoria != null}">
        Editar Categoria
    </c:if>
    <!-- Didn get the path-->
    <c:if test="${categoria == null}">
        Agregar Categoria
    </c:if>
</h2>

<div class="mb-4">
    <c:if test="${categoria != null}">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="idcategoria" hidden>
        </label>
        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
               name="idcategoria"
               value="<c:out value='${categoria.getIdcategoria()}' />"
               type="text" placeholder="ID" hidden>
    </c:if>
</div>
<div class="mb-4">
    <label class="block text-gray-700 text-sm font-bold mb-2" for="categoria">
        Categoria
    </label>
    <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
           name="categoria"
           value="<c:out value='${categoria.getCategoria()}' />"
           type="text" placeholder="" required="required">
</div>
<div class="flex items-center justify-between">
    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            type="submit">
        Guardar
    </button>
</div>
</form>
<!--Web end-->
<%@ include file="../../Common/Shared/Merge/sharedEnd.jsp" %>