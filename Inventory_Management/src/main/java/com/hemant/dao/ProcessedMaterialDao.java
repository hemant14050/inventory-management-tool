package com.hemant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hemant.model.ProcessedMaterial;

@Component
public class ProcessedMaterialDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insert(ProcessedMaterial processedMaterial) {
		this.hibernateTemplate.save(processedMaterial);
	}
	
	public List<ProcessedMaterial> getAll() {
		List<ProcessedMaterial> processedMaterialList=hibernateTemplate.loadAll(ProcessedMaterial.class);
		return processedMaterialList;
	}
	
	public ProcessedMaterial get(int id) {
		ProcessedMaterial processedMaterial=hibernateTemplate.get(ProcessedMaterial.class, id);
		return processedMaterial;
	}
	
	@Transactional
	public void delete(int id) {
		ProcessedMaterial processedMaterial=hibernateTemplate.get(ProcessedMaterial.class, id);
		hibernateTemplate.delete(processedMaterial);
	}
	
	@Transactional               
	public void update(ProcessedMaterial processedMaterial) {
		hibernateTemplate.update(processedMaterial);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public ProcessedMaterialDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
