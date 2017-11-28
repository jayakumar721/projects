package com.vamsoft.model;



import java.math.BigInteger;

import com.opencsv.bean.CsvBindByName;

public class Poplulation {
    
    
	@CsvBindByName
	private int state_code;
	@CsvBindByName
	private int district_code;
	@CsvBindByName
	private int sub_district_code;
	@CsvBindByName
	private String level;
	@CsvBindByName
	private String area_name;
	@CsvBindByName
	private int noofvillages;
	@CsvBindByName
	private long total_population;
	@CsvBindByName
	private long male_population;
	@CsvBindByName
	private long female_population;

	

	

	

	public long getTotal_population() {
		return total_population;
	}

	public void setTotal_population(long total_population) {
		this.total_population = total_population;
	}

	public long getMale_population() {
		return male_population;
	}

	public void setMale_population(long male_population) {
		this.male_population = male_population;
	}

	public long getFemale_population() {
		return female_population;
	}

	public void setFemale_population(long female_population) {
		this.female_population = female_population;
	}

	public int getState_code() {
		return state_code;
	}

	public void setState_code(int state_code) {
		this.state_code = state_code;
	}

	public int getDistrict_code() {
		return district_code;
	}

	public void setDistrict_code(int district_code) {
		this.district_code = district_code;
	}

	public int getSub_district_code() {
		return sub_district_code;
	}

	public void setSub_district_code(int sub_district_code) {
		this.sub_district_code = sub_district_code;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public int getNoofvillages() {
		return noofvillages;
	}

	public void setNoofvillages(int noofvillages) {
		this.noofvillages = noofvillages;
	}

	@Override
	public String toString() {
		return "Poplulation [state_code=" + state_code + ", district_code=" + district_code + ", sub_district_code="
		        + sub_district_code + ", level=" + level + ", area_name=" + area_name + ", noofvillages=" + noofvillages
		        + ", total_population=" + total_population + ", male_population=" + male_population
		        + ", female_population=" + female_population + "]";
	}

	

	

	

}
