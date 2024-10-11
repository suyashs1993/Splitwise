package entity;

public class Day {

    public Day(Integer year, Integer day, Integer month) {
        this.year = year;
        this.day = day;
        this.month = month;
    }

    private final Integer year;
    private final Integer day;
    private final Integer month;

    public Integer getYear() {
        return year;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public String getDayString(){
        return year + "-" + month +  "-"+ day;
    }

}
