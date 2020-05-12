package com.luchienlin.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.luchienlin.springboot.component.LoginHandlerIntercepter;
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
                // 防止重新導向
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            
            // 註冊攔截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
            	// 靜態資源：*.css, *.js
            	// SpringBoot已經做好了靜態資源映射
            	registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
            	.excludePathPatterns("/index.htnml","/","/user/login");
            }

        };
        return adapter;
    }

    public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
    	
    }


}