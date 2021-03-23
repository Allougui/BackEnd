var app = angular.module('app',[]); 
app.controller('getcontroller', function($scope, $http, $location) {
  
  $scope.getfunction = function($scope,$http){
    // get URL
    var url = $location.absUrl() + "http://localhost:8181/api/tag/allTags";
    
    // do getting
    $http.get('url').then(function (response) {
      $scope.getDivAvailable = true;
      $scope.response = response.data;
    }, function error(response) {
      $scope.postResultMessage = "Error Status: " +  response.statusText;
    });
  }
});
