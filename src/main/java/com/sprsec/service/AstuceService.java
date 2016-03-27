package com.sprsec.service;

import java.util.List;

import com.sprsec.model.Astuce;

public interface AstuceService {
	public List<Astuce> getAllAstuce();
	public List<Astuce> getAstuce(String chatname, String username);
	public void addAstuce(Astuce astuce);
	public void addPlus(Astuce astuce);
	public void addMoins(Astuce astuce);
}
