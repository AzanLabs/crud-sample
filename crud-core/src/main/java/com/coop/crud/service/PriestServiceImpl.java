package com.coop.crud.service;

import java.util.List;

import com.coop.crud.dao.PriestDao;
import com.coop.crud.exception.CustomException;
import com.coop.crud.exception.CustomRuntimeException;
import com.coop.crud.modal.Priest;

public class PriestServiceImpl implements PriestService {
	
	private PriestDao<Priest> dao = null;
	
	public PriestServiceImpl(PriestDao<Priest> dao) {
		this.dao = dao;
	}

	@Override
	public Priest savePriestProfile(Priest priest) {
		Priest returnObj = null;
		returnObj = this.dao.SaveOne(priest);
		return returnObj;
	}

	@Override
	public List<Priest> getAllPriests() {
		List<Priest> priests = null;
		priests = this.dao.findAll();
		return priests;
	}

	@Override
	public Priest updatePriest(Priest priest) throws CustomException {
		Priest returnObj = null;
		try{
			returnObj = this.dao.updateOne(priest);
		}catch(CustomException e){
			throw new CustomException(e);
		}catch(Exception e){
			throw new CustomRuntimeException(e);
		}
		return returnObj;
	}

	@Override
	public Priest deletePriest(String id) throws CustomException {
		Priest priest = null;
		priest = this.dao.deleteOne(id);
		return priest;
	}

	@Override
	public boolean ifIdExists(String id) throws CustomException {
		return (this.dao.findById(id) != null);
	}
	
	
}
