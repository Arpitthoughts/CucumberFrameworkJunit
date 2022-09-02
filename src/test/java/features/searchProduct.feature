Feature: Search and place the order for Products

@searchorder
Scenario Outline: Search Experience for product search in both home and offers page
Given User is on GreenCart Landing page
When User searched with username <productName> and extracted actual name of product
Then User searched for same shortname <productName> in offers page`
And Productname is offers page and homepage should be same

Examples:
| productName|
| Tom        |
| Beet       |