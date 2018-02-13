app.controller('articleController', [ '$scope', '$http',

function($scope, $http) {

	$scope.articleData = [];

	
	
	$scope.logger = function(articleData) {
		console.log(articleData);
	}

	$http.get('/articles').then(function(response) {
		console.log('RESPONSE', response);
		$scope.articleData = response.data
	}, function(error) {
		console.log('ERROR', error);
	})
} ]);
