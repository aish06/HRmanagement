package com.nagarro.dao;

import com.nagarro.models.HRModel;

public interface HRDao
{
	HRModel getHRUser(String userId,String password);
}
