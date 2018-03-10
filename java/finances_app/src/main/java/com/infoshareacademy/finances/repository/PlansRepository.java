package com.infoshareacademy.finances.repository;

import com.infoshareacademy.finances.entity.PlanActionType;
import com.infoshareacademy.finances.entity.PlanCreationDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.util.List;

@Stateless
public class PlansRepository {

	@PersistenceContext
	EntityManager em;

	public List<PlanCreationDto> findAllPlans(Long userId) {
	return em.createQuery("select p from PlanCreationDto p join p.userInfoEntity u where u.id = :Id", PlanCreationDto.class)
			.setParameter("Id", userId).getResultList();
	}

	public List<PlanCreationDto> findAllPlans(Long userId, String sort) {
		return em.createQuery("select p from PlanCreationDto p join p.userInfoEntity u where u.id = :Id AND p.planActionType = :Sort",  PlanCreationDto.class)
				.setParameter("Id", userId).setParameter("Sort", PlanActionType.valueOf(sort)).getResultList();
	}
}
