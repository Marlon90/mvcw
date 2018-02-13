app.controller('updateController', [ '$scope', '$http', '$route',
		function($scope, $http, $route) {
			$scope.sendJson = function() {
				arId = document.getElementById("articleId");
				arName = document.getElementById("articleName");
				arNumber = document.getElementById("articleNumber");
				arPrice = document.getElementById("articlePrice");
				arCost = document.getElementById("articleCost");
				var articleData = {
					id : arId.value,
					description : arName.value, 
					nummer : arNumber.value,
					price : arPrice.value,
					cost :  arCost.value
					
				}

				c = document.getElementById("customConsole");
				$scope.logger = function(articleData) {
					console.log(articleData);
				}

				$http.post('/update', articleData).then(function(response) {
					console.log('RESPONSE', response);
					c.value+= arName.value + " has been changed successfully \n"; 
					$route.reload();
				}, function(error) {
					console.log('ERROR', error);
					document.getElementById("customConsole").value+= error.data.message;
				})
			}
		} ]);