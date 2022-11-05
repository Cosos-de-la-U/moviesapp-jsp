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
                        <a href="<%=request.getContextPath()%>/usuarios/nuevoUsuarios">
                            Agregar <i class="fa-solid fa-plus"></i>
                        </a>
                    </button>
                    <table id="dataTable" class="table w-full text-sm text-left text-gray-500 dark:text-green-400">
                        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                        <tr>
                            <th scope="col" class="py-5 px-6">
                               Carnet
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Nombre
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Apellido
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Tipo
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Tel. Casa
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Celular
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Email
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Estado
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Clave
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Acceso
                            </th>
                            <th scope="col" class="py-5 px-6">
                                Tipo
                            </th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="usuarios" items="${listaUsuarios}">
                            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getCarnet()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getNom_usuario()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getApe_usuario()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getTipo()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getTelcasa()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getCelular()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getEmail()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getEstado()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getClave()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getAcessosistemas()}"/>
                                </td>
                                <td class="py-5 px-20">
                                    <c:out value="${usuarios.getEsadministrador()}"/>
                                </td>
                                <td class="py-5 px-6">
                                    <a href="borrarUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />">
                                        <i class="fa-solid fa-trash" style="color: red"></i>
                                    </a>
                                </td>
                                <td class="py-5 px-6">
                                    <a href="editarUsuarios?carnet=<c:out value='${usuarios.getCarnet()}' />">
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