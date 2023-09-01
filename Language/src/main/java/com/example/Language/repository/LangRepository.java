package com.example.Language.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Language.model.LangModel;

@Repository
public interface LangRepository extends CrudRepository<LangModel, Long>

{
	List<LangModel> findAll();
}
