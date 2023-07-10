package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AuthReqVoterDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Voter;
import com.app.repository.VoterRepository;
@Service
@Transactional
public class VoterServiceImpl implements VoterService 
{
	@Autowired
	private VoterRepository voterRepo;
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public List<Voter> getVoterList() {
		// TODO Auto-generated method stub
		return voterRepo.findAll();
	}

	@Override
	public Voter addVoter(Voter transVoter) {
		// TODO Auto-generated method stub
		return voterRepo.save(transVoter);
	}

	@Override
	public Voter updateVoter(Voter detachVoter) {
		// TODO Auto-generated method stub
		return voterRepo.save(detachVoter);
	}

	@Override
	public Voter getVoterById(Long id) {
		// TODO Auto-generated method stub
		return voterRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalide id, Voter can't be found"));
	}

	@Override
	public String deleteVoterById(Long id) {
		// TODO Auto-generated method stub
		String msg="Voter can't be deleted!!";
		if(voterRepo.existsById(id)) {
			voterRepo.deleteById(id);
			msg="voter with"+id +"is deleted sccessfully";
		}
		return msg;
	}

	@Override
	public AuthRespDTO authenticateVoter(AuthReqVoterDTO request) {
		// TODO Auto-generated method stub
		Voter voter=voterRepo.findByEmailAndPassword(request.getEmail(),request.getPassword()).orElseThrow(()->new ResourceNotFoundException("Invalid Credentials!!"));
		AuthRespDTO authresp= mapper.map(voter, AuthRespDTO.class);
		return authresp;
	}

}
