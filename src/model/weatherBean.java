package model;

import java.text.DecimalFormat;

public class weatherBean {
    private String cityStr;
    private String countryStr;
    private String cloudsStr;
    private String temperatureCelsius;

    public weatherBean(String cityStr, String countryStr) {
        this.cityStr = cityStr;
        this.countryStr = countryStr;
    }

    public String getCityStr() {
        return this.cityStr;
    }

    public String getCountryStr() {
        return this.countryStr;
    }

    public String getCloudsStr() {
        return this.cloudsStr;
    }
    public String getTemperatureCelsius() {
    	return this.temperatureCelsius;
    }

    public void setCloudsStr(String cloudsStr) {
        this.cloudsStr = cloudsStr;
    }
    public void setTempCelsius(double temperatureCelsius) {
    	DecimalFormat numberFormat = new DecimalFormat("#0.00");
    	String tempToTwoDecimals =  numberFormat.format(temperatureCelsius);
    	System.out.print(temperatureCelsius);
    	tempToTwoDecimals  = tempToTwoDecimals.replaceAll(",", "-");
    	System.out.print(tempToTwoDecimals);
    	this.temperatureCelsius = tempToTwoDecimals;
    	
    	
    }
    
}