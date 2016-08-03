angular.module('app').controller('HomeController', 
								['UserDetailService', '$routeParams', '$location', '$scope', 
								 function(UserDetailService, $routeParams, $location, $scope) {
//	$(document).ready(function() {
//		setTimeout(function(){
//			$('.back').each(function(index, element){ $(element).css('background-color', 'red') });
//		}, 2000);
//	})
	
	this.login = function() {
		if ($routeParams.id != null) {
			$scope.user.num = $routeParams.id;
		}
		UserDetailService.getUserLogin($scope.user).then(function(response) {
			var loginUser = response.data.data
			if (loginUser != null) {
				if (loginUser.role === "admin") {	
					authenticated = 'admin'
					$location.url('/admin')
				} else {
					authenticated = 'user'
					$location.url('/user')
				}
			} else {
				authenticated = null
				$scope.user.password = ''
				sweetAlert("Login Failed", response.data.message, "error")
			}
		})
	}
}]);