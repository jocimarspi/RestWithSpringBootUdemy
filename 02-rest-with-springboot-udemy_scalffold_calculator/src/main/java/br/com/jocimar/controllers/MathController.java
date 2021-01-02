package br.com.jocimar.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jocimar.exceptions.UnsupportedMathOperationException;
import br.com.jocimar.math.SimpleMath;
import br.com.jocimar.request.util.Convertion;
import br.com.jocimar.request.util.Validation;

@RestController
public class MathController {
	
    private SimpleMath math = new SimpleMath();
	
	
	@RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.sum(Convertion.convertToDouble(numberOne), Convertion.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		return math.subtraction(Convertion.convertToDouble(numberOne), Convertion.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.multiplication(Convertion.convertToDouble(numberOne), Convertion.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divivsion(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value.");
		}
		
		Double divisor = Convertion.convertToDouble(numberTwo);
		
		if (divisor == 0) {
			throw new UnsupportedMathOperationException("Division by zero.");
		}

		return math.division(Convertion.convertToDouble(numberOne), Convertion.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!Validation.isNumeric(numberOne) || !Validation.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.mean(Convertion.convertToDouble(numberOne), Convertion.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "squareRoot/{number}", method = RequestMethod.GET)
	public Double average(@PathVariable(value = "number") String number) throws Exception {

		if (!Validation.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return math.squareRoot(Convertion.convertToDouble(number));
	}
}
