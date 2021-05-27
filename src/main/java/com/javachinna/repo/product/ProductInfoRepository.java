package com.javachinna.repo.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javachinna.model.product.ProductInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ProductInfoRepository {

	@Autowired
	@Qualifier("productEntityManager")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<ProductInfo> getProductInfo() {
		List<ProductInfo> list = new ArrayList<>();
		Query query = entityManager.createNativeQuery("select id, name, price from product", "ProductInfoMapping");
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

	@Transactional("productTransactionManager")
	public void updateProductInfo(String name, Long id) {
		Query query = entityManager.createQuery("update Product set name=:name where id=:id");
		try {
			// Execute query
			query.setParameter("name", name);
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			log.error("Error while querying the db", e);
		} finally {
			try {
				query.unwrap(ProcedureOutputs.class).release();
			} catch (Exception e) {
			}
		}
	};
}
