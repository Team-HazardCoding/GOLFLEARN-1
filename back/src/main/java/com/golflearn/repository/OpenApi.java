package com.golflearn.repository;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class OpenApi {
	// exception try catch 해줘야함
	public String siguApi(String siguVal) throws Exception{
		String serviceKey = "44228818-3486-397D-A167-6B8B05C5ACEC";
		String domain = "www.golflearn.com/main.html";

		//각각의 정보를 넣어줍니다.
		StringBuilder urlBuilder = new StringBuilder("http://api.vworld.kr/req/data?service=data&request=GetFeature&data=LT_C_ADSIDO_INFO"); /* URL */

		urlBuilder.append("&" + URLEncoder.encode("key", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("domain", "UTF-8") + "=" + domain);
		urlBuilder.append("&" + URLEncoder.encode("attrFilter","UTF-8") + "=" + "ctprvn_cd:like:;");
		urlBuilder.append("&" + URLEncoder.encode("geometry","UTF-8") + "=" + "false");
		urlBuilder.append("&" + URLEncoder.encode("size","UTF-8") + "=" + 50);

		Map<String, Object> map = new HashMap<String, Object>();

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());

		ObjectMapper mapper = new ObjectMapper();
		String resultJSONStr = "";
		
		List<Map<String,String>> resultList = new ArrayList<>();

		Map<String, Object>response1 = (Map)mapper.readValue(conn.getInputStream(), Map.class);
		Map<String, Object> response = (Map)response1.get("response");
		Map<String,Object> geoJson =  (Map)response.get("result");
		Map<String,Map<String,String>> collections = (Map)geoJson.get("featureCollection");
		List <Map<String,Map<String,String>>> features = (List)collections.get("features");
		for(Map<String,Map<String,String>>feature: features) {
			Map<String,String>properties = feature.get("properties");
			Map<String, String> resultMap = new HashMap<>();
			resultMap.put(properties.get("ctprvn_cd"),	properties.get("ctp_kor_nm"));
			resultList.add(resultMap);
		}
		resultJSONStr = mapper.writeValueAsString(resultList);
		return resultJSONStr;
	}

	public String sidoApi(String sidoVal) throws Exception{
		String serviceKey = "44228818-3486-397D-A167-6B8B05C5ACEC";
		String domain = "www.golflearn.com/main.html";
		String sido = "full_nm"; //매개변수- 시도
		String sigu = "sig_kor_nm"; //매개변수- 시구
		String siguOrSidoVal = sidoVal;
		String fullNm = "";

		//각각의 정보를 넣어줍니다.
		StringBuilder urlBuilder = new StringBuilder("http://api.vworld.kr/req/data?service=data&request=GetFeature&data=LT_C_ADSIGG_INFO"); /* URL */

		urlBuilder.append("&" + URLEncoder.encode("key", "UTF-8") + "=" + serviceKey);
		urlBuilder.append("&" + URLEncoder.encode("domain", "UTF-8") + "=" + domain);
		urlBuilder.append("&" + URLEncoder.encode("attrFilter","UTF-8") + "=" + sido + ":like:");
		urlBuilder.append(URLEncoder.encode(siguOrSidoVal, "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("geometry","UTF-8") + "=" + "false");
		urlBuilder.append("&" + URLEncoder.encode("size","UTF-8") + "=" + 50);

		Map<String, Object> map = new HashMap<String, Object>();

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());

		ObjectMapper mapper = new ObjectMapper();
		String resultJSONStr = "";

		List<Map<String,String>> resultList = new ArrayList<>();

		Map<String, Object>response1 = (Map)mapper.readValue(conn.getInputStream(), Map.class);
		Map<String, Object> response = (Map)response1.get("response");
		Map<String,Object> geoJson =  (Map)response.get("result");
		Map<String,Map<String,String>> collections = (Map)geoJson.get("featureCollection");
		List <Map<String,Map<String,String>>> features = (List)collections.get("features");

		for(Map<String,Map<String,String>>feature: features) {
			Map<String,String>properties = feature.get("properties");
			Map<String, String> resultMap = new HashMap<>();
			resultMap.put(properties.get("sig_cd"),	properties.get("sig_kor_nm"));
			resultList.add(resultMap);
		}
		resultJSONStr = mapper.writeValueAsString(resultList);
		return resultJSONStr;
	}
	public static void main(String[] args) throws Exception {
		OpenApi api = new OpenApi();
		
		String test2Val = api.siguApi("서울");
		System.out.println(test2Val);
		
		String testVal = api.sidoApi("서울");
		System.out.println(testVal);
		
	}
}

