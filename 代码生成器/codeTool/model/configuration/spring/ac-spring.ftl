<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
	<bean id="${packageName}Dao" class="com.${sysName}.${packageName}.dao.${className}Dao" parent="daoSupport"></bean>
	
	<bean id="${packageName}Service" class="com.${sysName}.${packageName}.service.${className}Service" parent="serviceSupport">
		<property name="${packageName}Dao">
			<ref local="${packageName}Dao" />
		</property>
	</bean>
</beans>