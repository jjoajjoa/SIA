<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form id="myform" action="selecttest.jsp">
      <input type="hidden" id="deptId" value="">
      <select id="selectDeptId" name="selectDeptId">
         <option value="10">10</option>
         <option value="20">20</option>
         <option value="30">30</option>
      </select>
         
   </form>
   <h3>Emp List</h3>
   <p><%= request.getParameter("selectDeptId") %></p>
   <%
      String deptIdStr = request.getParameter("selectDeptId");
      if(deptIdStr != null && deptIdStr.length() > 0) {
         
      }
   %>
   <script>
      let deptId = document.querySelector("#selectDeptId");
      deptId.addEventListener("change", function(){
         let deptIdSelect = document.querySelector("#selectDeptId");
         //alert(deptId.value);
         let deptId = document.querySelector("#deptId");
         deptId.value = deptIdSelect.value;
         //alert(deptId.value);
         document.querySelector('#myform').submit();
      });
   </script>
</body>
</html>