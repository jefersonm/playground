package com.jefersonm.apache.camel;

import org.apache.camel.Exchange;
import org.apache.camel.NoTypeConversionAvailableException;
import org.apache.camel.spi.DataFormat;

import java.io.*;
import java.util.stream.Collectors;

public class TextDataFormat implements DataFormat {

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) {
        try {
            String data = exchange.getContext().getTypeConverter().mandatoryConvertTo(String.class, graph);
            stream.write(data.getBytes());
        } catch (NoTypeConversionAvailableException | IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream input) {
        String text = "";
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            text = buffer.lines().collect(Collectors.joining("\n"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return text;
    }

}
