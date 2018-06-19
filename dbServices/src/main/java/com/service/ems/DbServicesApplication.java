package com.service.ems;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.service.ems.configurations.SpringSecurityAuditorAware;
import com.service.ems.domain.User;
import com.service.ems.services.UserService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.service.ems.repositories")
@EnableJpaAuditing
@RestController
public class DbServicesApplication {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    ConsumerTokenServices tokenServices;

	public static void main(String[] args) {
		SpringApplication.run(DbServicesApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new SpringSecurityAuditorAware();
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}
	
	@PostMapping("/post")
	public String homePost() {
		return "Hello World";
	}
	
	/**
	 * Create a default user with credential user/password with role 'USER'
	 * 
	 * @return
	 */
	@GetMapping(value="/addUser")
	public User userRegistration(){
		User user = new User();
		user.setLastName("Demo");
		user.setName("User");
		user.setActive(1);
		user.setEmail("user");
		user.setPassword("password");
		userService.saveUser(user,"USER");
		return user;
	}
	
	/**
	 * Create a default user with credential admin/password with role 'ADMIN'
	 * 
	 * @return
	 */
	@GetMapping(value="/addAdmin")
	public User adminRegistration(){
		User user = new User();
		user.setLastName("Demo");
		user.setName("Admin");
		user.setActive(1);
		user.setEmail("admin");
		user.setPassword("password");
		userService.saveUser(user,"ADMIN");
		return user;
	}
	
	/**
	 *  CORS filter
	 * @return
	 */
	 @Bean
	    public FilterRegistrationBean myCorsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod("*");
	        source.registerCorsConfiguration("/**", config);
	        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	        return bean;
	    }
    
	 
	/**
	 *  To Invalidate the user token this should be called for user logout from front end
	 * @param request
	 */
    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/revokeToken")
    @ResponseBody
    public void revokeToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")){
            String tokenId = authorization.substring("Bearer".length()+1);
            tokenServices.revokeToken(tokenId);
        }
      
    }    
 
	@Configuration
	@EnableResourceServer
	protected static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.cors().and()
			.authorizeRequests().antMatchers("/**").permitAll();
            /*.authorizeRequests().antMatchers("/addUser").permitAll().and()
            .authorizeRequests().antMatchers("/addAdmin").permitAll().and()
            .authorizeRequests().antMatchers("/db/**").hasAuthority("USER").and()
            .authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN").and()
			.authorizeRequests().antMatchers("/").access("#oauth2.hasScope('read')");*/
		}

		@Override
		public void configure(ResourceServerSecurityConfigurer resources)
				throws Exception {
			resources.resourceId("EMS");
		}
	}
	

	@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints)
				throws Exception {
			endpoints.authenticationManager(authenticationManager);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
			clients.inMemory()
			.withClient("my-client-with-secret")
			.authorizedGrantTypes("password","client_credentials")
			.authorities("ROLE_CLIENT").scopes("read").resourceIds("EMS")
			.secret("secret")
			.accessTokenValiditySeconds(0);
		}

	}
}
