package com.hemant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.hemant.dao.IssuedProMaterialDao;
import com.hemant.dao.ProcessedMaterialDao;
import com.hemant.model.IssuedProMaterial;
import com.hemant.model.ProcessedMaterial;

@Controller
public class ProcessedMaterialController {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	ProcessedMaterialDao processedMaterialDao=(ProcessedMaterialDao) context.getBean("processedMaterialDao");
	ProcessedMaterial processedMaterial=(ProcessedMaterial) context.getBean("processedMaterial");
	IssuedProMaterialDao issuedProMaterialDao=(IssuedProMaterialDao) context.getBean("issuedProMaterialDao");
	IssuedProMaterial issuedProMaterial=(IssuedProMaterial) context.getBean("issuedProMaterial");

	@RequestMapping("/promat")
	public String proMat() {
		return "promat";
	}
	@RequestMapping("/addProMatForm")
	public String addProMat() {
		return "addProMatForm";
	}
	@RequestMapping(path="/addRawMat",method=RequestMethod.POST)
	public RedirectView setRawMat(Model m,@ModelAttribute ProcessedMaterial processedMaterial,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		try
		{
			processedMaterialDao.insert(processedMaterial);

			redirectView.setUrl(request.getContextPath()+"/viewProMat");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id must be unique...(Primary key violeted)");
			redirectView.setUrl(request.getContextPath()+"/errormsg1");
			return redirectView;
		}
	}
	@RequestMapping("/viewProMat")
	public String viewProMat(Model m) {
		
		List<ProcessedMaterial> processedMaterial=processedMaterialDao.getAll();
		m.addAttribute("processedMaterial",processedMaterial);
		return "viewProMat";
	}
	@RequestMapping(path="/deletee/{id}",method=RequestMethod.GET)
	public RedirectView deleteProMat(Model m,@PathVariable("id") int id, HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		try
		{
			processedMaterialDao.delete(id);
			redirectView.setUrl(request.getContextPath()+"/viewProMat");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id not found...");
			redirectView.setUrl(request.getContextPath()+"/errormsg1");
			return redirectView;
		}
	}
	@RequestMapping("/updateProMatform")
	public String updateRawMat() {
		return "updateProMatform";
	}
	@RequestMapping(path="/updateProMat",method=RequestMethod.POST)
	public RedirectView updateProMat(Model m,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		
		int id=Integer.parseInt(request.getParameter("itemId"));
		int newQuantity=Integer.parseInt(request.getParameter("itemQuantity"));
		try
		{
			processedMaterial = processedMaterialDao.get(id);
			int oldQuantity=processedMaterial.getItemQuantity();
			processedMaterial.setItemQuantity(oldQuantity+newQuantity);
			processedMaterialDao.update(processedMaterial);
			redirectView.setUrl(request.getContextPath()+"/viewProMat");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id not found...");
			redirectView.setUrl(request.getContextPath()+"/errormsg1");
			return redirectView;
		}
	}
	@RequestMapping("/issueProMatform")
	public String issueRawMatform() {
		return "issueProMatform";
	}
	@RequestMapping(path="/issueProMat",method=RequestMethod.POST)
	public RedirectView issueProMat(Model m,@ModelAttribute IssuedProMaterial issuedProMaterial1,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
	
		int itemId=issuedProMaterial1.getItemId();
		try
		{
			ProcessedMaterial pm=processedMaterialDao.get(itemId);
			int aQuantity=pm.getItemQuantity();
			int iQuantity=issuedProMaterial1.getItemQuantity();
			issuedProMaterial1.setItemName(pm.getItemName());
			if(aQuantity>=iQuantity){
				try
				{
					issuedProMaterialDao.insert(issuedProMaterial1);
					pm.setItemQuantity(aQuantity-iQuantity);
					processedMaterialDao.update(pm);
					
					redirectView.setUrl(request.getContextPath()+"/viewProMatLog");
					return redirectView;
				}
				catch(Exception e)
				{
					m.addAttribute("msg", "Issue Id must be unique...(Primary key violeted)");
					redirectView.setUrl(request.getContextPath()+"/errormsg1");
					return redirectView;
				}
			}
			m.addAttribute("msg", "Issue quantity must less than available quantity...");
			redirectView.setUrl(request.getContextPath()+"/errormsg1");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id not found...");
			redirectView.setUrl(request.getContextPath()+"/errormsg1");
			return redirectView;
		}
		
	}
	@RequestMapping("/viewProMatLog")
	public String viewRawMatLog(Model m) {
		List<IssuedProMaterial> issuedProMaterialLog=issuedProMaterialDao.getAll();
		m.addAttribute("issuedProMaterialLog",issuedProMaterialLog);
		return "viewProMatLog";
	}
	@RequestMapping("/unavailableProMat")
	public String unAvaiProMat(Model m) {
		List<ProcessedMaterial> processedMaterial=processedMaterialDao.getAll();
		m.addAttribute("processedMaterial",processedMaterial);
		return "unavailableProMat";
	}
}
