angular.module('app').controller('HomeController', 
								['UserDetailService', '$routeParams', '$location', '$scope', 
								 function(UserDetailService, $routeParams, $location, $scope) {
									
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
				swal({
					title: "Login Failed!", 
					text: response.data.message, 
					type: "error",
					showConfirmButton: true,
					closeOnConfirm: true
				});
				$scope.user.password = ''
			}
		})
	}
}]);