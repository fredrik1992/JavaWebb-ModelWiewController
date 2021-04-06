<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">
<script
	src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<link rel="stylesheet" href="showWeather.css">
	
	<script src="Index.js"></script> 
</head>
<body>
	
<%@ include file="Header.jsp" %>  
	
	<section class="page-section portfolio" id="portfolio">
	
		<div class = "cookieChoice"></div> <!-- this element is hidden -->
		<%
		//if(document.getElementByID)
		
		%>
		
		<div>

			
			<form action="OWservlet" method="get">
			
			<input type = "hidden" name = "cookieChoice" id = "cookieChoice">

				<label class="mdc-text-field mdc-text-field--filled"> <span
					class="mdc-text-field__ripple"></span> <span
					class="mdc-floating-label" id="my-label-id">City</span> <input
					class="mdc-text-field__input" type="text" name="city"
					aria-labelledby="my-label-id"> <span
					class="mdc-line-ripple"></span>
					
				</label> <label class="mdc-text-field mdc-text-field--filled"> <span
					class="mdc-text-field__ripple"></span> <span
					class="mdc-floating-label" id="my-label-id"></span> <input
					class="mdc-text-field__input" type="text" name="country"
					aria-labelledby="my-label-id"> <span
					class="mdc-line-ripple"></span>
				</label>







				<div class="mdc-touch-target-wrapper">
					<input type="submit" value="submit"
						class="mdc-button mdc-button--touch"> <span
						class="mdc-button__ripple"></span> <span class="mdc-button__touch"></span>
					</input>
				</div>
			</form>


		</div>
	</section>




	 
	
		
		
</body>
</html>