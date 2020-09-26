# Air Traffic Control (ATC)
The code here is to stimulate the air traffic control process.The ATC process has been simplified and is only for airplanes approaching to the airport, but not leaving the airport

## What does Air Traffic Control offer?
* GUI is implemented to improve user's experience
* Random generates 30 airplanes with its information such as flight number, distance to runway and elevation
* Allow user to add new airplane
* Using Heapsort algorithm to sort the Approach Code of all airplanes (higher Approach Code means higher priority to land the runway)
* Get the first ranked Approach Code, remove that airplane from the list and allow it to land imediately
* Allow emergency landing so that a specific airplane can land imediately by bumping its Approach Code to the highest

## Set up
1. Download the zip code file. The default name should be "Air_Traffic_Control-master.zip"
2. Extract file to the directory you want
3. Run "Quick_Run.jar" file to start the program
