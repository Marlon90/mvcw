var app = angular.module("articleApp", [ "ngRoute" ]);
app.config(function($routeProvider) {
	$routeProvider.when("/welcome", {
		templateUrl : "views/welcome.html",
		controller : "articleController"

	}), $routeProvider.when("/description", {
		templateUrl : "views/description.html",
		controller : "articleController"

	}), $routeProvider.when("/all", {
		templateUrl : "views/all.html",
		controller : "articleController"

	}), $routeProvider.when("/add", {
		templateUrl : "views/add.html",
		controller : "articleController"

	}), $routeProvider.when("/change", {
		templateUrl : "views/change.html",
		controller : "articleController"

	}), $routeProvider.when("/delete", {
		templateUrl : "views/delete.html",
		controller : "articleController"

	});

});

