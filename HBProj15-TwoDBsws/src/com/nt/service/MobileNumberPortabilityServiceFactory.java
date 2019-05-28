package com.nt.service;

public class MobileNumberPortabilityServiceFactory {
	public static MobileNumberPortabilityService getInstance(){
		return new MobileNumberPortabilityServiceImpl();
	}

}
