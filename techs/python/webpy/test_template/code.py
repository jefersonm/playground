# Importing web.py library
import web

# Specifying the templates directory
render = web.template.render('templates/')

# URL structure that webpy will use
urls = (
	'/(.*)', 'index'
)

class index:
	def GET(self, name):
	    return render.index(name)


#
# Specifying the urls and a way to tell web.py to start serving web pages
#
if __name__ == "__main__":
    app = web.application(urls, globals())
    app.run()