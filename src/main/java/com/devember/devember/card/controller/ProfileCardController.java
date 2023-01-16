package com.devember.devember.card.controller;


import com.devember.devember.card.dto.ProfileCardDto;
import com.devember.devember.card.service.ProfileCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cards")
@RestController
@RequiredArgsConstructor
public class ProfileCardController {

	private final ProfileCardService profileCardService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProfileCardDto.CardRequest request){
		profileCardService.createProfileCard(request);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		profileCardService.read(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/snss")
	public ResponseEntity<?> addSns(@RequestBody ProfileCardDto.SnsRequest request){
		profileCardService.addSns(request);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/skills")
	public ResponseEntity<?> addSkill(@RequestBody ProfileCardDto.SkillRequest request){
		profileCardService.addSkill(request);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/fields")
	public ResponseEntity<?> addField(@RequestBody ProfileCardDto.FieldRequest request){
		profileCardService.addField(request);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/snss")
	public ResponseEntity<?> updateSns(@RequestBody ProfileCardDto.SnsRequest request){
		profileCardService.addSns(request);
		return ResponseEntity.ok().build();
	}

//	@PutMapping("/skills")
//	public ResponseEntity<?> updateSkill(@RequestBody ProfileCardDto.SkillRequest request){
//		profileCardService.updateSkill(request);
//		return ResponseEntity.ok().build();
//	}
//
//	@PutMapping("/fields")
//	public ResponseEntity<?> updateField(@RequestBody ProfileCardDto.FieldRequest request){
//		profileCardService.updateField(request);
//		return ResponseEntity.ok().build();
//	}

}
