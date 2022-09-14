package com.hemant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hemant.model.IssuedProMaterial;


@Component
public class IssuedProMaterialDao {

	@Autowired 
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insert(IssuedProMaterial issuedProMaterial) {
		this.hibernateTemplate.save(issuedProMaterial);
	}
	
	public List<IssuedProMaterial> getAll() {
		List<IssuedProMaterial> issuedProMaterialList=hibernateTemplate.loadAll(IssuedProMaterial.class);
		return issuedProMaterialList;
	}
	
	public IssuedProMaterial get(int id) {
		IssuedProMaterial issuedProMaterial=hibernateTemplate.get(IssuedProMaterial.class, id);
		return issuedProMaterial;
	}
	
	@Transactional
	public void delete(int id) {
		IssuedProMaterial issuedProMaterial=hibernateTemplate.get(IssuedProMaterial.class, id);
		hibernateTemplate.delete(issuedProMaterial);
	}
	
	@Transactional               
	public void update(IssuedProMaterial issuedProMaterial) {
		hibernateTemplate.update(issuedProMaterial);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public IssuedProMaterialDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
