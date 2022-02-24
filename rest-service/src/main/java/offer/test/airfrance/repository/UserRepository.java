package offer.test.airfrance.repository;

import org.springframework.stereotype.Repository;

import offer.test.airfrance.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByUserName(String userName);
}
