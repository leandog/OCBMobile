class MainScreen
	include Gametel
	button(:directions,:id=>"directions_button")
	button(:call,:id=>"call_button")
	view(:contacts,:id=>"contact_menu")
	view(:menu,:id=>"menu_view")
end
