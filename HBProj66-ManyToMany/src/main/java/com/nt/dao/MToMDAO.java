package com.nt.dao;

public interface MToMDAO {
	public void saveDataUsingProgrammer();
	public void saveDataUsingProjects();
	public void loadDataUsingProgrammer();
	public void loadDataUsingProject();
	public void assingExisitingProjectsToExistingProgrammer();
	public void interChangeProjectsOfProgrammers();
	public  void deleteAllProgrammersOfAProject();
}
