<div class="bs-callout bs-callout-danger">
 <h3>Database Configuration is Required</h3>
 <p>Before continuing please follow the steps below to configure your database connection and run the necessary migrations.</p>
 <ol>
   <li> Create the database for your application.
   <li> Update the connection parameters for the database in the <code>guestbook2.db.schema</code> namespace of your application.
   <li> Update the connection URL in the <code>project.clj</code> <code>:ragtime</code> settings with your database name and login.
   <li> Run <code>lein ragtime migrate</code> in the root of the application to create the tables.
   <li> Restart the application.
 </ol>
</div>

### Managing Your Middleware

Two middleware functions are provided by default in the `guestbook2.middleware` namespace.

* `log-request` - logs all requests using the debug level, to enable request loggin simple add it to the `development-middleware` vector
* `template-error-page` - provides friendly formatting for Selmer errors in dev mode

See the `:middleware` key of the `app` definition located in the `guestbook2.handler` namespace to manage the enabled middleware.

### Here are some links to get started

1. [HTML templating](http://www.luminusweb.net/docs/html_templating.md)
2. [Accessing the database](http://www.luminusweb.net/docs/database.md)
3. [Serving static resources](http://www.luminusweb.net/docs/static_resources.md)
4. [Setting response types](http://www.luminusweb.net/docs/responses.md)
5. [Defining routes](http://www.luminusweb.net/docs/routes.md)
6. [Adding middleware](http://www.luminusweb.net/docs/middleware.md)
7. [Sessions and cookies](http://www.luminusweb.net/docs/sessions_cookies.md)
8. [Security](http://www.luminusweb.net/docs/security.md)
9. [Deploying the application](http://www.luminusweb.net/docs/deployment.md)
