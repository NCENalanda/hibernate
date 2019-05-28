<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
  <c:when test="${!empty reportData }">
    <table border="1">
       <tr><th>pid</th><th>pname</th><th>price</th><th>qty</th></tr>
    <c:forEach var="dto" items="${reportData}">
       <tr>
          <td>${dto.pid} </td>
          <td>${dto.pname} </td>
          <td>${dto.price} </td>
          <td>${dto.qty} </td>
       </tr>
    </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
     <h1 style="color:red;text-align:center">No Data found </h1>
  </c:otherwise>
</c:choose>
<br><br><br>
 <c:if test="${!empty pageCount}">
   <c:forEach var="i" begin="1" end="${pageCount}" step="1">
      <a href="controller?pageNo=${i}">[${i}]</a> &nbsp;&nbsp;&nbsp;&nbsp; 
   </c:forEach>
 </c:if>
