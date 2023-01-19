# Assignment 3: Software Quality Engineering
This is a repository for assignment 3 of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called opencart (https://www.opencart.com/).

OpenCart is an online store management system. It is PHP-based, using a MySQL database and HTML components. Support is provided for different languages and currencies. It is freely available under the GNU General Public License

## Installation
We installed a server called xampp.
We installed the openCart program.

## What we tested
We tested buying a product from the store and deleting a product from the store.

*User story:* An unregistered user buys a product

*Preconditions:* The product is available and in stock.

*Expected outcome:* The purchase was made successfully

*User story:* An admin deletes a product.

*Preconditions:*  The product is available and in stock.

*Expected outcome:* The deletion was made successfully
$$

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a BDD testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory.

## Results
u can see the results of the tests in the [results](https://drive.google.com/file/d/13QZAzntffq2b_9HXrfl7r1h98BDHClhZ/view?usp=share_link) url.
we can see in the video that at the moment that the admin deletes the product, the product is deleted from the store and the user can't buy it anymore.
and the driver crashes when the user tries to continue the process.
## Detected Bugs
We detected the following bugs:

1. Bug 1:
   1. General description: When a user is in the process of buying a product and in parallel an admin is deleting the same product, the program crashes and
      is not handling well with it.
   2. Steps to reproduce: user addes a product to the cart, go to checkout and starts entering personal details, and simultaneously an admin user deletes the product.
   3. Expected result: The admin or the user gets an error result that the product can not be deleted or purchased
   4. Actual result: the program crashes
   5. Link to the bug report: (you are encouraged to report the bug to the developers of the software)

