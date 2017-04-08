<%-- 
    Document   : lista-equipamentos
    Created on : 03/04/2017, 20:07:34
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
        <h1>Listagem de Equipamentos Por Local</h1>
        
        
        <table border="1">
            
            <tr>
                <th>ID</th>
                <th>Serie</th>
                <th>Local</th>
                <th>Descrição</th>
                <th>Estado</th>
            </tr>
            <c:forEach var="equipamento" items="${equipamentos}">
                <tr>
                 <td><a href="edita.html?id=${equipamento.id}"> ${equipamento.id} </a></td> 
                <td>${equipamento.serie}</td> 
                <td>${equipamento.local}</td> 
                <td>${equipamento.descricao}</td> 
                 <td>
                    <c:if test="${equipamento.estado==0}">
                        Novo
                    </c:if>
                    <c:if test="${equipamento.estado==1}">
                        Em uso
                    </c:if>
                     <c:if test="${equipamento.estado==2}">
                        Danificado
                    </c:if>
                    <c:if test="${equipamento.estado==3}">
                        Perdido
                    </c:if>
                    
                </td>
                    
                    
                </tr>
            </c:forEach>
               
                
           
           
        </table>
        
        
        
    </body>
</html>
