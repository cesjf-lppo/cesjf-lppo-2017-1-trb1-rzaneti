<%-- 
    Document   : lista-ordenada
    Created on : 07/04/2017, 19:01:58
    Author     : RafaelaEmília
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Equipamentos</title>
    </head>
    <body>
        <h1>Listagem de Equipamentos Por Estado</h1>
        
        
            <div id="pagina">
                <div id="barra-menus">
                    <a href="lista.html">Listar registros</a>
                    <a href="lista2.html">Listagem por Estado</a>
                    <a href="novo.html">Novo Equipamento</a>
                </div><br>
                <div id="conteudo">
                    
                    <form method="post">
                        <select name="pesquisa-estado">
                            <option value="0">Novo</option>
                            <option value="1">Em Uso</option>
                            <option value="2">Danificado</option>
                            <option value="3">Perdido</option>
                        </select>
                        <button type="submit">Pesquisar</button>
                    </form>
                   
                    <br />
                    <table border="1">
                            <tr>
                                <th>Editar:</th>
                                <th>Série:</th>
                                <th>Local:</th>
                                <th>Descrição:</th>
                                <th>Estado:</th>
                                
                            </tr>
                            <c:forEach var="equipamento" items="${equipamentos}">
                                <tr>
                                    <td align="center"><a href="edita.html?id=${equipamento.id}">${equipamento.id}</a></td>
                                    <td>${equipamento.serie}</td>
                                    <td>${equipamento.local}</td>
                                    <td>${equipamento.descricao}</td>
                                    <c:if test="${equipamento.estado==0}">
                                        <td>Novo</td>
                                    </c:if>
                                    <c:if test="${equipamento.estado==1}">
                                        <td>Em Uso</td>
                                    </c:if>
                                    <c:if test="${equipamento.estado==2}">
                                        <td>Danificado</td>
                                    </c:if>
                                    <c:if test="${equipamento.estado==3}">
                                        <td>Perdido</td>
                                    </c:if>
                                    
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                    <br /><br />
                    
                </div>
                
            </div>
      
        
        
        
    </body>
</html>
