package com.noordeep.visa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VisaService {

    private final RestTemplate restTemplate;

    @Autowired
    public VisaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getVisaWaitTimes() {
        String url_mumbai = "https://travel.state.gov/content/travel/resources/database/database.getVisaWaitTimes.html?cid=P139&aid=VisaWaitTimesHomePage";
        String url_delhi = "https://travel.state.gov/content/travel/resources/database/database.getVisaWaitTimes.html?cid=P147&aid=VisaWaitTimesHomePage";
        String url_hyderabad = "https://travel.state.gov/content/travel/resources/database/database.getVisaWaitTimes.html?cid=P85&aid=VisaWaitTimesHomePage";
        String url_chennai = "https://travel.state.gov/content/travel/resources/database/database.getVisaWaitTimes.html?cid=P48&aid=VisaWaitTimesHomePage";
        String url_kolkata = "https://travel.state.gov/content/travel/resources/database/database.getVisaWaitTimes.html?cid=P100&aid=VisaWaitTimesHomePage";
        String mumbai = restTemplate.getForObject(url_mumbai, String.class);
        String delhi = restTemplate.getForObject(url_delhi, String.class);
        String hyderabad = restTemplate.getForObject(url_hyderabad, String.class);
        String chennai = restTemplate.getForObject(url_chennai, String.class);
        String kolkata = restTemplate.getForObject(url_kolkata, String.class);
        return "Mumbai : " + trimmer(mumbai) + "<br>" +"Delhi : " + trimmer(delhi) + "<br>" + "hyderabad : " + trimmer(hyderabad) + "<br>" + "chennai : " + trimmer(chennai) + "<br>" + "kolkata : " + trimmer(kolkata);
    }

    public String trimmer(String value){
        String regex = "(\\d+ Days)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            String result = matcher.group(1); // Get the matched group
            return result;
        } else {
            return value;
        }
    }
}
