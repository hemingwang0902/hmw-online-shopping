<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">
<beans>
	<bean id="${beanname}Dao" class="com.${sysName}.${packageName}.dao.${className}Dao" parent="daoSupport"></bean>
	
	<bean id="${beanname}Service" class="com.${sysName}.${packageName}.service.${className}Service" parent="serviceSupport">
		<property name="${beanname}Dao">
			<ref local="${beanname}Dao" />
		</property>
	</bean>
</beans>