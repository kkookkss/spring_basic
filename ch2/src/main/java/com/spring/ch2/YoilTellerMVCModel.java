package com.spring.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVCModel {
	@RequestMapping("/getYoilModel") // http://localhost:8080/ch2/getYoilModel?year=2022&month=07&day=26
	public ModelAndView main( // 반환타입이 ModelAndView
			int year, int month, int day // Model을 받지 않음
	) throws IOException {
		
		// 1. ModelAndView를 생성하고, 기본 뷰를 지정
		ModelAndView mv = new ModelAndView();
		mv.setViewName("yoilError"); // 뷰의 이름을 지정

		// 2. 유효성 검사
    	if(!isValid(year, month, day)) 
    		return mv;

		// 3. 작업
		char yoil = getYoil(year, month, day);

		// 4. ModelAndView에 작업 결과 저장
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);

		// 5. 결과를 보여줄 View 지정
		mv.setViewName("yoil");
		
		// 6. ModelAndView를 반환
		return mv;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}