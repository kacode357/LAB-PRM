package com.example.lab_1_2_3;

public class Module {
    private String title;
    private String description;
    private String platform;
    private String imageURL;  // Ensure this field exists

    public Module(String title, String description, String platform, String imageURL) {
        this.title = title;
        this.description = description;
        this.platform = platform;
        this.imageURL = imageURL;  // Initialize the image URL
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getImageURL() {
        return imageURL;  // Return the image URL
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;  // Set the image URL
    }
}
