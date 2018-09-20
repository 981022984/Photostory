package com.photostory.test;



import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;

import com.photostory.dao.TempPhotosMapperCURD;
import com.photostory.entity.Tphotos;
import com.photostory.unit.DealwithPhotos;

public class TestDealwithPhotos {
	@Resource(name="tempPhotosCURD")
	private TempPhotosMapperCURD tempPhotosCURD;
	
	@Test
	public void test() {
		try {
			/*System.out.println(TestDealwithPhotos.class.getResource("../").getPath());
			System.out.println(TestDealwithPhotos.class.getResource("").getPath());*/
			System.out.println(TestDealwithPhotos.class.getResource("../../../").getPath());
			/*DealwithPhotos.resize("../PhotoStory/WebContent/userPhotos/image/10001.jpg", "../PhotoStory/WebContent/userPhotos/pagePhotos/10001.jpg", 
					320, 200, true);*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
