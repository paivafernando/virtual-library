package com.library.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.trasnfer.MathOperationInputDTO;
import com.library.utils.NumberUtils;

@Slf4j
@RestController
@RequestMapping("/math-operations")
public class MathOperationsController {

	@GetMapping
	@RequestMapping(value = "/addition", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sum(@RequestBody MathOperationInputDTO obj) {

		log.info("Begin addition operation");
		Long result = Long.MIN_VALUE;

		try {
			if (!NumberUtils.isValid(obj.getNumberOne())//
					|| !NumberUtils.isValid(obj.getNumberTwo())) {

				return ResponseEntity.badRequest().body(
						"Please insert valid numbers!");
			}

			Long one = NumberUtils.parseToLong(obj.getNumberOne());
			log.info("Number One: {}", one);

			Long two = NumberUtils.parseToLong(obj.getNumberTwo());
			log.info("Number Two: {}", two);

			result  = additionOperate(one, two);
						
			return ResponseEntity.ok("Total: " + result);

		} catch (Exception ex) {

			return ResponseEntity.badRequest().body("Erro to proceed operation.");
		}
	}

	private long additionOperate(final Long one, final Long two) {
		return Math.addExact(one, two);
	}

	@GetMapping
	@RequestMapping(value = "/{userId}/subtraction", method = RequestMethod.GET)
	public ResponseEntity<?> subtract(@PathVariable("userId") long userId,
			@RequestBody MathOperationInputDTO obj) {

		return null;
	}

	// Multiplicação

	// Divisão

}
