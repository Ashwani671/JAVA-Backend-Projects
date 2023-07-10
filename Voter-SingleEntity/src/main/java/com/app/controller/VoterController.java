package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthReqVoterDTO;
import com.app.entities.Voter;
import com.app.service.VoterService;

@RestController
@RequestMapping("/voter")
public class VoterController {
	@Autowired
	private VoterService voterService; 
	
	public VoterController() {
		// TODO Auto-generated constructor stub
		System.out.println("in VoterController");
	}
	
	@GetMapping
	public List<Voter> listVoter(){
		return voterService.getVoterList();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getVoter(@PathVariable Long id){
		return new ResponseEntity<>(voterService.getVoterById(id), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> addVoter(@RequestBody Voter transVoter){
		return new ResponseEntity<>(voterService.addVoter(transVoter), HttpStatus.CREATED);
	}
	@PutMapping
	public Voter updateVoter(@RequestBody Voter detachVoter) {
		return voterService.updateVoter(detachVoter);
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse deleteVoter(@PathVariable Long id) {
		return new ApiResponse(voterService.deleteVoterById(id));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateVoter(@RequestBody @Valid AuthReqVoterDTO request){
		return new ResponseEntity<>(voterService.authenticateVoter(request), HttpStatus.ACCEPTED);
	}

}
