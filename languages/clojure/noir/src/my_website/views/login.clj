(ns my-website.views.login
  (:require [my-website.views.common :as common]
            [noir.content.pages :as pages])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpage "/login" {:keys [name]}
	(common/layout
    	[:p (str "Welcome " name)]))

(defpage "/admin/test" {:keys [name]}
	(str "hello " name))