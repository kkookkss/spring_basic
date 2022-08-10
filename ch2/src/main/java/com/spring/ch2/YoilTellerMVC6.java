package com.spring.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC6 {
    @ExceptionHandler(Exception.class)
	public String catcher(Exception ex, BindingResult result) {
		System.out.println("result= "+result);
		FieldError error = result.getFieldError();
		
		System.out.println("code= "+error.getCode());
		System.out.println("field= "+error.getField());
		System.out.println("msg = "+error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
    
    @RequestMapping("/getYoilMVC6") // http://localhost:8080/ch2/getYoilMVC6?year=2021&month=10&day=1
    public String main(MyDate date, BindingResult result) { 
    														  
    	System.out.println("result= "+result);

    	// 1. 유효성 검사 
    	if(!isValid(date))
    		return "yoilError";
    	
        // 2. 처리
//    	char yoil = getYoil(date);

    	// 3. Model에 작업한 결과를 저장 
        // @ModelAttribute 덕분에 MyDate를 저장안해도 됨. View로 자동 전달됨.
//      m.addAttribute("myDate", date);     	
//      m.addAttribute("yoil", yoil);        
        
      	// 4. 작업 결과를 보여줄 뷰의 이름을 반환  
      	return "yoil";
    }
    
    private @ModelAttribute("yoil") char getYoil(MyDate date) {
    	return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }

    private boolean isValid(MyDate date) {
    	return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
}