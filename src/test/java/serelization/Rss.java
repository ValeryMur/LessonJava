package serelization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by valeria on 10.02.2017.
 */

@XmlRootElement(name="rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rss {


    @XmlElement(name="channel")
    public Channel channel;

    @Override
    public String toString() {
        return "Rss{" +
                "channel=" + channel +
                '}';
    }

}
