package io.github.gitwillians.business.BusinessImpl;

import io.github.gitwillians.base.BaseBusinessImpl;
import io.github.gitwillians.business.UserBusiness;
import io.github.gitwillians.entity.User;
import io.github.gitwillians.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserBusinessImpl extends BaseBusinessImpl<User, String> implements UserBusiness {

    @Getter
	private final UserRepository repository;
}