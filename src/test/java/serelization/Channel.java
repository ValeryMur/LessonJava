package serelization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by valeria on 10.02.2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
    @XmlElement(name="item")
    public Item[] item;
}
