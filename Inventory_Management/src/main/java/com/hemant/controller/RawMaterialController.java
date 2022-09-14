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

import com.hemant.dao.IssuedRawMaterialDao;
import com.hemant.dao.RawMaterialDao;
import com.hemant.model.IssuedRawMaterial;
import com.hemant.model.RawMaterial;

@Controller
public class RawMaterialController {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao=(RawMaterialDao) context.getBean("rawMaterialDao");
	RawMaterial rawMaterial=(RawMaterial) context.getBean("rawMaterial");
	IssuedRawMaterialDao issuedRawMaterialDao=(IssuedRawMaterialDao) context.getBean("issuedRawMaterialDao");
	IssuedRawMaterial issuedRawMaterial=(IssuedRawMaterial) context.getBean("issuedRawMaterial");

	@RequestMapping("/rawmat")
	public String rawmat() {
		return "rawmat";
	}
	@RequestMapping("/addrawmatform")
	public String addRawMat() {
		return "addrawmatform";
	}
	@RequestMapping(path="/addrawmat",method=RequestMethod.POST)
	public RedirectView setRawMat(Model m,@ModelAttribute RawMaterial rawMaterial,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		try
		{
			rawMaterialDao.insert(rawMaterial);
			redirectView.setUrl(request.getContextPath()+"/viewrawmat");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id must be unique...(Primary key violeted)");
			redirectView.setUrl(request.getContextPath()+"/errormsg");
			return redirectView;
		}
	}
	@RequestMapping("/viewrawmat")
	public String viewRawMat(Model m) {
		List<RawMaterial> rawMaterial=rawMaterialDao.getAll();
		m.addAttribute("rawMaterial",rawMaterial);
		return "viewrawmat";
	}
	@RequestMapping(path="/delete/{id}",method=RequestMethod.GET)
	public RedirectView deleteRawMat(Model m,@PathVariable("id") int id, HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		try
		{
			rawMaterialDao.delete(id);
			
			redirectView.setUrl(request.getContextPath()+"/viewrawmat");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id not found...");
			redirectView.setUrl(request.getContextPath()+"/errormsg");
			return redirectView;
		}
	}
	@RequestMapping("/updateRawMatform")
	public String updateRawMat() {
		return "updateRawMatform";
	}
	@RequestMapping(path="/updateRawMat",method=RequestMethod.POST)
	public RedirectView updateRawMat(Model m,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		int id=Integer.parseInt(request.getParameter("itemId"));
		int newQuantity=Integer.parseInt(request.getParameter("itemQuantity"));
		try
		{
			rawMaterial = rawMaterialDao.get(id);
			int oldQuantity=rawMaterial.getItemQuantity();
			rawMaterial.setItemQuantity(oldQuantity+newQuantity);
			rawMaterialDao.update(rawMaterial);
			
			redirectView.setUrl(request.getContextPath()+"/viewrawmat");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id not found...");
			redirectView.setUrl(request.getContextPath()+"/errormsg");
			return redirectView;
		}
	}
	@RequestMapping("/issueRawMatform")
	public String issueRawMatform() {
		return "issueRawMatform";
	}
	@RequestMapping(path="/issueRawMat",method=RequestMethod.POST)
	public RedirectView issueRawMat(Model m,@ModelAttribute IssuedRawMaterial issuedRawMaterial1,HttpServletRequest request) {
		
		RedirectView redirectView=new RedirectView();
		int itemId=issuedRawMaterial1.getItemId();
		
		try
		{
			RawMaterial im=rawMaterialDao.get(itemId);
			int aQuantity=im.getItemQuantity();
			int iQuantity=issuedRawMaterial1.getItemQuantity();
			issuedRawMaterial1.setItemName(im.getItemName());
			
			if(aQuantity>=iQuantity){
				try
				{
					issuedRawMaterialDao.insert(issuedRawMaterial1);
					im.setItemQuantity(aQuantity-iQuantity);
					rawMaterialDao.update(im);
					
					redirectView.setUrl(request.getContextPath()+"/viewRawMatLog");
					return redirectView;
				}
				catch(Exception e)
				{
					m.addAttribute("msg", "Issue Id must be unique...(Primary key violeted)");
					redirectView.setUrl(request.getContextPath()+"/errormsg");
					return redirectView;
				}
			}
			
			m.addAttribute("msg", "Issue quantity must less than available quantity...");
			redirectView.setUrl(request.getContextPath()+"/errormsg");
			return redirectView;
		}
		catch(Exception e)
		{
			m.addAttribute("msg", "Material Id not found...");
			redirectView.setUrl(request.getContextPath()+"/errormsg");
			return redirectView;
		}
	}
	@RequestMapping("/viewRawMatLog")
	public String viewRawMatLog(Model m) {
		List<IssuedRawMaterial> issuedrawMaterialLog=issuedRawMaterialDao.getAll();
		m.addAttribute("issuedrawMaterialLog",issuedrawMaterialLog);
		return "viewRawMatLog";
	}
	@RequestMapping("/unavailableRawMat")
	public String unAvaiRawMat(Model m) {
		List<RawMaterial> rawMaterial=rawMaterialDao.getAll();
		m.addAttribute("rawMaterial",rawMaterial);
		return "unavailableRawMat";
	}
}
