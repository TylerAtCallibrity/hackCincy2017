package com.callibrity.muffaletta.hello;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MMiller on 19/8/2017 (Sat) at 12:55.
 */
@RestController
public class HelloWorldController {
	@RequestMapping("/api/hello")
	public Map<Object, Object> getHello() {
		return Collections.singletonMap("data", "Hello, world!");
	}
}
