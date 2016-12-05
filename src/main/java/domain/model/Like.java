package domain.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mela on 2016-11-19.
 */
public class Like implements IHaveId{


    private int id;
    private Date sendDate;
    private int likeFrom;
    private int likeTo;

    private Date getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return date;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Date getSendDate() {
        sendDate = getDate();
        return sendDate;}

    public void setSendDate(Date sendDate) {this.sendDate = sendDate;}

    public int getLikeFrom() {return likeFrom;}

    public void setLikeFrom(int likeFrom) {this.likeFrom = likeFrom;}

    public int getLikeTo() {return likeTo;}

    public void setLikeTo(int likeTo) {this.likeTo = likeTo;}


}
