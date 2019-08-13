package com.fishbuddy.capstone.model.data;

import com.fishbuddy.capstone.model.Fish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FishDao extends CrudRepository<Fish, Integer> {
}
