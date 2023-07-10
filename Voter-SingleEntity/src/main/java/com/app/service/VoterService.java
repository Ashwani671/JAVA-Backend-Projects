package com.app.service;

import java.util.List;

import com.app.dto.AuthReqVoterDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Voter;

public interface VoterService {
	
	List<Voter> getVoterList();
	Voter addVoter(Voter transVoter);
	Voter updateVoter(Voter detachVoter);
	Voter getVoterById(Long id);
	String deleteVoterById(Long id);
	AuthRespDTO authenticateVoter(AuthReqVoterDTO request);

}
