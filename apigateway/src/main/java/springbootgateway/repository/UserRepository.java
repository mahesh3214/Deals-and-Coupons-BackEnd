package springbootgateway.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import springbootgateway.models.User;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	boolean existsByName(String name);
}
