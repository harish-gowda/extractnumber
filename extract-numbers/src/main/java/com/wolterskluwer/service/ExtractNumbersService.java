package com.wolterskluwer.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolterskluwer.exception.ResourceNotFoundException;

@Service
public class ExtractNumbersService {

	public String readInput(String filePath) {
		Path path = Paths.get(filePath);
		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(s -> list.add(s));
		} catch (IOException ex) {
			new ResourceNotFoundException("File not found");
		}
		return extractNumbers(list);

	}

	private String extractNumbers(List<String> list) {
		ObjectMapper objectMapper = new ObjectMapper();
		String[] strArray = list.stream().toArray(String[]::new);
		Map<String, Map<String, Integer>> resMap = new TreeMap<String, Map<String, Integer>>();
		for (int i = 0; i < strArray.length; i++) {
			Map<String, Integer> indexMap = new TreeMap<String, Integer>();
			for (int j = 0; j < strArray[i].length(); j++) {
				char chrs = strArray[i].charAt(j);
				if (Character.isDigit(chrs)) {
					indexMap.put(chrs + " Found at Position ", j);
				}
			}
			resMap.put("Line Number " + i, indexMap);
		}

		try {
			//objectMapper.setSerializationInclusion(Include.NON_NULL);
			objectMapper.setSerializationInclusion(Include.NON_EMPTY); 
			return objectMapper.writeValueAsString(resMap);
		} catch (JsonProcessingException e) {
			new ResourceNotFoundException("Json parse Exception");
		}
		return "empty";
	}
}
