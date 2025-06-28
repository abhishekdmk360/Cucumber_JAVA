Feature: Search and Place the order for Products

	@OffersPage
	Scenario Outline: Search experience for product search in both Home and Offers page
		Given User is on GreenCart Landing Page
		When User searched with shortname <Name> and extracted actual name of product
		Then User searched for shortname <Name> in Offers page
		And Verify product name in Offers page matches with Landing Page
		
		Examples:
		|Name|
		|Tom|
#		|Straw|
		|Coco|