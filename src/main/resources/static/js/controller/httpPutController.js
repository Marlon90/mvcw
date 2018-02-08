app.controller('HttpGetController', function($scope, $http) {

	$scope.sendJson = function() {
		var articleData = {
			number : $scope.articleNumber,
			name : $scope.articleName,
			cost : $scope.articleCost,
			price : $scope.articlePrice
		}
		
		c = document.getElementById("customConsole");
		
		$http.post("/save", articleData).then(function(data) {
			console.log('Success', data);
			c.value+= data.config.data.name + " has been inserted";  
		}, function(error) {
			console.log('ERROR', error);
			
			c.value += (error.data.message + "\n");
		})
	}
});