/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webinfofrontend;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vylyb
 */
@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private int year,month,day;
    private int daysInYear=365,daysInMonth;

    private String taskText;

    public Task() {
    }
    
    public Task(int year, int month, int day, String taskText)
    throws InvalidTaskException {
        try {
            initDate(year, month, day);
        } catch (InvalidDateException ex) {
            throw new InvalidTaskException("Invalid Task: "+ex.getMessage());
        }
        
        if(taskText.length()<=0)
        {
            throw new InvalidTaskException("Invalid Task: Text is empty");
        }
        this.taskText = taskText;
    }
    
    public boolean isToday()
    {
        Calendar c=Calendar.getInstance();
        
        if(c.getTime().getYear()+1900!=year)
        {
            return false;
        }

        if(c.getTime().getMonth()+1!=month)
        {
            return false;
        }

        if(c.getTime().getDate()!=day)
        {
            return false;
        }
        return true;
    }

    public String getDateString() {
        return year+"-"+month+"-"+day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean isLeapYear() {
        return daysInYear==366;
    }

    public int getDaysInMonth() {
        return daysInMonth;
    }

    public int getDaysInYear() {
        return daysInYear;
    }

    public String getTaskText() {
        return taskText;
    }

    private void initDate(int year, int month, int day) 
    throws InvalidDateException 
    {
                if(year<2012)
        {
            throw(new InvalidDateException("Year must be at least 2012", year));
        }
        this.year = year;
        
        //leap year?
        if(year%4==0)
        {
            daysInYear=366;
        }
        
        if(month<1 || month>12)
        {
            throw(new InvalidDateException("Month must be between 1 and 12", month));
        }
        
        this.month = month;
        
        //how many days are in that month
        if(month==2)
        {
            //special treatment for february
            if(isLeapYear())
            {
                daysInMonth=29;
            }
            else
            {
                daysInMonth=28;
            }
        }
        else
        {
            //april, june, september, november
            if(month==4 || month==6 || month==9 || month==11)
            {
                daysInMonth=30;
            }
            //january, march, may, july, august, october, december
            else
            {
                daysInMonth=31;
            }
        }
        
        if(day<1 || day>daysInMonth)
        {
            throw(new InvalidDateException("Day must be between 1 and "+daysInMonth, day));
        }
        this.day = day;

    }
    
}
