package com.example.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Application;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void add(Application application) {
		em.persist(application);
		
	}

	@Override
	@Transactional
	public List<Application> list() {
		CriteriaQuery<Application> c = em.getCriteriaBuilder().createQuery(Application.class);
        c.from(Application.class);
        return em.createQuery(c).getResultList();
	}

	@Override
	@Transactional
	public void delete(Integer appId) {
		Application application = em.find(Application.class, appId);
        if (null != application) {
            em.remove(application);
        }		
	}
	
	@Override
	@Transactional
	public Application getApp(Integer appId) {
		
		return em.find(Application.class, appId);
	}

}
