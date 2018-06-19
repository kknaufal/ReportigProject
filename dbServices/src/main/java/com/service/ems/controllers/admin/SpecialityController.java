package com.service.ems.controllers.admin;

import java.util.List;

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

import com.service.ems.models.SpecialityModel;
import com.service.ems.services.SpecialityService;

@RestController
@RequestMapping(value="/speciality")
public class SpecialityController {

	@Autowired
	private SpecialityService specialityService;
	
	@GetMapping
	ResponseEntity<List<SpecialityModel>> getSpeciality(){
		return  ResponseEntity.ok(specialityService.getAllSpeciality());
	}
	
	@GetMapping("/{id}")
	ResponseEntity<List<SpecialityModel>> getSpecialityById(@PathVariable(value = "id") final long id){
		return  ResponseEntity.ok(specialityService.getSpecialityById(id));
	}

	@PostMapping()
	ResponseEntity<SpecialityModel> postSpeciality(@RequestBody final SpecialityModel specialityModel) {
		return  ResponseEntity.ok(specialityService.addSpeciality(specialityModel));
	}
	
	@PutMapping()
	ResponseEntity<SpecialityModel> putSpeciality(@RequestBody final SpecialityModel speciality) {
		return ResponseEntity.ok(specialityService.updateSpeciality(speciality));
	}
	
	@DeleteMapping("{id}")
	ResponseEntity deleteSpeciality(@PathVariable(value = "id") final long id) {
		specialityService.deleteSpeciality(id);
		return ResponseEntity.ok("Delete Successful");
	}
	
	@GetMapping("/default")
	ResponseEntity<SpecialityModel> getSpecialityDefault(){
		SpecialityModel specialityModel = new SpecialityModel();
		specialityModel.setName("Default Speciality");
		specialityService.addSpeciality(specialityModel);
		return ResponseEntity.ok().build();
	}
	
}
