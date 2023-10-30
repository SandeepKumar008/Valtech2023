package com.valtech.training.mobile_rating_ui;

import com.valtech.training.mobile_ranking.*;

public class RatingHelper {
	
	private MobileRankingService mobileRankingService = new MobileRankingServiceImpl();
	
	public int getRanking(String mobile) {
//		validation
		return mobileRankingService.rankMobile(mobile);
	}

}
