package utils;

import java.sql.Timestamp;
import java.util.Date;

public class FormatUtils {
	
	public static Date timeStampToDate(Timestamp toConvert){
		Date converted = null;
		
		if (toConvert != null){
			converted = new Date(toConvert.getTime());
		}
		
		return converted;
	}

}
