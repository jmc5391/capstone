package com.fishbuddy.capstone.model.data.equipment;

import com.fishbuddy.capstone.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface TypeDao extends CrudRepository<Type, Integer> {
}
