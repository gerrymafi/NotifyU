package zw.co.noityu.notifyu.entities;

/**
 * Created by Munyradzi on 07/01/2015.
 */
public class Classifieds {
    private String id;
    private String uploader;
    private double price;
    private String image;
    private String category;
    private String description;
    private String contact;
    private String email;

    public Classifieds() {
    }

    public Classifieds(String id, String uploader, double price, String image, String category, String description, String contact, String email) {
        this.id = id;
        this.uploader = uploader;
        this.price = price;
        this.image = image;
        this.category = category;
        this.description = description;
        this.contact = contact;
        this.email = email;
    }

    public Classifieds(String uploader, double price, String image, String description, String category, String email, String contact) {
        this.uploader = uploader;
        this.price = price;
        this.image = image;
        this.description = description;
        this.category = category;
        this.email = email;
        this.contact = contact;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
