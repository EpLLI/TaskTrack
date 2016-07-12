package test.z.service;

import java.util.List;


import test.z.pojos.Project;

import test.z.serviceException.ServiceException;

public interface IProjectService extends Services<Project>{
	 void addProject(Project proj) throws ServiceException;
	 public List<Project> getAllProject()throws ServiceException;
	 Project getProject(String name) throws ServiceException;
}
