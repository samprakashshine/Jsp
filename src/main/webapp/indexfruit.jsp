<c:forEach items="${fruitList}" var="currentFruit">
    <tr>      
       <td> 
        <c:out value="${currentFruit.name}" />        
       </td>       
        <c:forEach items="${currentFruit.price}" var="price">

            <td>
                ${price}
            </td>
        </c:forEach>       
    </tr>

</c:forEach>
${Hello}
<table>
  <c:forEach items="${fruitList}" var="f">
   <tr>
     <td>${f.name}</td>
     ....
   </tr>
  </c:forEach>
</table>
</table> <form action="fruitservlet" method="post"> 
    <input type="submit" value="fruitlist"/>
    </form>
