<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//client가 전송한 파일을 저장한다.
	DiskFileUpload upload = new DiskFileUpload();
	List<FileItem> list = upload.parseRequest(request); //request는 내장객체, 인터페이스 httpServletRequest 타입 // list속에는 클라이언트정보가 들어있다.
	String dir = System.getProperty("user.dir"); //디폴트 저장 폴더
	System.out.println(dir);
	for (FileItem item : list) {
		if (item.isFormField()) {
			String fieldName = item.getFieldName();
			String value = item.getString("utf-8");
			System.out.printf("fileName=%s, value=%ss\n", fieldName, value);
		} else {
			//파일 저장하기
			String name = item.getName();
			String localDir = "C:/dev/jsp/workspace/test/src/main/webapp/image/";
			File file = new File(localDir + name);
			item.write(file);
			out.println("파일이 저장되었습니다.");
		}
	}
	%>

</body>
</html>