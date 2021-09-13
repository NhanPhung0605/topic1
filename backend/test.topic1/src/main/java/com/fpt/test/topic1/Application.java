package com.fpt.test.topic1;

import com.fpt.test.topic1.config.FileStorageProperties;
import com.fpt.test.topic1.entity.RoleEntity;
import com.fpt.test.topic1.entity.UserEntity;
import com.fpt.test.topic1.repository.RoleRepository;
import com.fpt.test.topic1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

@EnableConfigurationProperties(FileStorageProperties.class)
public class Application {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


//	@PostConstruct
//	protected void init() {
//
//		UserEntity userEntity = new UserEntity();
//		userEntity.setUsername("admin");
//		userEntity.setName("admin");
//		userEntity.setPassword(passwordEncoder.encode("123"));
//		userEntity.setEnable(true);
//
//		List<RoleEntity> roleEntities = new ArrayList<>();
//		roleEntities.add(createRoleEntity("ADMIN", "Admin role"));
//
//		userEntity.setAuthorities(roleEntities);
//
//		userRepository.save(userEntity);
//
//	}
//
//	private RoleEntity createRoleEntity(String roleCode, String roleName) {
//		RoleEntity roleEntity = new RoleEntity();
//		roleEntity.setRoleCode(roleCode);
//		roleEntity.setRoleName(roleName);
//
//		return roleEntity;
//	}
}
