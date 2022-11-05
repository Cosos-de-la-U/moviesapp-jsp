<%@ include file="../../Common/head.jspf" %>
<c:choose>
    <c:when test="${!empty sessionScope['usuarioSession']  && sessionScope['usuarioSession'].getEsadministrador() == '1'}">
        <body class="bg-gray-100 font-family-karla flex">
        <%@ include file="../../Common/navigation.jspf" %>
        <div class="w-full flex flex-col h-screen overflow-y-hidden">
            <%@ include file="../../Common/header.jspf" %>
            <!--Starts-->
            <!--End-->
        </div>
        </body>
    </c:when>
    <c:otherwise>
        <c:redirect url="/index.jsp"/>
    </c:otherwise>
</c:choose>