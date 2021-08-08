package csc142.train;

/**
 * Time class creates Time's object which is hour and minutes.
 * 
 * @author Viktoryia Simakova
 * @version 19 May 2020 
 */
public class Time
{
    public static final int HOURS_IN_DAY = 24;
    public static final int MINUTES = 60;
    public static final int TWO_DIGIT_TIME = 10;
    // instance variables
    private int hour;
    private int minute;

    /**
     * Constructor for Time object.
     * @param hour is hour of the day time in 24-format.
     * @param minute is minute of the day time.
     */
    public Time(int hour, int minute)
    {
        setHour(hour);
        setMinute(minute);
    }
    
    /**
     * Method gets hour.
     * @return returns hour.
     */
    public int getHour(){
        return this.hour;
    }
    
    /**
     * Method gets minute.
     * @return returns minute.
     */
    public int getMinute(){
        return this.minute;
    }
    
    /**
     * Method sets new hour.
     * @param hour is a new hour. 
     * @throws throws new IllegalArgumentException if input is out of range
     */
    public void setHour(int hour){
        if(hour<0||hour>=HOURS_IN_DAY){
            throw new IllegalArgumentException("Incorrect hour.");
        }
        this.hour = hour;
    }
    
    /**
     * Method sets new minute.
     * @param minute is a new minute. 
     * @throws throws new IllegalArgumentException if input is out of range
     */
    public void setMinute(int minute){
        if(minute<0||minute>=MINUTES){
            throw new IllegalArgumentException("Minutes is incorrect.");
        }
        this.minute = minute;
    }
    
    /**
     * Method calculates time which is between given one Time object and
     * other Time object.
     * @param otherTime is another Time object which this method uses to
     * calculate between this time and first created time.
     * @throws throws new IllegalArgumentException if input is null.
     * @return returns time between given one Time object and other Time 
     * object in hours and minutes.
     */
    public Time timeBetween(Time otherTime){
        if(otherTime==null){
            throw new IllegalArgumentException();
        }
        //gets this time
        int hour1 = getHour();
        int minute1 = getMinute();
        //gets another Time object
        int hour2 = otherTime.getHour();
        int minute2 = otherTime.getMinute();
        //calculates difference between hours
        int resultHour = hour2-hour1;
        if(resultHour<0){
            resultHour=HOURS_IN_DAY-hour1+hour2;
        }
        //calculates differene between minutes
        int resultMinute = minute2-minute1;
        if(resultMinute<0){
            resultMinute=MINUTES-minute1+minute2;
            resultHour--;
        }
        return new Time(resultHour, resultMinute);//result
    }
    
    /**
     * Method calculates time which is between given one Time object and
     * other Time object.
     * @param otherTime is another Time object which this method uses to
     * calculate between this time and first created time.
     * @throws throws new IllegalArgumentException if input is null.
     * @return returns time between given one Time object and other Time 
     * object in minutes.
     */
    public int minBetween(Time otherTime){
        if(otherTime==null){
            throw new IllegalArgumentException();
        }
        //gets this time
        int min1 = this.hour*60 + this.minute;
        int min2 = otherTime.getHour()*60 + otherTime.getMinute();
        int difMinute = min2-min1;
        return difMinute;//result
    }
    
    /**
     * Methos checks if the time consist of two digits or not. If it consists
     * of one digit ig adds "0" in front of this digit.
     * @param time is hour or minute of the Time object.
     * @throws throws new IllegalArgumentException if input is out of range.
     */
    public String zeroTime(int time){
        if(time<0){
            throw new IllegalArgumentException();
        }
        String result = "";
        if(time<TWO_DIGIT_TIME){
            result = "0"+time;
        }else{
            result += time;
        }
        return result;
    }
    
    /**
     * Method returns state(full information)about Time object.
     * @return returns state(full information)about Time object.
     */
    public String toString(){
        return zeroTime(hour)+":"+zeroTime(minute);
    }
}
