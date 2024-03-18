package com.prototype.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@RestController
@RequestMapping({ "", "/", "/home", "/index" })
public class HomeController {

	private ModelAndView mav;

	@GetMapping({ "", "/", "/home", "/index" })
	public ModelAndView index() {
		log.info("----- Home Controller | Index -----");
		mav = new ModelAndView("home");
		return mav;
	}
}