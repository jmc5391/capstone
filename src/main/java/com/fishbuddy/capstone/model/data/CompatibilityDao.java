package com.fishbuddy.capstone.model.data;

import com.fishbuddy.capstone.model.Compatibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CompatibilityDao extends CrudRepository<Compatibility, Integer> {
}
