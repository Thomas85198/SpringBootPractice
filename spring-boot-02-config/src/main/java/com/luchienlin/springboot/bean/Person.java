package com.luchienlin.springboot.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 將配置文件中配置的每一個屬性的直，映射到這個組件中
 * @author Thomas Lu
 * @ConfigurationProperties:告訴SpringBoot將本類中所有屬性和配置文件中配置進行綁定
 * 	prefix = "person": 配置文件中哪個下面的所有屬性進行一一映射
 * 只有這個組件室容器中的組件，才能容器提供的@ConfigurationProperties功能
 */
@Component
//@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

	/**
	 * <bean class="Person">
	 * 	 <property name="lastName" value="字面量/${key}從環境變量、配置文件中獲取值/#{SpEL}"></property>
	 * </bean>
	 */
	@Email
	@Value("${person.last-name}")
	//lastName必須室郵件格式
	private String lastName;
	//@Value("#{11*2}")
	private Integer age;
	//@Value("true")
	private Boolean boss;
	private Date birth;

	// 2020-05-05 17:54:41.883  INFO 12792 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'@Value("${person.maps}")
	private Map<String, Object> maps;
	private List<Object> lists;
	private Dog dog;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getBoss() {
		return boss;
	}

	public void setBoss(Boolean boss) {
		this.boss = boss;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public List<Object> getLists() {
		return lists;
	}

	public void setLists(List<Object> lists) {
		this.lists = lists;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", maps="
				+ maps + ", lists=" + lists + ", dog=" + dog + "]";
	}

}
