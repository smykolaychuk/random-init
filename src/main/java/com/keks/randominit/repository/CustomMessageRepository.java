package com.keks.randominit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keks.randominit.model.CustomMessage;

/**
 * @author smykola
 */
@Repository
public interface CustomMessageRepository extends CrudRepository<CustomMessage, Long> {

}
