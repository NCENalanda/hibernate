<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<c:choose>
  <c:when test="${!empty listStudsDTO}">
    <c:forEach var="dto"  items="${listStudsDTO}">
      <h1 style="color:blue">${dto.sid} &nbsp;&nbsp;&nbsp; ${dto.name} &nbsp;&nbsp;&nbsp; ${dto.address} &nbsp;&nbsp; <a style="font-size:14px;" href="controller?sid=${dto.sid}&operation=link2">Delete Student with LibraryMembership</a> </h1>
      <h4 style="color:red">${dto.libraryDetails.lid } &nbsp;&nbsp;&nbsp; ${dto.libraryDetails.doj}&nbsp;&nbsp;&nbsp; <a href="controller?lid=${dto.libraryDetails.lid}&operation=link3">Delete Only LibraryMembership</a> </h4>
    </c:forEach>
  </c:when>
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>

  <h1 style="color:green">${studWithLibRemovalMsg}</h1>
  <h1 style="color:green">${insertMsg}</h1>
  <br>
  <h1><a href="form.html">Register Student and Library Membership</a> </h1>
      
    
    
    
