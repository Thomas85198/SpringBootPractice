package com.luchienlin.springboot.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 將配置文件中每一個屬性的值，映射到這個組件中
 * @ConfigurationProperties：告訴SpringBoot將本類中的所有屬性和配置文件中相關的配置進行綁定
 * 		prefix = "person"：配置文件中下面的所有屬性進行一一映射
 * 
 * 只有這個組件示容器中的組件，才能容器提供的@ConfigurationProperties功能
 * @ConfigurationProperties(prefix = "person")默認從全局配置文件中獲取值：
 * 
 */
//@PropertySource(value= {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

	/**
	 * <bean class="Person">
	 * 		<property name="lastName" value="字面量${key}從環境變量、配置文件中獲取值/#{SpEL}"></property>
	 * </bean>
	 */
	//@Value("${person.last-name}")
	//lastName必須是電子郵件
//	@Email
	private String lastName;
	
	//@Value("#{11*2}")
	private Integer age;
	
	private Boolean boss;
	private Date birth;
	
//	@Value("${person.maps}")
	private Map<String, Object> maps;
	private List<Object> lists;
	private Dog dog;
	
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", maps="
				+ maps + ", lists=" + lists + ", dog=" + dog + "]";
	}

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
	
	
	
	
}
 