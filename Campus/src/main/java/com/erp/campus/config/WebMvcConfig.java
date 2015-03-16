package com.erp.campus.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@ComponentScan("com.erp.campus")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	/*@Autowired
	private SpringTemplateEngine engine;*/

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println(" \n\n -- CONFIGURATIOn START -- \n \n");
		configurer.enable();
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("\n WebMvcConfig.addResourceHandlers");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	 @Bean
	  	public ViewResolver viewResolver() {
			System.out.println(" \n viewResolver() \n");
		    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		    templateResolver.setTemplateMode("XHTML");
		    templateResolver.setPrefix("/views/");
		    templateResolver.setSuffix(".html");
		    SpringTemplateEngine engine = new SpringTemplateEngine();
		    engine.setTemplateResolver(templateResolver);		
			engine.addDialect(new LayoutDialect());
		    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		    viewResolver.setTemplateEngine(engine);
	    	return viewResolver;
	  }
	 
/*	 @Bean
		public TilesConfigurer tilesConfigurer() {
			System.out.println("\n\n tilesConfigurer \n\n");
			TilesConfigurer tilesConfigurer = new TilesConfigurer();			
			tilesConfigurer.setDefinitions(new String[] {			
			"/views/views.xml" 
			});
			tilesConfigurer.setCheckRefresh(true);			
			return tilesConfigurer;
		}
		*/

	/*@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(ServletContextTemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new TilesDialect());
		return templateEngine;
	}

	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
//		viewResolver.setViewClass(ThymeleafTilesView.class);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new ThymeleafTilesConfigurer();
		configurer.setDefinitions(new String[] {
				"file:/templates/layout/views.xml",
				 });
		configurer.setCheckRefresh(true);
		return configurer;
	}*/

	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry)
	 * { registry.addViewController("/").setViewName("index"); }
	 */

	// TILES CONFIGURATION

	/*
	 * @Bean public ViewResolver viewResolver() {
	 * System.out.println(" \n viewResolver() \n"); ClassLoaderTemplateResolver
	 * templateResolver = new ClassLoaderTemplateResolver();
	 * templateResolver.setTemplateMode("XHTML");
	 * templateResolver.setPrefix("/views/");
	 * templateResolver.setSuffix(".html"); // SpringTemplateEngine engine = new
	 * SpringTemplateEngine(); engine.setTemplateResolver(templateResolver);
	 * //engine.addDialect(new LayoutDialect()); ThymeleafViewResolver
	 * viewResolver = new ThymeleafViewResolver();
	 * viewResolver.setTemplateEngine(engine); return viewResolver; }
	 */

	/*
	 * @Bean public TilesConfigurer tilesConfigurer() {
	 * System.out.println("\n\n Tiles Configurer \n\n"); TilesConfigurer
	 * tilesConfigurer = new TilesConfigurer(); tilesConfigurer
	 * .setDefinitions(new String[] { "file:/views/views.xml" });
	 * tilesConfigurer.setCheckRefresh(true); return tilesConfigurer; }
	 */

	// BACK UP

	/*
	 * @Bean public ThymeleafTilesConfigurer tilesConfigurer() {
	 * System.out.println("\n \n ThymeleafTilesConfigurer"); final
	 * ThymeleafTilesConfigurer configurer = new ThymeleafTilesConfigurer();
	 * configurer.setDefinitions("file:/templates/layout/views.xml"); return
	 * configurer; }
	 * 
	 * @Bean public ThymeleafViewResolver thymeleafViewResolver() { final
	 * ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	 * resolver.setTemplateEngine(engine); return resolver; }
	 * 
	 * @Bean public TilesDialect tilesDialect() { return new TilesDialect(); }
	 */
}
