# Overview
The project focuses on economic analysis of two countries India and USA. We have predicted certain indicators that are required for determining economic growth of a country. Based on the values of economic indicators, we have predicted whether we will face any recession in upcoming 10 years for both countries. Also, we have compared two economies.

# Steps:
1)   Data Scraping and wrangling
2)   Missing Values
3)   Parameter Selection
4)   Building Models
5)   Deploying Web Service
6)   Deploy application on cloud 

---
# 1) Data Scraping and wrangling
Firstly, we did research on the economy indicators. We determined what all indicators can impact an economy of a nation. We scraped the data from https://fred.stlouisfed.org/. 

We have used library fredr and api key is created on fred.stlouis website. Fredr method is used to scrape data from website where we have mentioned the start date, end date and frequency = ”quarter”. We have taken data quarterly for all the selected indicators.

<img src ="extras/screenshots/img1.PNG" />

# 2) Missing Values
Some of the data was not available for inflation rate and unemployment rate. To fill in the missing inflation rates values, we have taken percent change of cpi between two quarters to determine inflation rate for the present quarter.

<img src = "extras/screenshots/img2.PNG" />

The missing unemployment rate was taken as mean of the column: 
<img src = "extras/screenshots/img3.PNG" />


# 3) Parameter Selection:
We founded one new parameter selection package “Boruta” package. Boruta is a feature selection algorithm. Precisely, it works as a wrapper algorithm around Random Forest.

**How it Works?**

1.  Firstly, it adds randomness to the given data set by creating shuffled copies of all features (which are called shadow features).
2.  Then, it trains a random forest classifier on the extended data set and applies a feature importance measure (the default is Mean Decrease Accuracy) to evaluate the importance of each feature where higher means more important.
3.  At every iteration, it checks whether a real feature has a higher importance than the best of its shadow features (i.e. whether the feature has a higher Z score than the maximum Z score of its shadow features) and constantly removes features which are deemed highly unimportant.
4.  Finally, the algorithm stops either when all features gets confirmed or rejected or it reaches a specified limit of random forest runs.

<img src = "extras/screenshots/img4.PNG" />

The graph is plotted where green boxes indicate the important parameters, yellow represents average indicators and blue, red shows those indicators that are do not have any importance in predicting recession.
Based on the above graph, we have selected those parameters that are green boxes as they have more significance.

# Predicting the economic indicators for 10 years:
As our dataset is time series, we have used ARIMA model. ARIMA model is used for 
When dealing with ARIMA models, we have to follow 4 steps:
1.  Visualize the time series
2.  Stationarize the time series
3.  Plot ACF/PACF charts and find optimal parameters
4.  Build the ARIMA model
5.  Make predictions

Step 1: Visualize the time series
It is essential to analyze the trends prior to building any kind of time series model. The details we are interested in pertains to any kind of trend, seasonality or random behaviour in the series. In our dataset we have examined seasonal pattern.

Step2: Stationarize the time series
We need to check if the series is stationary or not. Generally the series should be stationary because time series models work accurate when the series is stationary.
To check that we have to see ACF/PACF charts.

Step3: ACF/PACF charts

<img src = "extras/screenshots/img5.PNG" />

The above graph shows the declining graph which tells GDP is stationary 

Step 4: Build ARIMA models

We run auto.arima on train data to predict best model which will be in terms of (p,d,q). So our best model is ARIMA(2,2,2).

<img src = "extras/screenshots/img6.PNG" />

The below screenshot shows ar1, ar2 coefficients that mean our model is good as our values are below 1.
<img src = "extras/screenshots/img7.PNG" />

Now we have forecasted the values using our best model :
<img src = "extras/screenshots/img7.PNG" />


# Azure ML Time Series for forecasting:
<img src = "extras/screenshots/img8.PNG" />
