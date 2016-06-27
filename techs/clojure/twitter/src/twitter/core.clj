(ns twitter.core
  (:require [twitter :as twitter]
            [oauth.client :as oauth]))

;; Make a OAuth consumer
(def oauth-consumer
  (oauth/make-consumer "7KhiEFkUqWMySaS747Xt7g" ;; consumer key
                       "JnFs1kZCgmFqe0OZlqGUar5NZDmQrmSNFDayUjmvds" ;; consumer secret
                       "https://api.twitter.com/oauth/request_token"
                       "https://api.twitter.com/oauth/access_token"
                       "https://api.twitter.com/oauth/authorize"
                       :hmac-sha1))
(def oauth-access-token
  "229474714-8rCHl1cJ7lHXf1lsl2qQx5MFA03C1xBEGtJkWBqV")
(def oauth-access-token-secret
  "Bg0bO3Yk5x52Wico1XdvondMnJF0NLHNxM7k1zUZOM")

;; Show last tweets
(defn latest-tweets [count]
  (twitter/with-https
    (twitter/with-oauth
      oauth-consumer
      oauth-access-token
      oauth-access-token-secret
      (twitter/home-timeline :count (str count)))))

;; Find out who follows you
(defn print-follows [user]
	(twitter/followers-of-name (str user)))

;; Update your status (tweet)	
(defn tweet [message]
	(twitter/with-oauth
	    oauth-consumer
	    oauth-access-token
	    oauth-access-token-secret
	    (twitter/update-status (str message))))
	
	
	