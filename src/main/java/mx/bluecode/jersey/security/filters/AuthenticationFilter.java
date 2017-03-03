package mx.bluecode.jersey.security.filters;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.core.util.Base64;


/**
 * 
 * @author Julio Cesar Bolaños Palacios
 * @since 03/03/2017
 * @version 1.0
 */

public class AuthenticationFilter implements Filter{
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
	private static final String AUTH_HEADER_NAME = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("Filter request.");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeaderValue = httpRequest.getHeader(AUTH_HEADER_NAME);
        if(authHeaderValue != null){
        	if(authHeaderValue.startsWith(AUTHENTICATION_SCHEME))
	        	log.debug("Authorization Header Value: {}", authHeaderValue);
				boolean authenticated = isUserAuthenticated(authHeaderValue);
			if(authenticated){
				log.debug("Authentication Success");
				chain.doFilter(request, response);
			}else{
				ResponseBuilder builder = null;
		        String message = "Custom message";
		        builder = Response.status(Response.Status.UNAUTHORIZED).entity(message);
		        throw new WebApplicationException(builder.build());
			}
        }
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param authorization
	 * @return
	 */
	private boolean isUserAuthenticated(String authorization){
        
		 //Get encoded username and password
        final String encodedUserPassword = authorization.replaceFirst(AUTHENTICATION_SCHEME + " ", "");
        
        //Decode username and password
        String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));

        //Split username and password tokens
        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        log.debug("user name: {}", username);
        log.debug("password: {}", password);
        
        //VALIDATE USER AND PASSWORD HERE
        if(username.equals("jcesar"))        
        	return true;
       
        return false;
    }

}
