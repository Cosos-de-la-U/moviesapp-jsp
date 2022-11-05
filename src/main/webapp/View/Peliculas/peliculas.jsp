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
                        <a href="<%=request.getContextPath()%>/peliculas/nuevaPeliculas">
                            Agregar <i class="fa-solid fa-plus"></i>
                        </a>
                    </button>
                    <table id="dataTable" class="table w-full text-sm text-left text-gray-500 dark:text-green-400">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" class="py-5 px-6">
                                Nombre
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Nombre inglés
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Peliulas
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Peliculas
                            </th>
                            <th scope="col" class="py-5 px-6">
                            </th>
                            <th scope="col" class="py-5 px-6">
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="peliculas" items="${listaPeliculas}">
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="py-5 px-20">
                                    <c:out value="${peliculas.getPeliculas()}"/>
                                </td>
                                <td class="py-5 px-6">
                                    <a href="borrarPeliculas?idpeliculas=<c:out value='${peliculas.getIdpeliculas()}' />">
                                        <i class="fa-solid fa-trash" style="color: red"></i>
                                    </a>
                                </td>
                                <td class="py-5 px-6">
                                    <a href="editarPeliculas?idpeliculas=<c:out value='${peliculas.getIdpeliculas()}' />">
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