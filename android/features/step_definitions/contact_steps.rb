Given /^I'm hungry for some OCB$/ do
end

Then /^I should see "(.*?)"$/  do |text|
	on(MainScreen).has_text?(text).should == true
end

Given /^I want to connect with Ohio City Burrito$/ do
end

When /^I touch the connect dropdown$/ do
	on(MainScreen).contacts
end
