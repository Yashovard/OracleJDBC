package com.sst.dao;

import java.util.List;

import com.sst.model.Insurance;

public interface InsuranceDao {

	public List<Insurance> InsuranceList();

	public Insurance getInsuranceById(int id);

	public void insertInsurance(Insurance insurance);

	public boolean RemoveInsurance(int id);

	public int updateInsurance(Insurance insurance);

	public void maxInsurance();

	public void minInsurance();

}
