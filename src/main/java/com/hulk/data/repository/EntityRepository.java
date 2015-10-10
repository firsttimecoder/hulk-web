package com.hulk.data.repository;

import com.hulk.data.model.Entity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vijayvar on 10/10/15.
 */
public interface EntityRepository extends CrudRepository<Entity, Long> {

}
