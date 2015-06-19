package org.localtion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;


public class IPLocationFinder {
	public static void main(String[] args){
/*		 if(args.length !=1){
			 System.out.println("You need to pass only one param");
		 }else{
			 String ipAddress = args[0];
			 GeoIPService ipService = new GeoIPService();
			 GeoIPServiceSoap geoIPserviceSoap = ipService.getGeoIPServiceSoap();
			 GeoIP geoIp = geoIPserviceSoap.getGeoIP(ipAddress);
			 System.out.println(geoIp.getCountryName());
		 }*/
		
		String videoUrl = "https://www.youtube.com/embed/Ch-Gn9EVn_c?rel=0&amp;wmode=transparent&amp;autoplay=true&amp;showinfo=0&amp;rel=0";
		String videoId = "";
		try {
				Pattern p = Pattern.compile("v=([^&?]+)|youtu.be/([^&?]+)|embed/([^&?]+)|v/([^&?]+)");
				Matcher m = p.matcher(videoUrl);
				while (m.find()) {
					for (int i = 1; i <= m.groupCount(); i++) {
						String v = m.group(i);
					    if (v != null && !v.isEmpty()){
					    	videoId = v;
						}
					}
				}		
			} catch (PatternSyntaxException ex) {}
		System.out.println(videoId);
	}
}