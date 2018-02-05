(ns my-website.views.common
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpartial layout [& content]
            (html5
              [:head
               [:title "my-website"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))

(defpage "/error" []
	{:status 500
	 :body "Oh no! An error has ocurred!!!"})