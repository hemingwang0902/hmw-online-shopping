<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">
<struts>
	<package name="${packageName}" extends="json-default" namespace="/${packageName}">
		<action name="get${className}List" class="com.${sysName}.${packageName}.action.Get${className}List">
			<result name="jsonsuccess" type="json">
		      <param name="root">result</param>
		    </result>
		</action>
		<action name="init${className}Form" class="com.${sysName}.${packageName}.action.Init${className}Form">
			<result name="success" type="dispatcher">${packageName}form.jsp</result>
		</action>
		<action name="save${className}" class="com.${sysName}.${packageName}.action.Save${className}">
			<result name="error"  type="dispatcher" >${packageName}form.jsp</result>
			<result name="success" type="redirect" >${packageName}list.jsp</result>
			<result name="update" type="dispatcher" >${packageName}form.jsp</result>
			<result name="invalid.token" type="freemarker">${packageName}form.jsp</result> 
			<interceptor-ref name="defaultStack"><param name="workflow.excludeMethods">default</param></interceptor-ref> 
			<interceptor-ref name="tokenSession"><param name="excludeMethods">default</param></interceptor-ref>
		</action>
		<action name="del${className}" class="com.${sysName}.${packageName}.action.Del${className}">
			<result name="jsonsuccess" type="json">
		      <param name="root">result</param>
		    </result>
		</action>
		<action name="get${className}ById" class="com.${sysName}.${packageName}.action.Get${className}ById">
			<result name="success" type="dispatcher" >${packageName}form.jsp</result>
		</action>
	</package>
</struts>