package com.jack.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.jack.json.service.JsonNodeReader;

/**
 * @author: Jack
 * @email: zengxijin@qq.com
 * @version: 1.0
 * @CreateDate: 2016-8-2 17:16:46
 * @Description: testcase of JsonNodeReader
 */
public class JsonNodeReaderTest {

	public static void main(String[] args) {
		
		String json = "[{\"key\": \"Content-Type\",\"value\": \"application/json\"},{\"key\": \"Authorization\",\"value\": \"Tocken asdlkhasutYJnsajdakseiuasyciaskdasld09wrjlsdfjsdyf==\"}]";
		JSONArray array = JSONObject.parseArray(json);
		System.out.println(array.size());
		
		//new JsonNodeReaderTest().test();
	}

	private final static String jsonStr= "{"
			+ "\"root\":{"
			+    "\"jack\""   + ":{\"location\":\"ShangHai,China\"},"
			+    "\"foo\""    + ":\"yep,I am a foo!\","
			+    "\"bigfun\"" + ":["
			+                     "{\"NBA\":\"Lakers\"},"
			+                     "{\"NFL\":\"Cowboys\"}"
			+                  "]"
			+ "}"
			+ "}";
	
	public void test(){
		JSONObject srcJson = JSONObject.parseObject(jsonStr);
		System.out.println(srcJson.toJSONString());
		
		//get the node of json object,then you can operate the key-value bye getXXX(key)
		JSONObject getObj = JsonNodeReader.getJsonObject(srcJson, "root.jack");
		System.out.println(getObj.toJSONString());
		
		//get the node of json array,then you can operate the child nodes of the array by using
		//for(int i=0;i=getArray.size();i++){JSONObject obj = getArray.getJSONObject(i);...}
		JSONArray getArray = JsonNodeReader.getJsonArray(srcJson, "root.bigfun");
		System.out.println(getArray.toJSONString());
		
	}
}
