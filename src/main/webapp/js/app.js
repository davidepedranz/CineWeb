$(document).ready(function(){
  $(".button-collapse").sideNav();
});
(function() {
  'use strict';

  var app= angular.module('Main', ['PlaysModule']);
  app.controller('TabController', function() {

    this.tab = -1;

    this.setTab = function (tab) {

      if (this.tab == tab ) {
        // hide side-div
        $('.side-div').addClass('hide').css({width:"0%"});
        this.tab = -1;
      } else {

        // show side-div
        $('.side-div').removeClass('hide').css({width:"30%"});
        this.tab = tab;
      }


    };
    this.isSet = function (Value) {
      return this.tab === Value;
    };





  });



})();
