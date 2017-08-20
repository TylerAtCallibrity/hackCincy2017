package com.callibrity.muffaletta.hello;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callibrity.muffaletta.entity.DrinkForm;

/**
 * Created by MMiller on 19/8/2017 (Sat) at 12:55.
 */
@RestController
public class HelloWorldController {
	@RequestMapping(value = "/api/hello", method = RequestMethod.POST)
	public Map<Object, Object> getHello(@Valid DrinkForm drinkForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return Collections.singletonMap("error", "Please provide ingredients");
		}
		return Collections.singletonMap("data", drinkForm.getIngredients());
	}
}
