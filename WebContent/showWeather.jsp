<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" href="showWeather.css">
</head>
<body>


	<div class="pageWrapper">
		<%@ include file="Header.jsp"%>
		<div class = "mainBox" >
		<section class = "lastSearchedBox">
		
		
			<%
			Cookie[] cookies = request.getCookies();
	
				System.out.print(cookies.length);
				int numberToAddToClass = 0;
				for (int i  = 0 ;i< cookies.length; i++){
					
					if(cookies[i].getName().equals("allowCookies") ||  cookies[i].getName().equals("JSESSIONID")){
						
					}else{
						System.out.print(cookies[i].getName());
						String allValues = cookies[i].getValue();
						String city,cloud,temp;
						String[] valuesSplit = allValues.split("#"); 
						
						out.print("<div class = \"window"+ numberToAddToClass + "\"> <ul class = \"oldDataLists\"> <li>City:" + valuesSplit[0] + "<li>Cloud:" + valuesSplit[1] + "<li>Temp:" + valuesSplit[2] + "</div>" );
						numberToAddToClass ++;
						
						
					}
					
				}
				
				
				
				
			

				
		%>
		
		
		</section>
			<section class="weatherBox" class="border" >
			<img alt="weather" src="http://newsonair.com/writereaddata/News_Pictures/MIS/2020/May/NPIC-202053171519.jpg" class = "weatherImage" class="rounded">


				<!-- Icon Divider-->
			
						

						<%
						weatherBean wBean = (weatherBean) request.getAttribute("wBean");
						out.print("<ul class = \"dataList\" \"weatherData\"> <li> City:" + wBean.getCityStr() + " </li> <li> Clouds:"
								+ wBean.getCloudsStr() + " </li> </ul>");
						String cleanedTemp = wBean.getTemperatureCelsius().replaceAll("-",",");
						out.print("<h2 class = \"tempTextCelsius\">" + cleanedTemp + "C" + "</h2>");

						//The weather " + wBean.getCityStr() + " is now a " + wBean.getCloudsStr() + "and the temp is" + wBean.getTemperatureCelsius());
						%>
				
			
				
			</section>
		</div>

	

       <div id = "lastSerchedData">
		
		</div>



		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
		
	<a href="Index.jsp">Go back</a>
	</div>

	
	<script src="showWeather.js"></script>

</body>
</html>