package kg.build.flat_service.repository.account.specification;

import kg.build.flat_service.dto.account.UserFilter;
import kg.build.flat_service.entity.account.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> build(UserFilter filter) {
        return Specification
                .where(likeUsername(filter.getUsername()));
    }

    private static Specification<User> likeUsername(String username) {
        return (root, query, cb) -> {
            if (username == null || username.isBlank()) return null;
            return cb.like(cb.lower(root.get("username")),
                    "%" + username.toLowerCase() + "%");
        };
    }

}
