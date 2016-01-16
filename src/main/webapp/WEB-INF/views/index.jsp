<%@ include file="partials/header.jsp"%>

<div ng-app="myapp">
	<div ng-controller="HelloController">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header" style="text-align: center; border-bottom: 0">
					<h1 id="typography" style="font-size: 60px">Search Engine</h1>
					<h4>
						Mouhamed Riadh BEN HMIDA & Mouhamed GHARSALLAH
						</h5>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-10">
				<div class=" bs-component">
					<form class="bs-component">
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" ng-model="query" type="text"> <span
									class="input-group-btn" >
									<button class="btn btn-default" type="submit" value="submit"
										ng-click="goSearch()">Search</button>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>
		<div class="container col-lg-10 col-md-offset-1" style="align-items: center;">
			<ul class="list-group ">
				<li ng-repeat="product in products">
					<div class=" panel panel-default row" >
						<div class="panel-body">
							<div class="panel-info col-md-10">
								<p>
									<strong>{{product.title}}</strong>
								</p>
								<p>{{product.price}} Chez <a href="{{product.url}}"> {{product.website}}</a> </p>
								<p>
									{{product.description}}
								</p>
							</div>
							<div class="panel-more1 col-md-2">
								<img class="img-responsive" src="{{product.image}}" />
						</div>
							</div>
							
					</div>
				</li>
			</ul>
		</div>
	</div>

	<script>
		angular.module("myapp", []).controller(
				"HelloController",
				function($scope, $http) {
					
					$scope.goSearch = function() {
						$scope.url = "${pageContext.request.contextPath}/find/"
								+ encodeURI($scope.query);
						$http({
							method : 'GET',
							url : $scope.url
						}).then(function successCallback(response) {
							$scope.products  = response.data;
							console.log(response.data)
						})
					};
				});
	</script>

	<%@ include file="partials/footer.jsp"%>