package com.bonsai.admin.state;

import com.bonsai.common.entity.Country;
import com.bonsai.common.entity.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Integer> {
	
	public List<State> findByCountryOrderByNameAsc(Country country);
}