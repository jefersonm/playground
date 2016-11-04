package com.thomson.poc.signalfx;

import com.signalfx.signalflow.SignalFlowTransport;
import com.signalfx.signalflow.WebSocketTransport;

public class SignalFlowCustomConnection {

    private String token;

    public SignalFlowCustomConnection(String token) {
        this.token = token;
    }

    public SignalFlowTransport getCustomConnection() {
        return new WebSocketTransport.TransportBuilder(token).setTimeout(10).build();
    }

}
