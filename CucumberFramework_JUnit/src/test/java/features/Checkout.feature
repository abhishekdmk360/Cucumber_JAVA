Feature: Place the order for Products

	@PlaceOrder
	Scenario Outline: User experience for product search and Place order
		Given User is on GreenCart Landing Page
		When User searched with shortname <Name> and extracted actual name of product
		And Adds "3" quantity of the selected product to cart
		And User proceeds to Checkout
		And Verify user has ability to enter promo code and place the order
		
		Examples:
		|Name|
		|Tom|