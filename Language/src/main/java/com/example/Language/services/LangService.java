package com.example.Language.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Language.model.LangModel;
import com.example.Language.repository.LangRepository;

@Service
public class LangService {
	private final LangRepository langRepo;
	public LangService(LangRepository langRepo)
	{
		this.langRepo=langRepo;
	}
	
	public List<LangModel> showAll()
	{
		return langRepo.findAll();
	}
	
	public LangModel createLang(LangModel nlang)
	{
		return this.langRepo.save(nlang);
	}
	
	public LangModel getOne(Long id)
	{
		return this.langRepo.findById(id).orElse(null);
	}
	
	public LangModel updateOne(LangModel editLang)
	{
		return this.langRepo.save(editLang);
	}
	public void deleteLang(Long id)
	{
		this.langRepo.deleteById(id);
	}
	
	
	
	
}
	
	
	
	
	
	

