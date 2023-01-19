/* @provengo summon selenium */

/**
 * This story opens a new browser window, goes to the opencart admin page, logs in, goes to the products page, chooses a product and deletes it
 */
// story("eden",function (){
//   let eden = new SeleniumSession().start('http://localhost/opencart');
//   with(eden) {
//     goToPhones();
//     selectProduct();
//     addProduct();
//     checkout();
//     selectGuest();
//     enterFirstName({name: "user1"});
//     enterLastName({last_name: "user1_lastname"});
//     enterEmail({email:"user@gmail.com"});
//     enterAddress({address:"address1"});
//     enterCity({city:"city1"});
//     enterCountry();
//     enterRegion();
//     clickContinue();
//     userEntersShippingMethod();
//     userEntersPaymentMethod();
//     clickConfirm();
//   }
// })

story('admin delete a product when a user buys it in a process', function () {
  let eden = new SeleniumSession();//.start('http://localhost/opencart');
  let ziv = new SeleniumSession();//.start('http://localhost/opencart/adminDir/');
  with(eden) {
    goToPhones();
    selectProduct();
    addProduct();
    checkout();
    selectGuest();
    enterFirstName({name: "user1"});
    enterLastName({last_name: "user1_lastname"});
  }
    with(ziv){
      login({username:'admin',password:'1234'});
      goToProducts();
      deleteProduct();
    }
    with(eden){
    enterEmail({email:"user@gmail.com"});
    enterAddress({address:"address1"});
    enterCity({city:"city1"});
    enterCountry();
    enterRegion();
    clickContinue();
    userEntersShippingMethod();
    userEntersPaymentMethod();
    clickConfirm();
  }
})

