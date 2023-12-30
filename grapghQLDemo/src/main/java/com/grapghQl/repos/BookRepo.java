package com.grapghQl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grapghQl.entities.BookEntitiy;
@Repository
public interface BookRepo extends JpaRepository<BookEntitiy, Integer> {

}
