package com.hifi.thattukada.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.web.thymeleaf.SpringSocialDialect;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//	private static final Map<String, Definition> tiles = new HashMap<String, Definition>();
//	private static final Attribute TEMPLATE = new Attribute("/WEB-INF/views/layout/layout.jsp");

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println(" \n\n -- CONFIGURATIOn START -- \n \n");
		configurer.enable();
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("\n WebMvcConfig.addResourceHandlers");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("index");
//		
//	}
/*	
	@Bean
	public UserDetailsPojo userDetailsPojo(){
		return new UserDetailsPojo();
	}
	*/
	
	 @Bean
  	public ViewResolver viewResolver() {
		System.out.println(" \n viewResolver() \n");
	    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	    templateResolver.setTemplateMode("XHTML");
	    templateResolver.setPrefix("/views/");
	    templateResolver.setSuffix(".html");
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.setTemplateResolver(templateResolver);
		engine.addDialect(new SpringSocialDialect());
		engine.addDialect(new LayoutDialect());
	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	    viewResolver.setTemplateEngine(engine);
    	return viewResolver;
  }
	 
	/*@Bean
	public TemplateResolver templateResolver() {
		System.out.println("\n WebMvcConfig.templateResolver");
		TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("/templates/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
	
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		System.out.println("\n WebMvcConfig.viewResolver");
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
		System.out.println("\n WebMvcConfig.templateEngine");
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new SpringSocialDialect());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}
	*/
	/*
	@Bean
	public UrlBasedViewResolver tilesViewResolver() {

		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);
		return tilesViewResolver;
	}

	@Bean
	public UserDetailsPojo userPojo() {
		UserDetailsPojo pojo = new UserDetailsPojo();
		return pojo;
	}
	
	 @Bean
	 public InternalResourceViewResolver viewResolver() {
	 System.out.println(" \n\n -- ADDING VIEW RESOLVER -- \n \n");
	 InternalResourceViewResolver resolver = new
	 InternalResourceViewResolver();
	 // resolver.setViewClass(TilesView.class);
	 resolver.setPrefix("/WEB-INF/jsp/");
	 resolver.setSuffix(".jsp");
	 return resolver;
	 }*/

	/*@Bean
	public TilesConfigurer tilesConfigurer() {
		System.out.println("\n\n tilesConfigurer \n\n");
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		// tilesConfigurer.setDefinitionsFactoryClass(JavaDefinitionsFactory.class);
		tilesConfigurer.setDefinitions(new String[] {
		// "file:src/main/webapp/WEB-INF/views/views.xml"
		"/WEB-INF/views/views.xml" });
		tilesConfigurer.setCheckRefresh(true);

		// addDefinition("tiles", "header", "/WEB-INF/views/layout/header.jsp");
		// addDefinition("signin", "Sign in", "/WEB-INF/views/signin.jsp");
		// addDefinition("signin/facebook", "Sign in",
		// "/WEB-INF/views/signin.jsp");

		return tilesConfigurer;
	}*/
	
/* USED FOR TESTING PURPOSE
 * 
	
	
	 @Bean
	 public UrlBasedViewResolver tilesViewResolver(){
	
	 UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
	 tilesViewResolver.setViewClass(TilesView.class);
	 // tilesViewResolver.setPrefix("/WEB-INF/jsp/");
	 // tilesViewResolver.setSuffix(".jsp");
	 return tilesViewResolver;
	 }
	
	 TILES CONFIGURATION BEGINS HERE Dated 11/01/2015 AD
	 reference :
	 http://forum.spring.io/forum/spring-projects/web/106256-programmatic-config-of-tiles-with-spring-3-1-annotations

	 @Bean
	 public TilesViewResolver tilesViewResolver() {
	 final TilesViewResolver resolver = new TilesViewResolver();
	 // resolver.setPrefix("/WEB-INF/jsp/");
	 // resolver.setSuffix(".jsp");
	 resolver.setViewClass(TilesView.class);
	 return resolver;
	 }

	 private void addDefinition(String name, String title, String body) {
	 System.out.println(" \n --ADDING DEFINITION TILES-- \n");
	 Map<String, Attribute> attributes = getDefaultAttributes();
	
	 attributes.put("title", new Attribute(title));
	 //attributes.put("body", new Attribute(body));
	
	 tiles.put(name, new Definition(name, TEMPLATE, attributes));
	 }
	
	 private Map<String, Attribute> getDefaultAttributes() {
	 System.out.println(" \n --ADDING DEFAULT DEFINITION TILES-- \n");
	 Map<String, Attribute> attributes = new HashMap<String,Attribute>();
	
	 //attributes.put("header", new
	 Attribute("/WEB-INF/views/layout/header.jsp"));
	 attributes.put("body", new Attribute("/WEB-INF/views/layout/body.jsp"));
	 attributes.put("footer", new
	 Attribute("/WEB-INF/views/layout/footer.jsp"));
	
	 return attributes;
	 }

	 public class JavaDefinitionsFactory extends
	 UnresolvingLocaleDefinitionsFactory {
	 public JavaDefinitionsFactory(){}
	
	 @Override
	 public Definition getDefinition(String name,TilesRequestContext
	 tilesContext) {
	 //
	 System.out.println("\n \n class JavaDefinitionsFactory getDefinition() method calling name...."+name
	 +" \n \n");
	 return tiles.get(name);
	 }
	 }
	 
	 */
}
