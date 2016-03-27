package com.sprsec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprsec.dao.AstuceDAO;
import com.sprsec.model.Astuce;

@Service("astuceService")
@Transactional
public class AstuceServiceImpl implements AstuceService{
	
	@Autowired
	private AstuceDAO astuceDAO;

	@Override
	public List<Astuce> getAllAstuce() {
		return getAllAstuce();
	}

	@Override
	public List<Astuce> getAstuce(String chatname, String username) {
		return getAstuce(chatname, username);
	}

	@Override
	public void addAstuce(Astuce astuce) {
		astuceDAO.addAstuce(astuce);
	}

	@Override
	public void addPlus(Astuce astuce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMoins(Astuce astuce) {
		// TODO Auto-generated method stub
		
	}

}
