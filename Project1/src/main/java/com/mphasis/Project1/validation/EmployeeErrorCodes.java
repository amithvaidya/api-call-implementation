package com.mphasis.Project1.validation;

import org.springframework.beans.factory.annotation.Value;

public class EmployeeErrorCodes {
	
	@Value("EmployeeErrorCode.ERR_01:12")
	public final static String ERR_01 = "The employee identity number already exsists.";
	
	public static final String ERR_02 = "The employee name already exsists.";
	public static final String ERR_03 = "The employee mobile number already exsists. ";
	
}
