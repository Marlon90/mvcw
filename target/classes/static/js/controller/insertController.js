app.controller('insertController', [
		'$scope',
		'$http',
		'$route',
		function($scope, $http, $route) {
			$scope.sendJson = function() {
				arName = document.getElementById("articleName");
				arNumber = document.getElementById("articleNumber");
				arPrice = document.getElementById("articlePrice");
				arCost = document.getElementById("articleCost");
				var articleData = {
					nummer : arNumber.value,
					description : arName.value,
					cost : arCost.value,
					price : arPrice.value
				}

				c = document.getElementById("customConsole");

				$http.post("/save", articleData).then(
						function(data) {
							console.log('Success', data);
							c.value += arName.value
									+ " has been inserted successfully \n";
							$route.reload();
						}, function(error) {
							console.log('ERROR', error);

							c.value += (error.data.message + "\n");
						})
			}
		} ]);