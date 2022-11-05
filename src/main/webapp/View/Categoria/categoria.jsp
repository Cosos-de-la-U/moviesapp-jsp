<%@ include file="../../Common/head.jspf" %>
<c:choose>
    <c:when test="${!empty sessionScope['usuarioSession']  && sessionScope['usuarioSession'].getEsadministrador() == '1'}">
        <body class="bg-gray-100 font-family-karla flex">
        <%@ include file="../../Common/navigation.jspf" %>
        <div class="w-full flex flex-col h-screen overflow-y-hidden">
            <%@ include file="../../Common/header.jspf" %>
            <div class="w-full mt-4 flex justify-center items-center">
                <div class="overflow-x-auto relative">
                    <button class="bg-blue-500 p-1 mb-2 items-center rounded text-white">
                        <a href="<%=request.getContextPath()%>/categoria/nuevaCategoria">
                            Agregar <i class="fa-solid fa-plus"></i>
                        </a>
                    </button>
                    <table id="dataTable" class="table w-full text-sm text-left text-gray-500 dark:text-green-400">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" class="py-5 px-6">
                                Categoria
                            </th>
                            <th scope="col" class="py-5 px-6">
                            </th>
                            <th>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="categoria" items="${listaCategoria}">
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="py-5 px-20">
                                    <c:out value="${categoria.getCategoria()}"/>
                                </td>
                                <td class="py-5 px-6">
                                    <a href="borrarCategoria?idcategoria=<c:out value='${categoria.getIdcategoria()}' />">
                                        <i class="fa-solid fa-trash" style="color: red"></i>
                                    </a>
                                </td>
                                <td class="py-5 px-6">
                                    <a href="editarCategoria?idcategoria=<c:out value='${categoria.getIdcategoria()}' />">
                                        <i class="fa-solid fa-file-pen" style="color: #F7BD02"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <script>
                $(document).ready(function () {
                    $('#dataTable').DataTable();
                });
            </script>
        </div>
        </body>
        <html/>
    </c:when>
    <c:otherwise>
        <c:redirect url="/index.jsp"/>
    </c:otherwise>
</c:choose>