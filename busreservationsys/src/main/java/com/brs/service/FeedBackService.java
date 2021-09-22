package com.brs.service;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brs.entity.Bus;
import com.brs.entity.FeedBack;
import com.brs.exceptions.BusNotFoundException;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.repository.IFeedBackRepository;

@Service
@Transactional
public class FeedBackService implements IFeedBackService {
	@Autowired
	private IFeedBackRepository feedbackRepository;

	@Override
	public FeedBack addFeedBack(FeedBack feedback) {
		feedbackRepository.save(feedback);

		return feedback;

	}

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) {
		feedbackRepository.save(feedback);

		return feedback;

	}

	@Override
	public FeedBack viewFeedBack(int id) {
		FeedBack fb = feedbackRepository.findById(id).get();

		return fb;

	}

	@Override
	public List<FeedBack> viewAllFeedBack() {

		return feedbackRepository.findAll();

	}
	@Override
	public FeedBack deleteFeedBack(int feedBackId)  {
		FeedBack feedBack=null;
		try {
			feedBack=feedbackRepository.findById(feedBackId).orElseThrow(FeedBackNotFoundException::new);
			feedbackRepository.delete(feedBack);
		} catch (FeedBackNotFoundException e) {
			e.printStackTrace();
		}
		return feedBack;
	}

}
