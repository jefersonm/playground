package com.jefersonm.apache.camel;

import com.codahale.metrics.MetricRegistry;
import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.MetricsComponent;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig extends CamelConfiguration {

    /**
     * Adding a RoutePolicy to monitor every route and expose monitoring statistics
     * through JMX (using CodaHale metrics).
     *
     * @param camelContext
     * @throws Exception
     */
    @Override
    protected void setupCamelContext(final CamelContext camelContext) throws Exception {
        MetricsRoutePolicyFactory factory = new MetricsRoutePolicyFactory();
        factory.setUseJmx(true);
        camelContext.addRoutePolicyFactory(factory);

        super.setupCamelContext(camelContext);
    }

    /**
     * Metric registry to be used by CodaHale metrics. It's going to be picked up by
     * MetricsRoutePolicyFactory that was set the camelContext based on bean name.
     *
     * @return metric registry
     */
    @Bean(name = MetricsComponent.METRIC_REGISTRY_NAME)
    public MetricRegistry getMetricRegistry() {
        return new MetricRegistry();
    }
}
