# ITIS Timetable
Application for ITIS students to view their timetables in a convenient way. 

Original timetable content lies in the [google spreadsheet](https://docs.google.com/spreadsheets/d/1wDMuQdYC4ewmW6qSUPFN4VL5_0cxAnI03QcSbIHrla4/edit?usp=sharing). 
To parse it, I wrote a designated [Spring Boot application](https://github.com/Senex-x/itis-timetable-parser) — a convenient REST API that I utilize in this app. This way user always has the latest timetable version 
while still being able to view it offline thanks to the cache in the local database.

## Key features 
* Timetable content caching
* Automatic synchronization of local timetable data with the remote state
* Unwanted subjects can be hidden from the schedule
* Simple and user-friendly UI
* Dark theme

## Main screen
Main screen of the application displays daily schedule for the group picked by user. Horizontal scrolling allows to view schedule for each day of the timetable.

<img src="https://user-images.githubusercontent.com/66133985/167207963-681eb4b8-993d-40e4-a481-a3ae4ee09529.png" alt="Main screen light" width="350" /> <img 
src="https://user-images.githubusercontent.com/66133985/167208347-3d377d3d-8748-4507-a783-5afd75403d7d.png" alt="Main screen dark" width="350" />

## Group selection screen
<img src="https://user-images.githubusercontent.com/66133985/167212679-b8bb1a81-ca09-436a-a582-e276e69b619b.png" alt="Main screen light" width="350" /> 

## Subject info screen
<img src="https://user-images.githubusercontent.com/66133985/167211898-40527e17-3c95-487c-acb9-7c01f2f64127.png" alt="Main screen light" width="350" /> 

## Primary subject selection screen
Here the user can select their elective course or, as in this case, their english group, so that it appears in the schedule.

<img src="https://user-images.githubusercontent.com/66133985/167212266-5cad0b8e-9d10-40d9-995a-47523103505a.png" alt="Main screen light" width="350" /> 

## Other destinations
<img src="https://user-images.githubusercontent.com/66133985/167212942-2de336b6-cefc-422f-96ab-71888c76cb8f.png" alt="Main screen light" width="350" /> 
