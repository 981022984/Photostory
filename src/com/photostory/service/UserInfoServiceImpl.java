package com.photostory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.photostory.dao.PhotosDao;
import com.photostory.entity.Photos;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Resource
	private PhotosDao photosCURD;
	
	@Override
	public ArrayList<Photos> getUserPhotos(String userID) {
		ArrayList<Photos> list = photosCURD.getUserPhotos(userID);
		return list;
	}
}
