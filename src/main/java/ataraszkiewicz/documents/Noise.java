package ataraszkiewicz.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "noises")
public class Noise {

    @Id private String id;

    private String averageSound;
    private String maxSound;
    private String zeroCount;
    private String time;
    private Date currentDate;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAverageSound() {
        return averageSound;
    }

    public void setAverageSound(String averageSound) {
        this.averageSound = averageSound;
    }

    public String getMaxSound() {
        return maxSound;
    }

    public void setMaxSound(String maxSound) {
        this.maxSound = maxSound;
    }

    public String getZeroCount() {
        return zeroCount;
    }

    public void setZeroCount(String zeroCount) {
        this.zeroCount = zeroCount;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " " + description;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
