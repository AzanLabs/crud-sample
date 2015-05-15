package com.coop.crud.service;

import java.util.List;

import com.coop.crud.exception.CustomException;
import com.coop.crud.modal.Priest;

public interface PriestService extends BaseService{
	
	public Priest savePriestProfile(Priest priest);
	
	public List<Priest> getAllPriests();
	
	public Priest updatePriest(Priest priest) throws CustomException;
	
	public Priest deletePriest(String id) throws CustomException;
	
	public boolean ifIdExists(String id) throws CustomException;
}
