package com.service.ems.controllers.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.domain.InsurancePolicy;
import com.service.ems.domain.Speciality;
import com.service.ems.models.AddressModel;
import com.service.ems.models.PracticeModel;
import com.service.ems.services.PracticeService;


@RestController
@RequestMapping(value="/practice")
public class PracticeController {

	@Autowired
	private PracticeService practiceService;
	
	@GetMapping
	ResponseEntity<List<PracticeModel>> getPractice(){
		return  ResponseEntity.ok(practiceService.getAllPractice());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<List<PracticeModel>> getPracticeById(@PathVariable(value = "id") final long id){
		return  ResponseEntity.ok(practiceService.getPracticeById(id));
	}

	@PostMapping()
	ResponseEntity<PracticeModel> postPractice(@RequestBody final PracticeModel practice) {
		return  ResponseEntity.ok(practiceService.addPractice(practice));
	}
	
	@PutMapping()
	ResponseEntity<PracticeModel> putPractice(@RequestBody final PracticeModel practice) {
		return ResponseEntity.ok(practiceService.updatePractice(practice));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity deletePractice(@PathVariable(value = "id") final long id) {
		practiceService.deletePractice(id);
		return ResponseEntity.ok("Delete Successful");
	}
		
}
