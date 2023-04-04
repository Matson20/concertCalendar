package hh.sof3as3.concertCalendar.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);
}
