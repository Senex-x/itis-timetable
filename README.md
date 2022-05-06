# ITIS Timetable
Application for ITIS students to view their timetables in a convenient way. 

Original timetable content is placed in the [google table](https://docs.google.com/spreadsheets/d/1wDMuQdYC4ewmW6qSUPFN4VL5_0cxAnI03QcSbIHrla4/edit?usp=sharing). 
For its parsing I've created my own designated 
[Spring Boot application](https://github.com/Senex-x/itis-timetable-parser) where the parsing logic located. This service has
a convinient REST API, that I utilize in my application via Retrofit library. This way my app always has the latest timetable updates 
while still caching schedules in a local database to display them when there is no internet access.

## Key features 
* Automatic syncronization of local timetable data with remote state
* Timetable data caching
* The ablilty to hide unnecessary subjects from the schedule
* Simple and clear UI
* Dark theme

## Main screen
The main screen of the application, that displays daily schedule for the selected group. Horisontal scrolling allows the user 
to view every daily schedule of his timetable. 

<img src="https://user-images.githubusercontent.com/66133985/167207963-681eb4b8-993d-40e4-a481-a3ae4ee09529.png" alt="Main screen light" width="350" /> <img 
src="https://user-images.githubusercontent.com/66133985/167208347-3d377d3d-8748-4507-a783-5afd75403d7d.png" alt="Main screen dark" width="350" />

## Group selection screen
<img src="https://user-images.githubusercontent.com/66133985/167212679-b8bb1a81-ca09-436a-a582-e276e69b619b.png" alt="Main screen light" width="350" /> 

## Subject info screen
<img src="https://user-images.githubusercontent.com/66133985/167211898-40527e17-3c95-487c-acb9-7c01f2f64127.png" alt="Main screen light" width="350" /> 

## Primary subject selection screen
Here the user can select their elective course or, as in this case, the english group, so that it appears in the schedule as the primary one.

<img src="https://user-images.githubusercontent.com/66133985/167212266-5cad0b8e-9d10-40d9-995a-47523103505a.png" alt="Main screen light" width="350" /> 

## Miscellaneous destinations
<img src="https://user-images.githubusercontent.com/66133985/167212942-2de336b6-cefc-422f-96ab-71888c76cb8f.png" alt="Main screen light" width="350" /> 
