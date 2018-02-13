app.controller('deleteController', [
		'$scope',
		'$http',
		'$route',
		function($scope, $http, $route) {
			$scope.sendJson = function() {
				arId = document.getElementById("articleId");
				arName = document.getElementById("articleName").value;
				var articleData = {
					id : arId.value
				}

				c = document.getElementById("customConsole");
				$scope.logger = function(articleData) {
					console.log(articleData);
				}

				$http.post('/delete', articleData).then(
						function(response) {
							console.log('RESPONSE', response);
							c.value += arName
									+ " has been deleted successfully \n";
							$route.reload();
						}, function(error) {
							console.log('ERROR', error);
						})
			}
		} ]);
