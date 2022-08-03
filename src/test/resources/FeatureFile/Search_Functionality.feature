Feature: To validate end to end search functionality of nobroker

Scenario: Verify search functionality for the multiple locality and description tag for the property

Given User Should Launch Browser and Load Url
When User Should Click on the Buy Property Option
And User Should Select Mumbai from DropDown Option
And User Should Enter the Value as Malad in Search Box and select multiple Location from DropDown
And User Should Click on Search button
Then User Should navigate to criteria page
When User Should Select Multiple BHK type from Filter
And User Should Scroll Down to listing of Property
And User Should Click on fourth Property
Then User Should navigate to fourth Property Details
When User Should scroll down upto Description section
And User Should check for Description section

