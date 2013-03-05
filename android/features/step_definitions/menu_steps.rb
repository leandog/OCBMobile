Given /^I want to see what Ohio City Burrito serves$/ do
end

When /^I touch the menu sign$/ do
  on(MainScreen).menu
end

Then /^I should see the prices:$/ do |expected_items|
  actual_items = []
  expected_items.raw.each do |item, expected_price|
    price = on(MenuScreen).price item
    actual_items << [item, price]
  end
  expected_items.diff! actual_items
end

