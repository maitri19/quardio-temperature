# Temperature API Application

This application provides 2 endpoints.

 1. To create the temperature in H2 database. 
 2.	To retrieve the aggregated temperature data hourly basis for given date/all the dates falling in date range. Provide the dates,
 	start date and end date to retrieve all the temperature readings averaging it hourly for each date in the range and returns the data
 	to be used in chart. The date should be provided in the ISO date format. Provide both the dates as same while retrieving the data for only 
 	one date hourly basis.

## Solution

The solution is built using Java 8, Springboot, REST, maevn and Junit. 
   
## How to run
	
    Extract the provided Zipped file.
    Go to project directory.
    mvn clean install
    mvn springboot:run

Swagger is enabled to test/run the API endpoints. 

Open URL http://localhost:8088/swagger-ui.html

Enjoy temperature reading!

