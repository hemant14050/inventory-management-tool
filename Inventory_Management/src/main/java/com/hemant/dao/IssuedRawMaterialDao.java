package com.hemant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hemant.model.IssuedRawMaterial;

@Component
public class IssuedRawMaterialDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insert(IssuedRawMaterial issuedRawMaterial) {
		this.hibernateTemplate.save(issuedRawMaterial);
	}
	
	public List<IssuedRawMaterial> getAll() {
		List<IssuedRawMaterial> issuedRawMaterialList=hibernateTemplate.loadAll(IssuedRawMaterial.class);
		return issuedRawMaterialList;
	}
	
	public IssuedRawMaterial get(int id) {
		IssuedRawMaterial issuedRawMaterial=hibernateTemplate.get(IssuedRawMaterial.class, id);
		return issuedRawMaterial;
	}
	
	@Transactional
	public void delete(int id) {
		IssuedRawMaterial issuedRawMaterial=hibernateTemplate.get(IssuedRawMaterial.class, id);
		hibernateTemplate.delete(issuedRawMaterial);
	}
	
	@Transactional               
	public void update(IssuedRawMaterial issuedRawMaterial) {
		hibernateTemplate.update(issuedRawMaterial);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public IssuedRawMaterialDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
