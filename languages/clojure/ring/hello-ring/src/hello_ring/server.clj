(ns hello-ring.server
  (:use hello-ring.core
        ring.adapter.jetty))

(run-jetty app {:port 3000})