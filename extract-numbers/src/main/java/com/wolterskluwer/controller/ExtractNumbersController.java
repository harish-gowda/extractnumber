package com.wolterskluwer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolterskluwer.model.RequestType;
import com.wolterskluwer.service.ExtractNumbersService;

@RestController
public class ExtractNumbersController {
	
	@Autowired
	ExtractNumbersService extractNumbersService;

	@PostMapping(value ="/api/number/extractor")
	public String readFromInputFile(@RequestBody RequestType request) {
		return extractNumbersService.readInput(request.getFilePath());
	}
}
