package com.sprsec.service;

import java.util.List;

import com.sprsec.model.AjoutAstuce;
import com.sprsec.model.Astuce;

public interface AstuceService {
	public List<Astuce> getAllAstuce();
	public List<Astuce> getAstuce(String chatname);
	public Astuce getAstuceById(int  id);
	public void addAstuce(AjoutAstuce astuce);
	public void addPlus(Astuce astuce);
	public void addMoins(Astuce astuce);
	public void deleteAstuce(int id);
}
