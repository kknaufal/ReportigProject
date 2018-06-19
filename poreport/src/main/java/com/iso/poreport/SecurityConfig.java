package com.iso.poreport;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${ldap.url}")
	private String ldapUrl;

	@Value("${ldap.domain}")
	private String ldapDomain;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login**").permitAll().antMatchers("/profile/**").fullyAuthenticated()
				.antMatchers("/").fullyAuthenticated()// .permitAll()
				.and().formLogin().loginPage("/login").successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse resp,
							Authentication arg2) throws IOException, ServletException {

						// LDAPAuthentication ldap = new LDAPAuthentication();
						// LDAPAuthentication.LDAP ldapObj = new LDAP();
						// Attributes att = ldapObj.authenticateUser();

						System.out.println(arg0.getLocalName());
						System.out.println(resp.getHeaderNames());
						resp.sendRedirect("/");
					}
				})
				/*.failureHandler(new AuthenticationFailureHandler() {
					@Override
					public void onAuthenticationFailure(HttpServletRequest arg0, HttpServletResponse resp,
							org.springframework.security.core.AuthenticationException arg2)
							throws IOException, ServletException { 
						ModelAndView model = new ModelAndView();
						model.addObject("error", "invalid credentials");
						System.out.println(arg2.getMessage());
						resp.sendRedirect("/login?error");
					}
				})*/
				.failureUrl("/login-error.html").permitAll().and()
				.logout().logoutSuccessUrl("/login?logout")
				.logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(activeDirectoryLdapAuthenticationProvider())
				.userDetailsService(userDetailsService());
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
	}

	@Bean
	public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
		ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(ldapDomain,
				ldapUrl);
		provider.setConvertSubErrorCodesToExceptions(true);
		provider.setUseAuthenticationRequestCredentials(true);
		provider.setSearchFilter("(&(objectClass=user)(|(userPrincipalName={0})(sAMAccountName={1})))");
		return provider;
	}

}
