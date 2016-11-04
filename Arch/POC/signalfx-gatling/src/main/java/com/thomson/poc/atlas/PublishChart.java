package com.thomson.poc.atlas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.thomson.poc.pojo.MetricOutput;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class PublishChart {

    private Logger log = Logger.getLogger(PublishChart.class);

    public void publish(List<MetricOutput> metrics) {
        metrics.forEach(this::sendToAtlas);
    }

    public void exportToPng() {
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:7101/api/v1/graph?q=metric,memory.free,:eq,:sum,(,name,),:by&s=e-10m&tz=Brazil/East");
        try {
            savePngToFile(httpclient.execute(httpGet));
        } catch (IOException e) {
            log.error("Error reading response from Atlas: " + e.getMessage());
        }
    }

    private HttpResponse sendToAtlas(MetricOutput metric) {
        HttpPost httpPost = new HttpPost("http://localhost:7101/api/v1/publish");
        httpPost.setHeader("Content-Type", "application/json");
        try {
            HttpClient httpclient = HttpClients.createDefault();
            httpPost.setEntity(new ByteArrayEntity(convertToJson(metric).getBytes("UTF-8")));
            return httpclient.execute(httpPost);
        } catch (IOException e) {
            log.error("Error trying to send data to Atlas: " + e.getMessage());
        }
        return null;
    }

    private void savePngToFile(HttpResponse response){
        try {
            InputStream atlasResponse = response.getEntity().getContent();
            OutputStream pngFile = new FileOutputStream("/Users/jefersonm/Desktop/atlas/metrics.png");

            IOUtils.copy(atlasResponse, pngFile);
        } catch (IOException e) {
            log.error("Error trying to create the metric output png file: " + e.getMessage());
        }
    }

    private String convertToJson(MetricOutput metric) {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return objectWriter.writeValueAsString(metric);
        } catch (JsonProcessingException e) {
            log.error("Error trying to marshal MetricOutput object: " + e.getMessage());
        }
        return "{}";
    }

}
