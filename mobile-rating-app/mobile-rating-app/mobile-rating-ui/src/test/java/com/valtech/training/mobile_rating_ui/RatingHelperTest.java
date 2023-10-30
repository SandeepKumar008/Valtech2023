package com.valtech.training.mobile_rating_ui;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {

	
	public void testGetRating() {
		RatingHelper helper = new RatingHelper();
		Assert.assertEquals(0, helper.getRanking("9898989898"));
	}

}
