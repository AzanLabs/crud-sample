package com.coop.crud.service;

import java.util.List;

import com.coop.crud.dao.PriestDao;
import com.coop.crud.modal.Priest;

public class PriestServiceImpl implements PriestService {
	
	private PriestDao<Priest> dao = null;
	
	public PriestServiceImpl(PriestDao<Priest> dao) {
		this.dao = dao;
	}

	public Priest createTodo(Priest priest) throws Exception {
		System.out.println("entering service");
		try{
			priest = this.dao.SaveOne(priest);
		} catch(Exception e) {
			throw new Exception("exception caught on to do service "+e.getMessage());
		} finally {
			//DaoFactory.close();
		}
		return priest;
	}

	public Priest updateTodo(Priest priest) throws Exception {
		try{
			priest = this.dao.updateOne(priest);
		} catch(Exception e) {
			throw new Exception("exception caught on to do service "+e.getMessage());
		}
		return priest;
	}
	
	public List<Priest> getAllTodo() {
		return this.dao.findAll();
	}
	
	public Priest find(String id) {
		return this.dao.findById(id);
	}
}
