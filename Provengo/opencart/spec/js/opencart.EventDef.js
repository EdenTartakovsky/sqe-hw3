/* @Provengo summon selenium */

/**
 *  The ComposeQuery event defines the selenium actions for login into the system as an admin
 */
defineEvent(SeleniumSession,"login",function (session,e){
  with(session){
    session.writeText("/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/div[1]/div/input", e.username);
    // write password
    session.writeText("/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/div[2]/div[1]/input", e.password);

    // click login button
    session.click("/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/div[3]/button");
  }
})
/**
 *  The ComposeQuery event defines the selenium actions for navigating to the products page
 */

defineEvent(SeleniumSession,"goToProducts",function (session,e){
  with(session){
    // click menu button
    session.click("/html/body/div[1]/header/div/button");

    // click Catalog button
    session.click("/html/body/div[1]/nav/ul/li[2]/a");

    // click Products button
    session.click("/html/body/div[1]/nav/ul/li[2]/ul/li[2]/a");
  }
})
/**
 *  The ComposeQuery event defines the selenium actions for choosing a product
 */

defineEvent(SeleniumSession,"chooseProduct",function(session,e){
  with(session){
    click("*[@id=\"form-product\"]/div[1]/table/tbody/tr[6]/td[1]/input");
  }
})
/**
 *  The ComposeQuery event defines the selenium actions for deleting a product
 */
defineEvent(SeleniumSession,"deleteProduct",function(session,e){
  session.click("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/table/tbody/tr[1]/td[1]/input");
})
defineEvent(SeleniumSession,"goToPhones",function(session,e){
  with(session){
   session.click("//*[@id=\"narbar-menu\"]/ul/li[6]/a");
  }
})

defineEvent(SeleniumSession,"selectProduct",function(session,e){
  with(session){
    session.click("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/form/div[1]/table/tbody/tr[6]/td[1]/input");
  }
})
defineEvent(SeleniumSession,"addProduct",function(session,e){
  with(session){
   session.click("//*[@id=\"button-cart\"]");
  }
})
defineEvent(SeleniumSession,"checkout",function(session,e){
  with(session){
   session.click("/html/body/nav/div/div[2]/ul/li[5]/a");
  }
})
defineEvent(SeleniumSession,"selectGuest",function(session,e){
  with(session){
   session.click("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[1]/div[1]/div[2]/input");
  }
})
defineEvent(SeleniumSession,"enterFirstName",function(session,e){
  with(session){
   session.writeText("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[2]/div[1]/input",e.name);
  }
})
defineEvent(SeleniumSession,"enterLastName",function(session,e){
  with(session){
   session.writeText("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[2]/div[2]/input",e.last_name);
  }
})
defineEvent(SeleniumSession,"enterEmail",function(session,e){
  with(session){
   session.writeText("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[1]/div[2]/div[3]/input",e.email);
  }
})
defineEvent(SeleniumSession,"enterAddress",function(session,e){
  with(session){
    session.writeText("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[2]/input",e.address);
  }
})
defineEvent(SeleniumSession,"enterCity",function(session,e){
  with(session){
   session.writeText("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[4]/input",e.city);
  }
})
defineEvent(SeleniumSession,"enterCountry",function(session,e){
  with(session){
   session.click("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[6]/select");
    session.click("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[6]/select/option[4]");
  }
})
defineEvent(SeleniumSession,"enterRegion",function(session,e){
  with(session){
    session.click("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[7]/select");
    session.click("/html/body/main/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/div[7]/select/option[2]");
  }
})
defineEvent(SeleniumSession,"clickContinue",function(session,e){
  with(session){
   session.click("/html/body/main/div[2]/div/div/div/div[1]/div/form/div/div[3]/button");
  }
})
defineEvent(SeleniumSession,"userEntersShippingMethod",function(session,e){
  with(session){
   session.click("/html/body/main/div[2]/div/div/div/div[2]/div[1]/form/fieldset/div/select");
    session.click("/html/body/main/div[2]/div/div/div/div[2]/div[1]/form/fieldset/div/select/optgroup/option");
  }
})
defineEvent(SeleniumSession,"userEntersPaymentMethod",function(session,e){
  with(session){
   session.click("/html/body/main/div[2]/div/div/div/div[2]/div[2]/form/fieldset/div/select");
   session.click("/html/body/main/div[2]/div/div/div/div[2]/div[2]/form/fieldset/div/select/option[2]");
  }
})
defineEvent(SeleniumSession,"clickConfirm",function(session,e){
  with(session){
    session.click("/html/body/main/div[2]/div/div/div/div[2]/div[3]/div[2]/div/button");
  }
})


