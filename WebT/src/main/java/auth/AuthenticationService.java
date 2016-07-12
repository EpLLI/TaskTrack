package auth;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.z.pojos.User;
import test.z.service.ILoginService;
import test.z.serviceException.ServiceException;

@Service("authService")
public class AuthenticationService implements UserDetailsService {
	final Logger log = Logger.getLogger(AuthenticationService.class);
	@Autowired
	private ILoginService loginService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = loginService.findByUserName(username);
		} catch (ServiceException e) {

			log.error(e);
		}
		System.out.println("User : " + user);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
	}

}
