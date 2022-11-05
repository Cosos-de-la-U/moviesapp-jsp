<c:choose>
  <c:when test="${empty sessionScope['usuarioSession']}">
  </c:when>
  <c:when test="${!empty sessionScope['usuarioSession']  && sessionScope['usuarioSession'].getEsadministrador() == '1'}">
    <c:redirect url="/Admin"/>
  </c:when>
  <c:when test="${!empty sessionScope['usuarioSession']  && sessionScope['usuarioSession'].getEsadministrador() == '0'}">
    <c:redirect url="/User"/>
  </c:when>
</c:choose>