package bo;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by root on 12.12.15.
 */
public class DateAdapter extends XmlAdapter<String, Timestamp> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Override
    public Timestamp unmarshal(String v) throws Exception {
        return new Timestamp(dateFormat.parse(v).getTime());
    }

    @Override
    public String marshal(Timestamp v) throws Exception {
        return dateFormat.format(v);
    }
}
