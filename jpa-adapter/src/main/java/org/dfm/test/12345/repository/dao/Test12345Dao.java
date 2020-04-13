package org.dfm.test.12345.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.dfm.test.12345.repository.entity.Test12345Entity;

@Repository
public interface Test12345Dao extends JpaRepository<Test12345Entity, Long> {

}
