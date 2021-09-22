package com.brs.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brs.entity.FeedBack;
import com.brs.entity.Reservation;
import com.brs.exceptions.FeedBackNotFoundException;
import com.brs.service.IFeedBackService;

@Controller
@RequestMapping("rest/api")
public class FeedBackController {
	@Autowired
	IFeedBackService feedbackService;
	
	@PostMapping("/feedbacks")
	public ResponseEntity<FeedBack> addFeedBack(@Valid@RequestBody FeedBack feedback){
		FeedBack newVal = feedbackService.addFeedBack(feedback);
		return new ResponseEntity<FeedBack>(newVal,HttpStatus.OK);
		
	}
	
	@PutMapping("/feedbacks/update")
	public ResponseEntity<FeedBack> updateFeedBack(@Valid@RequestBody FeedBack feedback){
		FeedBack newVal = feedbackService.updateFeedBack(feedback);
		return new ResponseEntity<FeedBack>(newVal,HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbacks/{fbid}")
	public ResponseEntity<FeedBack> viewFeedBack(@PathVariable("fbid") int id) throws FeedBackNotFoundException{
		return new ResponseEntity<FeedBack>(feedbackService.viewFeedBack(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbacks")
	public ResponseEntity<List<FeedBack>> viewAllFeedBack(){
		List<FeedBack> firstFeedBack = feedbackService.viewAllFeedBack();
		return new ResponseEntity<List<FeedBack>>(firstFeedBack,HttpStatus.OK);
	}
	@DeleteMapping("/feedbacks/{id}")
	public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("id") int id){
		FeedBack deleted = feedbackService.deleteFeedBack(id);
		return new ResponseEntity<FeedBack>(deleted,HttpStatus.OK);
		
	}
	

}