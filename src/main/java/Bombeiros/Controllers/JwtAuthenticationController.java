package Bombeiros.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import Bombeiros.Modelos.JwtRequest;
import Bombeiros.Modelos.JwtResponse;
import Bombeiros.Security.JwtTokenUtil;
import Bombeiros.Services.JwtUserDetailsService;

import org.springframework.security.authentication.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailService;
	
    @RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authentRequest) throws Exception{

        authenticate(authentRequest.getMatricula(), authentRequest.getPassword());
        
        final UserDetails userDetails = userDetailService.loadUserByUsername(authentRequest.getMatricula());
        
        final String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponse(token));
    } 



    private void authenticate(String username, String password) throws Exception{
        try{
        	
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }catch (DisabledException e){
            throw new Exception("USER_DISABLE", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALIDD_CREDENTIALS", e);
        }
    }
	
}
