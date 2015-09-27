package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
	
	public static Date timeStampToDate(Timestamp toConvert){
		Date converted = null;
		
		if (toConvert != null){
			converted = new Date(toConvert.getTime());
		}
		
		return converted;
	}
	
	public static Timestamp dateToTimestamp(Date toConvert){
		Timestamp converted = null;
		if (toConvert != null){
			converted = new Timestamp(toConvert.getTime());
		}
		
		return converted;
	}

}
