package Bombeiros.Services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Bombeiros.Modelos.Bombeiro;
import Bombeiros.Repositorios.BombeiroRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private BombeiroRepository bombeiroRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
		
		Bombeiro bombeiroUser = bombeiroRepo.findByMatricula(matricula);
		
		if(bombeiroUser.getMatricula() != null) {
		
			return new User(matricula, bombeiroUser.getSenha(), true, true, true, true, this.getAuthorities(bombeiroUser));
		
		}else {
		
			throw new UsernameNotFoundException("Usuario não encontrado com a matricula: " + matricula);
		
		}
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Bombeiro bombeiro){
		
		java.util.List <GrantedAuthority> authorities = new ArrayList<>();

		if(bombeiro.getPerfilAcesso() == "ADMIN"){
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return authorities;
	}





}
