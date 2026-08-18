package io.github.gitwillians.repository;

import io.github.gitwillians.base.BaseRepositoy;
import io.github.gitwillians.entity.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository extends BaseRepositoy<User, String>{
	
}