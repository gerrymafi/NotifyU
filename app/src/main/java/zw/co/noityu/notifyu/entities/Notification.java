package zw.co.noityu.notifyu.entities;

import java.util.Date;

/**
 * Created by Munyradzi on 07/01/2015.
 */
public class Notification {
    private String category;
    private String header;
    private String message;
    private Date dateReceived;

    public Notification() {
    }

    public Notification(String category, Date dateReceived, String message, String header) {
        this.category = category;
        this.dateReceived = dateReceived;
        this.message = message;
        this.header = header;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
