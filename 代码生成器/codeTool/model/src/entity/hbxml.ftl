<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
	
<hibernate-mapping>
	<class entity-name="${tableName}" table="${tableName}" lazy="false">
		<comment>${tabCon}</comment>
	<#list lis as being>
	<#if being.columnkey == "PRI">
		<id name="${being.oldCl}" column="${being.oldCl}" type="${being.datatype}" >
			<generator class="identity" />
		</id>
	<#else>
		<property name="${being.oldCl}" type="${being.datatype}">
			<#if being.len == "">
			<column name="${being.oldCl}"  >
				<comment>${being.content}</comment>
			</column>
			<#else>
			<column name="${being.oldCl}" length="${being.len}" >
				<comment>${being.content}</comment>
			</column>
			</#if>
		</property>
	</#if>
	</#list>
	</class>
</hibernate-mapping>