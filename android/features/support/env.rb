require 'gametel'

World(Gametel::Navigation)

server = Brazenhead::Server.new "./OCBMobile/bin/OCBMobile.apk"

class Driver
	  include Brazenhead
end

Before do
	  @driver = Driver.new
	    server.start "activity.MainActivity"
end

After do
	  server.stop
end
