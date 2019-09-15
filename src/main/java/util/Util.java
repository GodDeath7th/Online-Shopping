package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Util {



    public static String getId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }




    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static String getItemNO(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

}
