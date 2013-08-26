PADRINO_ENV = 'test' unless defined?(PADRINO_ENV)
require File.expand_path(File.dirname(__FILE__) + "/../config/boot")

# Specify your app using the #app helper inside a context.
# Takes either an app class or a block argument.
  include Mocha::API
# app { Padrino.application }
# app { MyProject.tap { |app| } }

class Riot::Situation
  include Mocha::API
  include Rack::Test::Methods
  ##
  # You can handle all padrino applications using instead:
  #   Padrino.application
  # Or just the Application itself like:
  #   MyProject.tap { |app|  }

  def app
    @app || Padrino.application
  end
end

class Riot::Context
  include Mocha::API
  # Set the Rack app which is to be tested.
  #
  #   context "MyApp" do
  #     app { [200, {}, "Hello!"] }
  #     setup { get '/' }
  #     asserts(:status).equals(200)
  #   end
  def app(app=nil, &block)
    setup { @app = (app || block.call) }
  end
end

