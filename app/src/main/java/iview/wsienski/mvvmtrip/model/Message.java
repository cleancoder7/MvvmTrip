package iview.wsienski.mvvmtrip.model;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class Message {

    private String title;
    private String message;

    public Message(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
