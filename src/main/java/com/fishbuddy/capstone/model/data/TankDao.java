package com.fishbuddy.capstone.model.data;

import com.fishbuddy.capstone.model.Tank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TankDao extends CrudRepository<Tank, Integer> {
}
