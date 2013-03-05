class MenuScreen
  include Gametel

  ITEM = 0
  DESCRIPTION = 1
  PRICE = 2

  button(:directions, :id => "directions_button")
  button(:call, :id => "call_button")

  def price(item)
    Gametel::Views::ListItem.new(platform, :text => item).text[PRICE]
  end

  def scroll_to_top
    (0..10).each do
      scroll_up
    end
  end
end
