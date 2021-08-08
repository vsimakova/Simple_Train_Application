package csc142.train;

/**
 * Schedule class creates Schedule object which consists of distance and
 * array of trains.
 * 
 * CSC142
 * @author Viktoryia Simakova
 * @version 29 May 2020
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Schedule
{
    // instance variables 
    private Train[] trains;
    private int distance;

    /**
     * Constructor creates Schedule object using fillArray() method
     * @throws FileNotFoundException if no found file
     * @param fileName is name of file to read information
     */
    public Schedule(String fileName)throws FileNotFoundException
    {
        fillArray(fileName);
    }
    
    /**
     * Methods reads information from file and filles array 'trains'
     * with this information
     * @throws FileNotFoundException if no found file
     * @param fileName is name of file to read information
     */
    public void fillArray(String fileName)throws FileNotFoundException{
        //reads file
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        this.distance = input.nextInt();//filles first instance
        int numOfTrains = input.nextInt();//reads number of trains
        //filles array with trains objects
        trains = new Train [numOfTrains];
        String name;
        Time departure;
        Time arrival;
        for(int i=0; i<numOfTrains; i++){
            input.nextLine();
            name = input.nextLine();
            departure = new Time(input.nextInt(), input.nextInt());
            arrival = new Time(input.nextInt(), input.nextInt());
            trains[i]=new Train(name, departure, arrival, distance);
        }
        input.close();
    }
    
    /**
     * Method found fastest train
     * @return returns fastest train
     */
    public Train fastestTrain(){
        int length = trains.length;//how many trains we need to check
        Train fastest = trains[0];
        for(int i=1; i<length; i++){
            //compare travel time of every train with the travel time of
            //fastest train
            if(fastest.travelTime().minBetween(trains[i].travelTime())<0){
                fastest = trains[i];
            }
        }
        return fastest;
    }
    
    /**
     * Method sorts array of trains objects based on departure time
     */
    public void sortDeparture(){
        int length = trains.length;//how many trains in array
        //variables for converting departure time of every train in minutes
        int min;
        int min2;
        Train temp = trains[0];
        //bubble sorting
        for(int i=0; i<length; i++){
            for(int k=1; k< (length-i); k++){
                min = trains[k-1].getDeparture().getHour()*60;
                min += trains[k-1].getDeparture().getMinute();
                min2 = trains[k].getDeparture().getHour()*60;
                min2 += trains[k].getDeparture().getMinute();
                if(min>min2){//swap elements if found earliest time
                    temp = trains[k-1];
                    trains[k-1] = trains[k];
                    trains[k] = temp;
                }
            }
        }
    }
    
    /**
     * Method returns state(full information)about Schedule object.
     * @return returns state(full information)about Schedule object.
     */
    public String toString(){
        String result = "";
        int length = trains.length;
        for(int i=0;i<length; i++){
            result += trains[i].toString()+"\n\n";
        }
        return result;
    }
}