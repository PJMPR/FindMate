package domain.model;
import java.util.Date;

/**
 * Created by Mela on 2016-11-19.
 */
public class Like {


    private int likeId;
    private Date sendDate;
    private int likeFrom;
    private int likeTo;

    public int getLikeId() {return likeId;}

    public void setLikeId(int likeId) {this.likeId = likeId;}

    public Date getSendDate() {return sendDate;}

    public void setSendDate(Date sendDate) {this.sendDate = sendDate;}

    public int getLikeFrom() {return likeFrom;}

    public void setLikeFrom(int likeFrom) {this.likeFrom = likeFrom;}

    public int getLikeTo() {return likeTo;}

    public void setLikeTo(int likeTo) {this.likeTo = likeTo;}


}
