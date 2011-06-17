<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">
<struts>
	<package name="${packageName}" extends="json-default" namespace="/${sysName}/${packageName}">
		<action name="${packageName}List" class="com.${sysName}.${packageName}.action.${className}List">
			<result name="jsonsuccess" type="json">
		      <param name="root">result</param>
		    </result>
		</action>
		<action name="${packageName}Turn" class="com.${sysName}.${packageName}.action.${className}Turn">
			<result name="success" type="dispatcher">${packageName}form.jsp</result>
		</action>
		<action name="${packageName}Save" class="com.${sysName}.${packageName}.action.${className}Save">
			<result name="error"  type="dispatcher" >${packageName}form.jsp</result>
			<result name="success" type="redirect" >${packageName}list.jsp</result>
			<result name="update" type="dispatcher" >${packageName}form.jsp</result>
			<result name="invalid.token" type="freemarker">${packageName}form.jsp</result> 
			<interceptor-ref name="defaultStack"><param name="workflow.excludeMethods">default</param></interceptor-ref> 
			<interceptor-ref name="tokenSession"><param name="excludeMethods">default</param></interceptor-ref>
		</action>
		<action name="${packageName}Del" class="com.${sysName}.${packageName}.action.${className}Del">
			<result name="jsonsuccess" type="json">
		      <param name="root">result</param>
		    </result>
		</action>
		<action name="get${className}" class="com.${sysName}.${packageName}.action.Get${className}">
			<result name="success" type="dispatcher" >${packageName}form.jsp</result>
		</action>
		<action name="check${className}" class="com.${sysName}.${packageName}.action.Check${className}">
			<result name="jsonsuccess" type="json">
		      <param name="root">result</param>
		    </result>
		</action>
	</package>
</struts>