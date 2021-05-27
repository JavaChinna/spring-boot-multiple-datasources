package com.javachinna.repo.prime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javachinna.model.prime.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@Transactional
public class UserInfoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<UserInfo> getUerInfo() {
		List<UserInfo> list = new ArrayList<>();
		Query query = entityManager.createNativeQuery("select user_id, username from user", "UserInfoMapping");
		try {
			// Execute query
			list = query.getResultList();
		} catch (Exception e) {
			log.error("Error while querying the db", e);
		} finally {
			try {
				query.unwrap(ProcedureOutputs.class).release();
			} catch (Exception e) {
			}
		}
		return list;
	}
}
