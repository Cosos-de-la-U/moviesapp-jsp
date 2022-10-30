<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="Common/header.jspf" %>

<body class="flex flex-col items-center justify-center w-screen h-screen bg-gray-200 text-gray-700">
<!-- Verificando si la sesion existe y que tipo de usuario es para redirigirla a la pagina correcta-->
<%--    <c:choose>--%>
<%--        <c:when test="${empty sessionScope['para']}">--%>
<%--            <c:redirect url="login.jsp" />--%>
<%--        </c:when>--%>
<%--        <c:when test="${!empty sessionScope['para'] && sessionScope['type_session']=='1'}">--%>
<%--            <c:redirect url="employee.jsp" />--%>
<%--        </c:when>--%>
<%--    </c:choose>--%>

<h1 class="font-bold text-2xl">Movie App <i class="fa-solid fa-clapperboard"></i></h1>
<form class="flex flex-col bg-white rounded shadow-lg p-12 mt-12" action="login" method="post">
    <label class="font-semibold text-xs" for="carnet">Carnet</label>
    <input class="flex items-center h-12 px-4 w-64 bg-gray-200 mt-2 rounded focus:outline-none focus:ring-2"
           name="carnet"
           type="text">
    <label class="font-semibold text-xs mt-3" for="clave">Clave</label>
    <input class="flex items-center h-12 px-4 w-64 bg-gray-200 mt-2 rounded focus:outline-none focus:ring-2"
           name="clave"
           type="password">
    <button class="flex items-center justify-center h-12 px-6 w-64 bg-blue-600 mt-8 rounded font-semibold text-sm text-blue-100 hover:bg-blue-700">
        Iniciar sesión
    </button>
    <div class="flex mt-6 justify-center text-xs">
        <a class="text-blue-400 hover:text-blue-500" href="View/register.jsp">Registrarse</a>
    </div>
</form>


</body>