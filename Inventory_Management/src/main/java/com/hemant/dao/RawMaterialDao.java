package com.hemant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hemant.model.RawMaterial;

@Component
public class RawMaterialDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insert(RawMaterial rawMaterial) {
		this.hibernateTemplate.save(rawMaterial);
	}
	
	public List<RawMaterial> getAll() {
		List<RawMaterial> rawMaterialList=hibernateTemplate.loadAll(RawMaterial.class);
		return rawMaterialList;
	}
	
	public RawMaterial get(int id) {
		RawMaterial rawMaterial=hibernateTemplate.get(RawMaterial.class, id);
		return rawMaterial;
	}
	
	@Transactional
	public void delete(int id) {
		RawMaterial rawMaterial=hibernateTemplate.get(RawMaterial.class, id);
		hibernateTemplate.delete(rawMaterial);
	}
	
	@Transactional               
	public void update(RawMaterial rawMaterial) {
		hibernateTemplate.update(rawMaterial);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public RawMaterialDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
