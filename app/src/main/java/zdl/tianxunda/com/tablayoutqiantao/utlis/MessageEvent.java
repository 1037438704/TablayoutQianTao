package zdl.tianxunda.com.tablayoutqiantao.utlis;

/**
 * Created by dell-pc on 2018/10/29.
 */

public class MessageEvent {

    private String message;

    private int name;
    private String nameID;

    public MessageEvent(String message){
        this.message=message;
    }

    public MessageEvent(int name, String nameID) {
        this.name = name;
        this.nameID = nameID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getNameID() {
        return nameID;
    }

    public void setNameID(String nameID) {
        this.nameID = nameID;
    }
}
