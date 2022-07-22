package com.spring.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
	
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. 입력
		String year  = request.getParameter("year");
		String month = request.getParameter("month");
		String day   = request.getParameter("day");
		
		// 2. 작업
		int yyyy = Integer.parseInt(year);
		int mm   = Integer.parseInt(month);
		int dd   = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // DAY_OF_WEEK 요일
		char yoil = " 일월화수목금토".charAt(dayOfWeek);   // 1: 일요일, 2: 월요일, 3: 화요일, 4: 수요일, 5: 목요일, 6: 금요일, 7: 토요일
		
		// 3. 출력
		response.setContentType("text/html");   // 브라우저에 서버에서 보내는 내용이 텍스트임을 알려주는 역할
		response.setCharacterEncoding("utf-8"); // 브라우저에 텍스트의 인코딩을 알려주는 역할
		PrintWriter out = response.getWriter(); // response객체에서 브라우저로의 출력 스트링을 얻는다.
		out.println(year + "년" + month + "월" + day + "일은 ");
		out.println(yoil + "요일 입니다.");

	}

}
