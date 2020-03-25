Feature: MyWishList

  Scenario: The user sees the wishlist empty
    Given No items have been added to the wishlist
    When The user navigates to My Wishlist page
    Then The user should see "NO PRODUCTS ADDED TO THE WISHLIST" message

#  Scenario: The user sees the items they had added in the wishlist
#    When The user adds item to their wishlist
#    And They navigate to My Wishlist page
#    Then the item should appear in the wishlist