package com.brs.service;

import java.time.LocalDate;
import java.util.List;

import com.brs.entity.FeedBack;
import com.brs.entity.Reservation;

public interface IFeedBackService {

	FeedBack addFeedBack(FeedBack feedback);

	FeedBack updateFeedBack(FeedBack feedback);

	FeedBack viewFeedBack(int id);

	List<FeedBack> viewAllFeedBack();

	

	FeedBack deleteFeedBack(int feedBackId);

}
