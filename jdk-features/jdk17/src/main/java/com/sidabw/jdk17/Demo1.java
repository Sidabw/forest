package com.sidabw.jdk17;

/**
 * @author shaogz 2023/5/6 16:17
 */
public class Demo1 {
    public static void main(String[] args) {
        String a = """
            {
              	"name": "dddd",
              	"liveScene": "largeClass",
              	"viewMode": "standard",
              	"rebroadcast": {
              		"switchOpen": false
              	},
              	"multiVoice": {
              		"switchOpen": false
              	},
              	"host": {
              		"switchOpen": false
              	},
              	"roomTemplate": 1,
              	"liveStartTimeOpen": false,
              	"pushing": {
              		"mode": "clientPushing"
              	},
              	"mobileViewMode": 1
              }
            """;

        System.out.println(a);
    }
}
