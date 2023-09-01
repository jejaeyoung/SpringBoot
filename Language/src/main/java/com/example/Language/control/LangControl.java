package com.example.Language.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.Language.model.LangModel;
import com.example.Language.services.LangService;



@Controller
public class LangControl {
	
	@Autowired
	LangService langservice;
	
	@GetMapping("/language")
	private String showAll(@ModelAttribute("newLang") LangModel nlanguage, Model gx)
	
	{
		gx.addAttribute("langlist", langservice.showAll());
		return "langshow.jsp";
	}
	
	@GetMapping("/language/new")
	private String createNew(@ModelAttribute("newLang")LangModel nlang, Model gx)
	{
		return "langform.jsp";
	}
	
	@PostMapping("/language/process")
	private String processNew(@Valid @ModelAttribute("newLang")LangModel nlang, BindingResult res)
	{
		if(res.hasErrors())
		{
			return "langform.jsp";
		}
		else {
		langservice.createLang(nlang);
		return"redirect:/language";
		}
	}
	
	//delete
	@DeleteMapping("/delete/lang/{langid}")
	private String delete(@PathVariable("langid")Long delete, Model mg)
	
	{
		mg.addAttribute("theLang", langservice.getOne(delete));
		langservice.deleteLang(delete);
		return"redirect:/language";
	}
	
	@DeleteMapping("/delete/lang/")
	private String delete1(@PathVariable("langid")Long delete)
	
	{
		langservice.deleteLang(delete);
		return"redirect:/language";
	}
	

	
	//show
	@GetMapping("/language/show{langid}")
	private String show(@PathVariable("langid")Long id, Model mg)
	{
		mg.addAttribute("theLang", langservice.getOne(id));
		return "show.jsp";
	}
	
	@GetMapping("/edit/lang/{langid}")
	private String edit(@PathVariable("langid")Long id, Model mg)
		{
			mg.addAttribute("editLang", langservice.getOne(id));
			return "edit.jsp";
		}
	
	@PutMapping("/lang/update/{langid}")
	private String update(@Valid @ModelAttribute("editLang")LangModel editLang, BindingResult res)
	{
		if(res.hasErrors())
		{
			return "edit.jsp";
		}
		else
		{
			langservice.updateOne(editLang);
			return"redirect:/language";
					
		}
	}
	
	
	
	
	
}
