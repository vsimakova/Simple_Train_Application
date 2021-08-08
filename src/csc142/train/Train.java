package csc142.train;

/**
 * Train class creates Train object which has name of the train, time of
 * departure, time of arrival, distance.
 * 
 * @author Viktoryia Simakova
 * @version 19 May 2020
 */
public class Train
{
    //constant
    public static final int MINUTES = 60;
    // instance variables
    private String name;
    private Time departure;
    private Time arrival;
    private int distance;

    /**
     * Constructor creates Train object.
     * @throws throws new IllegalArgumentException if input is empty.
     */
    public Train(String name, Time departure,Time arrival, int distance)
    {
        setDeparture(departure);
        setArrival(arrival);
        setDistance(distance);
        if(name==""){
            throw new IllegalArgumentException("No any name.");
        }
        this.name = name;
    }
    
    /**
     * Method gets departure time of train from St. Petersburg.
     * @return returns departure time of train from St. Petersburg.
     */
    public Time getDeparture(){
        return this.departure;
    }
    
    /**
     * Method gets arrival time of train to Moscow.
     * @return returns arrival time of train to Moscow.
     */
    public Time getArrival(){
        return this.arrival;
    }
    
    /**
     * Method gets distance from St.Petersburg to Moscow.
     * @return returns distance from St.Petersburg to Moscow.
     */
    public int getDistance(){
        return this.distance;
    }
    
    /**
     * Method sets Train's departure from St. Petersburg.
     * @param departure is Train's departure from St. Petersburg.
     * @throws throws new IllegalArgumentException if input is null.
     */
    public void setDeparture(Time departure){
        if(departure==null){
            throw new IllegalArgumentException("No time of departure.");
        }
        this.departure = departure;
    }
    
    /**
     * Method sets Train's arrival to Moscow.
     * @param departure is Train's arrival to Moscow.
     * @throws throws new IllegalArgumentException if input is null.
     */
    public void setArrival(Time arrival){
        if(arrival==null){
            throw new IllegalArgumentException("No time of arrival.");
        }
        this.arrival = arrival;
    }
    
    /**
     * Method sets Train's new distance.
     * @param departure is Train's new distance.
     * @throws throws new IllegalArgumentException if input is out of range.
     */
    public void setDistance(int distance){
        if(distance<0){
            throw new IllegalArgumentException("Distance must be positive.");
        }
        this.distance = distance;
    }
    
    /**
     * Method calculates average speed of a train based on given time and 
     * distance.
     * @return returns average speed of a train.
     */
    public int averageSpeed(){
        //gets time of travel
        Time timeBetween = travelTime();
        //converts to minutes
        int time = timeBetween.getHour();
        time=time*MINUTES;
        time += timeBetween.getMinute();
        //calculates average speed using distance divided by minutes
        double avSpeed = Math.round((double)distance/time*MINUTES);       
        return (int)avSpeed;
    }
    
    /**
     * Method gets travel time of a train.
     * @return returns travel time of a train.
     */
    public Time travelTime(){
        return departure.timeBetween(arrival);
    }
    
    /**
     * Method returns state(full information)about Train object.
     * @return returns state(full information)about Train object.
     */
    public String toString(){
        String result = name+"\n";
        result+=String.format("%-15s","Departure");
        result+=departure +"\n";
        result+=String.format("%-15s","Arrival");
        result+=arrival + "\n";
        result+=String.format("%-15s","Travel Time");
        result+=travelTime() + "\n";
        result+=String.format("%-15s","Average speed");
        result+=averageSpeed()+"km/h";
        return result;
    }
}
