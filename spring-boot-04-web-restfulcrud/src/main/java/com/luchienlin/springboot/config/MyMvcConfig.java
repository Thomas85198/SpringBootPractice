package com.luchienlin.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.luchienlin.springboot.component.MyLocaleResolver;

// 使用WebMvcConfigurerAdapter可以來擴展SpringMvc的功能
// @EnableWebMvc 不要接管SpringMvc
@Configuration
@SuppressWarnings("deprecation")
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// super.addViewControllers(registry);
		// 瀏覽器發送 /luchienlin 請求來到 success
		registry.addViewController("/luchienlin").setViewName("success");
	}
	

    //所有的WebMvcConfigurerAdapter组件都會一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
    	// 它是抽象類
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }

        };
        return adapter;
    }

    public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
    	
    }


}