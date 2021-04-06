package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GettheWeather;
import model.weatherBean;

@WebServlet({"/OWservlet"})
public class OWservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    public OWservlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityStr = request.getParameter("city");
        String countryStr = request.getParameter("country");
        
        
        
        
        
       weatherBean wBean = new weatherBean(cityStr, countryStr);
        
        
        GettheWeather.getWeather(wBean);
      //spara datan till cookies ?
        request.setAttribute("wBean", wBean);
        
        
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//behlöver hämta cookien sen lägga den i en array som jag kan gå igenom 
	
		
		//String n  = request.getParameter("cookieName");
		
		
		try {
			
			Cookie[] cookies = request.getCookies();
			if (request.getParameter("cookieChoice").equals("yes")) {
				
				if (cookies != null) {

					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("cityName")) {
							request.setAttribute("savedCity", cookie.getValue());

							// value can be retrieved using #cookie.getValue()
						}
						if (cookie.getName().equals("clouds")) {

							// let tempvalueArray = tempValue.split('=');
							// let text = document.createTextNode(tempvalueArray[1].replace("-"," "))

							// console.log(tempvalueArray[1].replace("-"," "));
							String cleanedUpValue = cookie.getValue().replaceAll("-", " ");
							request.setAttribute("savedClouds", cleanedUpValue);

							// value can be retrieved using #cookie.getValue()
						}
						if (cookie.getName().equals("temperature")) {

							String cleanedUpValue = cookie.getValue().replaceAll("-", ",");
							request.setAttribute("savedTemp", cleanedUpValue);

							// value can be retrieved using #cookie.getValue()
						}
					}
				}
			}else {
					
				for(int i =0; i<cookies.length;i++) {
					
					cookies[i].setMaxAge(0);
					
				}
			}
			
			
		}catch (Exception e) {
			
			
		}
			
			
		try {
			
			if (request.getParameter("cookieChoice").equals("yes") ) {
				
				String street = wBean.getCityStr();

				Cookie ckStreet = new Cookie("cityName", street);
				ckStreet.setMaxAge(800);
				response.addCookie(ckStreet);

				String clouds = wBean.getCloudsStr();

				Cookie ckClouds = new Cookie("clouds", clouds);
				ckStreet.setMaxAge(800);
				response.addCookie(ckClouds);
			

				String temp = wBean.getTemperatureCelsius();
				Cookie ckTemp = new Cookie("temperature", temp);
				ckStreet.setMaxAge(800);
				response.addCookie(ckTemp);

			} else {
				// do not create new cookies
			}
	}catch (Exception e) {
		System.out.println(e);
	}
        
        RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
        rd.forward(request, response);
    }
    
  
    
    
  
    
    
}
