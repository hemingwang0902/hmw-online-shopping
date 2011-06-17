<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
	
<hibernate-mapping>
	<class entity-name="${tableName}" table="${tableName}" lazy="false">
		<comment></comment>
		<id name="ID" column="ID" type="long">
			<!-- <generator class="identity" /> -->
			<generator class="sequence">
				<param name="sequence">SEQ_${tableName}</param>
			</generator>
		</id>
	<#list lis as being>
		<property name="${being.oldCl}" type="${being.datatype}">
			<column name="${being.oldCl}" length="${being.len}" >
				<comment></comment>
			</column>
		</property>
	</#list>
	</class>
</hibernate-mapping>