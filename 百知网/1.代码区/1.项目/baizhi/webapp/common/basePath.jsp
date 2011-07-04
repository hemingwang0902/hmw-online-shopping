<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
request.setAttribute("basePath", basePath);
request.setAttribute("imgBasePath", basePath + "/images");
request.setAttribute("cssBasePath", basePath + "/styles");
request.setAttribute("jsBasePath", basePath + "/javascripts");
%>