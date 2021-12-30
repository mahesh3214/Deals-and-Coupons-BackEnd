package springbootgateway.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import springbootgateway.models.ERole;
import springbootgateway.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
