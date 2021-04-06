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
    private weatherBean wBean;
    public OWservlet() {
    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityStr = request.getParameter("city");
        String countryStr = request.getParameter("country");
        
        wBean = new weatherBean(cityStr, countryStr);
        
        
        
      
        
        
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
				Cookie ckAllowCookie = new Cookie("allowCookies", "allow");
				ckAllowCookie.setMaxAge(20);
				response.addCookie(ckAllowCookie);
				
					//String cleanedUpValue = cookie.getValue().replaceAll("-", ",");
					
					
				}
			else {
					
				for(int i =0; i<cookies.length;i++) {
					if(cookies[i].getName().equals("JSESSIONID")){
						
					}else{
					System.out.print(cookies[i].getName());
					System.out.print("changing the max age");
					Cookie ckStreet = new Cookie(cookies[i].getName(),"removing" );
					ckStreet.setMaxAge(0);
					response.addCookie(ckStreet);
					
					
				}
			}}
			
			
		}catch (Exception e) {
			
			
		}
			
			
		try {
			
			if (request.getParameter("cookieChoice").equals("yes") ) {
				
				
				List<Cookie> allCookies = new ArrayList<Cookie>(6);
				Cookie[] cookies = request.getCookies();
				int foundMatchingCookie = 0;
				for ( int i = 0;i<cookies.length;i++) {
					System.out.print("adding cookie");
					allCookies.add(cookies[i]);
					
				}
				
				for(int i = 0;i < allCookies.size();i++){
					
					if(allCookies.get(i).getName().equals(cityStr)) {
						foundMatchingCookie++;
					}
				}
				
				if(foundMatchingCookie == 0 && allCookies.size()<6){
					createCookie(response,request);

				}
				
				
				
				
				

			} else {
				// do not create new cookies
			}
	}catch (Exception e) {
		System.out.println(e);
	}
        
        RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
        rd.forward(request, response);
    }
    public  void createCookie( HttpServletResponse response,HttpServletRequest request ){
    	
    	
    	String street = wBean.getCityStr();
    	String cloudsData = wBean.getCloudsStr();
    	String tempData = wBean.getTemperatureCelsius();
    	
    	String allDataForCookie = street + "#" + cloudsData + "#" + tempData;
		Cookie ckStreet = new Cookie(street,allDataForCookie );
		ckStreet.setMaxAge(200);
		response.addCookie(ckStreet);
		 
		
	}
    
  
    
    
  
    
    
}
