(ns my-website.views.form
  (:require [my-website.views.common :as common]
            [noir.content.pages :as pages]
			[noir.response :as resp]
			[noir.validation :as vali])
			
  (:use noir.core
        hiccup.page-helpers
		hiccup.form-helpers))

  (defpartial layout [& content]
	(html5
		[:head
	     [:title "Forms"]]
	    [:body
	     content]))

  (defpartial error-item [[first-error]]
	[:p.error first-error])

  (defpartial user-fields [{:keys [firstname lastname]}]
  	(vali/on-error :firstname error-item)
	(label "firstname" "First name: ")
	(text-field "firstname" firstname)
	(vali/on-error :lastname error-item)
	(label "lastname" "Last name: ")
	(text-field "lastname" lastname))
	
  (defn valid? [{:keys [firstname lastname]}]
	(vali/rule (vali/min-length? firstname 5)
		[:firstname "Your first name must have more than 5 letters."])
	(vali/rule (vali/has-value? lastname)
		[:lastname "You must have a last name"])
	(not (vali/errors? :lastname :firstname)))

  (defpage "/user/add" {:as user}
  	(common/layout
		(form-to [:post "/user/add"]
				(user-fields user)
	            (submit-button "Add user"))))

  (defpage [:post "/user/add"] {:as user}
	(if (valid? user)
		(layout
			[:p "User added!"])    
		(render "/user/add" user)))
		
